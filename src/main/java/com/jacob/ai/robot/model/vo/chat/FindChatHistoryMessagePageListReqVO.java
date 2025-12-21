package com.jacob.ai.robot.model.vo.chat;

import com.jacob.ai.robot.model.common.BasePageQuery;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: Jacob
 * @Description: 查询对话历史消息
 * @Date: 2025/12/21 16:47
 * @Version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FindChatHistoryMessagePageListReqVO extends BasePageQuery {

    @NotBlank(message = "对话 ID 不能为空")
    private String chatId;

}
