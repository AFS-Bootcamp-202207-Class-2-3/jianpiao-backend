package com.jianpiao.api.exception;

public class HallNotFoundException extends RuntimeException{

    public static final String HALL_NOT_FOUND = "hall not found";

    public HallNotFoundException() {
        super(HALL_NOT_FOUND);
    }
}
