package com.jacob.ai.robot.model.vo.chat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: Jacob
 * @Description: 新建对话
 * @Date: 2025/12/9 22:34
 * @Version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NewChatRspVO {

    /**
     * 摘要
     */
    private String summary;

    /**
     * 对话 UUID
     */
    private String uuid;
}
