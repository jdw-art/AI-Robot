package com.jacob.ai.robot.model.vo.chat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @Author: Jacob
 * @Description: 查询对话历史消息
 * @Date: 2025/12/21 16:48
 * @Version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FindChatHistoryMessagePageListRspVO {
    /**
     * 消息 ID
     */
    private Long id;
    /**
     * 对话 ID
     */
    private String chatId;
    /**
     * 内容
     */
    private String content;
    /**
     * 消息类型
     */
    private String role;
    /**
     * 发布时间
     */
    private LocalDateTime createTime;

}
