package com.jacob.ai.robot.service;

import com.jacob.ai.robot.model.vo.chat.NewChatReqVO;
import com.jacob.ai.robot.model.vo.chat.NewChatRspVO;
import com.jacob.ai.robot.utils.Response;

/**
 * @Author: Jacob
 * @Description: 对话
 * @Date: 2025/12/9 22:37
 * @Version: 1.0
 */
public interface ChatService {

    /**
     * 新建对话
     * @param newChatReqVO
     * @return
     */
    Response<NewChatRspVO> newChat(NewChatReqVO newChatReqVO);

}
