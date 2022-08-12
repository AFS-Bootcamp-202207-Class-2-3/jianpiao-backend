package com.jianpiao.api.advice;

import cn.dev33.satoken.exception.NotLoginException;
import cn.dev33.satoken.exception.NotPermissionException;
import cn.dev33.satoken.exception.NotRoleException;
import com.jianpiao.api.exception.*;
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
        return Result.error(HttpStatus.UNAUTHORIZED.value(), "请登录");
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler({WrongLoginInfoException.class})
    public Result handleWrongLoginInfoException(Exception exception) {
        return Result.error(HttpStatus.UNAUTHORIZED.value(), exception.getMessage());
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler({NotRoleException.class, NotPermissionException.class, UnAuthorizedException.class})
    public Result handleNotRoleAndPermissionException(Exception exception) {
        return Result.error(HttpStatus.UNAUTHORIZED.value(), "不具备权限");
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({UserNotFoundException.class})
    public Result handleUserNotFoundException(Exception exception) {
        return Result.error(HttpStatus.NOT_FOUND.value(), exception.getMessage());
    }

    @ResponseStatus(HttpStatus.PRECONDITION_FAILED)
    @ExceptionHandler({WrongRegisterInfoException.class})
    public Result handleBusinessException(Exception exception) {
        return Result.error(HttpStatus.PRECONDITION_FAILED.value(), exception.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({ParamNotSatisfiedException.class, SessionException.class})
    public Result handleParamNotSatisfiedException(Exception exception) {
        return Result.error(HttpStatus.BAD_REQUEST.value(), exception.getMessage());
    }
}
