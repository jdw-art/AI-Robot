package com.jacob.ai.robot.controller;

import com.jacob.ai.robot.tools.DateTimeTools;
import com.jacob.ai.robot.tools.WeatherTools;
import jakarta.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.prompt.ChatOptions;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.deepseek.DeepSeekAssistantMessage;
import org.springframework.ai.deepseek.DeepSeekChatModel;
import org.springframework.ai.model.tool.ToolCallingChatOptions;
import org.springframework.ai.support.ToolCallbacks;
import org.springframework.ai.tool.ToolCallback;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

/**
 * @Author: Jacob
 * @Description: 工具调用
 * @Date: 2025/7/29 22:37
 * @Version: 1.0
 */
@RestController
@RequestMapping("/v13/ai")
public class ToolCallingController {

    @Resource
    private DeepSeekChatModel chatModel;

    @GetMapping(value = "/generateStream", produces = "text/html;charset=utf-8")
    public Flux<String> generateStream(@RequestParam(value = "message") String message) {
        // 将 DateTimeTools 注册到工具集中
        ToolCallback[] tools = ToolCallbacks.from(new DateTimeTools(), new WeatherTools());

        // 构建聊天选项配置，设置工具回调功能
        ChatOptions chatOptions = ToolCallingChatOptions.builder()
                .toolCallbacks(tools)
                .build();

        // 构建提示词
        Prompt prompt = new Prompt(new UserMessage(message), chatOptions);

        // 流式输出
        return chatModel.stream(prompt)
                .mapNotNull(chatResponse -> {
                    // 获取响应内容
                    DeepSeekAssistantMessage deepSeekAssistantMessage = (DeepSeekAssistantMessage) chatResponse.getResult().getOutput();
                    // 推理内容
                    String reasoningContent = deepSeekAssistantMessage.getReasoningContent();
                    // 推理结束后的正式回答
                    String text = deepSeekAssistantMessage.getText();

                    // 若推理内容有值，则响应推理内容，否则，说明推理结束了，响应正式回答
                    return StringUtils.isNotBlank(reasoningContent) ? reasoningContent : text;
                });
    }
}
