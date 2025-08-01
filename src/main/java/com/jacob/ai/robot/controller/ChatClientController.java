package com.jacob.ai.robot.controller;

import com.jacob.ai.robot.tools.DateTimeTools;
import com.jacob.ai.robot.tools.WeatherTools;
import jakarta.annotation.Resource;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

/**
 * @Author: Jacob
 * @Description: Chat Client 客户端
 * @Date: 2025/7/22 23:20
 * @Version: 1.0
 */
@RestController
@RequestMapping("/v2/ai")
public class ChatClientController {

    @Resource
    private ChatClient chatClient;

    /**
     * 普通对话
     * @param message
     * @return
     */
    @GetMapping("/generate")
    public String generate(@RequestParam(value = "message", defaultValue = "你是谁？") String message) {
        // 一次性返回结果
        return chatClient.prompt()
                .user(message)
                .call()
                .content();
    }

    /**
     * 流式对话
     * @param message
     * @return
     */
    @GetMapping(value = "/generateStream", produces = "text/html;charset=utf-8")
    public Flux<String> generateStream(@RequestParam(value = "message", defaultValue = "你是谁？") String message,
                                       @RequestParam(value = "chatId") String chatId) {
        // 流式输出
        return chatClient.prompt()
                .tools(new DateTimeTools(), new WeatherTools()) // Function Call
//                .system("请你扮演一名犬小哈 Java 项目实战专栏的客服人员")
                .user(message) // 提示词
                .advisors(a -> a.param(ChatMemory.CONVERSATION_ID, chatId))
                .stream()
                .content();
    }
}
