package com.jianpiao.api.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CinemaFilmRequest {
    private String id;

    private String cinemaId;

    private String filmId;

    private String status;
}
