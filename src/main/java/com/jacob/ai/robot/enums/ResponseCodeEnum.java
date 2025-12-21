package com.jacob.ai.robot.enums;

import com.jacob.ai.robot.exception.BaseExceptionInterface;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author: Jacob
 * @Description: 响应异常码
 * @Date: 2025/9/23 23:06
 * @Version: 1.0
 */
@Getter
@AllArgsConstructor
public enum ResponseCodeEnum implements BaseExceptionInterface {

    // ----------- 通用异常状态码 -----------
    SYSTEM_ERROR("10000", "出错啦，后台小哥正在努力修复中..."),
    PARAM_NOT_VALID("10001", "参数错误"),

    // ----------- 业务异常状态码 -----------
    CHAT_NOT_EXISTED("20000", "此对话不存在"),
    ;

    // 异常码
    private String errorCode;
    // 错误信息
    private String errorMessage;

}
