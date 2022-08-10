package com.jianpiao.api.exception;

public class SeatAlreadySoldException extends RuntimeException {
    private static final String SEAT_ALREADY_SOLD = "seat already sold";

    public SeatAlreadySoldException() {
        super(SEAT_ALREADY_SOLD);
    }
}
