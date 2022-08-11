package com.jianpiao.api.exception;


public class FilmCinemaNotFoundException extends RuntimeException {
    public static final String FILM_CINEMA_NOT_FOUND = "Film_Cinema Not Found";

    @Override
    public String getMessage() {
        return FILM_CINEMA_NOT_FOUND;
    }
}
