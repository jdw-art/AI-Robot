package com.jacob.ai.robot.service.impl;

import com.jacob.ai.robot.domain.dos.ChatDO;
import com.jacob.ai.robot.domain.mapper.ChatMapper;
import com.jacob.ai.robot.model.vo.chat.NewChatReqVO;
import com.jacob.ai.robot.model.vo.chat.NewChatRspVO;
import com.jacob.ai.robot.service.ChatService;
import com.jacob.ai.robot.utils.Response;
import com.jacob.ai.robot.utils.StringUtil;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * @Author: Jacob
 * @Description: 对话
 * @Date: 2025/12/9 22:37
 * @Version: 1.0
 */
@Service
public class ChatServiceImpl implements ChatService {

    @Resource
    private ChatMapper chatMapper;

    /**
     * 新建对话
     *
     * @param newChatReqVO
     * @return
     */
    @Override
    public Response<NewChatRspVO> newChat(NewChatReqVO newChatReqVO) {
        // 用户发送的消息
        String message = newChatReqVO.getMessage();

        // 生成对话 UUID
        String uuid = UUID.randomUUID().toString();
        // 截取用户发送的消息，作为对话摘要
        String summary = StringUtil.truncate(message, 20);

        // 存储对话记录到数据库中
        chatMapper.insert(ChatDO.builder()
                .summary(summary)
                .uuid(uuid)
                .createTime(LocalDateTime.now())
                .updateTime(LocalDateTime.now())
                .build());

        // 将摘要、UUID 返回给前端
        return Response.success(NewChatRspVO.builder()
                .uuid(uuid)
                .summary(summary)
                .build());
    }
}
