package com.jianpiao.api.exception;

public class UnAuthorizedException extends RuntimeException {

    public static final String DO_NOT_HAVE_DELETE_AUTHORIZATION = "Do not have delete authorization";

    public UnAuthorizedException(String message) {
        super(message);
    }
}
