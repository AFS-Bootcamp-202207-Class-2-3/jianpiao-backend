package com.jianpiao.api.exception;

public class SessionException extends RuntimeException {
    public static final String END_TIME_LESS_THAN_START_TIME = "End time can not be less than start time";
    public static final String TIME_CONFLICT = "Time Conflict";

    public SessionException(String message) {
        super(message);
    }
}
