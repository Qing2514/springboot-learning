package com.example.controller.utils;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * ExceptionAdvice
 *
 * @author Qing2514
 * @since 0.0.1
 */
@RestControllerAdvice
public class ExceptionAdvice {
    // 拦截所有异常信息
    @ExceptionHandler(Exception.class)
    public Response doException(Exception e) {
        // 记录日志
        // 通知运维
        // 通知开发
        e.printStackTrace();
        return new Response("服务器故障，请稍后再试！");
    }
}
