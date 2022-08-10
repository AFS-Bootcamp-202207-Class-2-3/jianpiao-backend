package com.jianpiao.api.exception;

public class SeatNotExistsException extends RuntimeException {
    public static final String SEAT_NOT_EXISTS = "seat not exists";

    public SeatNotExistsException() {
        super(SEAT_NOT_EXISTS);
    }
}
