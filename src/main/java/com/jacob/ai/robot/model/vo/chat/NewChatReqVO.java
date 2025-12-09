package com.jacob.ai.robot.model.vo.chat;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: Jacob
 * @Description: 新建对话
 * @Date: 2025/12/9 22:33
 * @Version: 1.0
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NewChatReqVO {

    @NotBlank(message = "用户消息不能为空")
    private String message;

}
