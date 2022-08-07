package com.jianpiao.api.exception;

/**
 * @Author: BaBy
 * @Date: 2022/8/6 23:47
 */
public class WrongLoginInfoException extends RuntimeException {
    public static final String WRONG_LOGIN_INFO = "Username or password incorrect.";

    @Override
    public String getMessage() {
        return WRONG_LOGIN_INFO;
    }
}
