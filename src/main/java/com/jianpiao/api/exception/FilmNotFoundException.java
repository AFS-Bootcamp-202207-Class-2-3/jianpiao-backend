package com.jianpiao.api.exception;


public class FilmNotFoundException extends RuntimeException {
    public static final String USER_NOT_FOUND = "Film not found.";

    @Override
    public String getMessage() {
        return USER_NOT_FOUND;
    }
}
