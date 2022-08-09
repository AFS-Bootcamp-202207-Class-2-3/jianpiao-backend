package com.jianpiao.api.exception;

public class SessionNotFoundException extends RuntimeException{
    private static final String SESSION_NOT_FOUND = "ORDER NOT FOUND";

    public SessionNotFoundException() {
        super(SESSION_NOT_FOUND);
    }
}
