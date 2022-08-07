package com.jianpiao.api.advice;

import cn.dev33.satoken.exception.NotLoginException;
import cn.dev33.satoken.exception.NotPermissionException;
import cn.dev33.satoken.exception.NotRoleException;
import com.jianpiao.api.exception.WrongLoginInfoException;
import com.jianpiao.api.model.dto.Result;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Author: BaBy
 * @Date: 2022/8/7 12:01
 */
@RestControllerAdvice
public class GlobalControllerAdvice {
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler({NotLoginException.class})
    public Result handleNotLoginException(Exception exception) {
        return Result.error(HttpStatus.UNAUTHORIZED.value(), "未登录");
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler({WrongLoginInfoException.class})
    public Result handleWrongLoginInfoException(Exception exception) {
        return Result.error(HttpStatus.UNAUTHORIZED.value(), exception.getMessage());
    }
}
