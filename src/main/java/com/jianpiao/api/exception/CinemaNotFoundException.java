package com.jianpiao.api.exception;

/**
 * @Author: BaBy
 * @Date: 2022/8/11 10:49
 */
public class CinemaNotFoundException extends RuntimeException {
    public static final String CINEMA_NOT_FOUND = "cinema not found.";

    @Override
    public String getMessage() {
        return CINEMA_NOT_FOUND;
    }
}
