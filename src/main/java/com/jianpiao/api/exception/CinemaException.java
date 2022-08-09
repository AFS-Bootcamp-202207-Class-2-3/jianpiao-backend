package com.jianpiao.api.exception;

public class CinemaException extends RuntimeException{
    public static final String CINEMA_NOT_FOUND = "cinema not found!";

    public CinemaException(String message) {
        super(message);
    }
}
