package com.jianpiao.api.exception;

/**
 * @Author: BaBy
 * @Date: 2022/8/6 23:47
 */
public class UserNotFoundException extends RuntimeException {
    public static final String USER_NOT_FOUND = "User not found.";

    @Override
    public String getMessage() {
        return USER_NOT_FOUND;
    }
}
