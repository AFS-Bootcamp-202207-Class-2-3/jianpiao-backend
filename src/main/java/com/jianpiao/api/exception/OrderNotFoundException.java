package com.jianpiao.api.exception;

public class OrderNotFoundException extends RuntimeException{

    private static final String ORDER_NOT_FOUND = "ORDER NOT FOUND";

    public OrderNotFoundException() {
        super(ORDER_NOT_FOUND);
    }
}
