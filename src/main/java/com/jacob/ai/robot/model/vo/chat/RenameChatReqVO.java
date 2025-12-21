package com.jacob.ai.robot.model.vo.chat;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: Jacob
 * @Description: 对话重命名
 * @Date: 2025/12/21 17:08
 * @Version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RenameChatReqVO {

    @NotNull(message = "对话 ID 不能为空")
    private Long id;

    @NotBlank(message = "对话摘要不能为空")
    private String summary;

}
