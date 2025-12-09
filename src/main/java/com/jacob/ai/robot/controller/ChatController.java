package com.jacob.ai.robot.controller;

import com.jacob.ai.robot.aspect.ApiOperationLog;
import com.jacob.ai.robot.model.vo.chat.NewChatReqVO;
import com.jacob.ai.robot.service.ChatService;
import com.jacob.ai.robot.utils.Response;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Jacob
 * @Description: 对话
 * @Date: 2025/9/23 23:20
 * @Version: 1.0
 */
@RestController
@RequestMapping("/chat")
@Slf4j
public class ChatController {

    @Resource
    private ChatService chatService;

    @PostMapping("/new")
    @ApiOperationLog(description = "新建对话")
    public Response<?> newChat(@RequestBody @Validated NewChatReqVO newChatReqVO) {
        return chatService.newChat(newChatReqVO);
    }

}