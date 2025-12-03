package com.jacob.ai.robot.controller;

import com.jacob.ai.robot.aspect.ApiOperationLog;
import com.jacob.ai.robot.utils.Response;
import org.springframework.web.bind.annotation.PostMapping;
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
public class ChatController {

    @PostMapping("/new")
    @ApiOperationLog(description = "新建对话")
    public Response<?> newChat() {
        return Response.success();
    }

}