package com.jacob.ai.robot.model.vo.chat;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: Jacob
 * @Description: AI 聊天
 * @Date: 2025/12/10 22:51
 * @Version: 1.0
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AiChatReqVO {

    @NotBlank(message = "用户消息不能为空")
    private String message;

    /**
     * 对话 ID
     */
    private String chatId;

    /**
     * 联网搜索
     */
    private Boolean networkSearch = false;

    @NotBlank(message = "调用的 AI 大模型名称不能为空")
    private String modelName;

    /**
     * 温度值，默认为 0.7
     */
    private Double temperature = 0.7;

}
