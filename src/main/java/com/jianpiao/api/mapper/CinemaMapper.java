package com.jianpiao.api.mapper;

import com.jianpiao.api.model.dto.CinemaRequest;
import com.jianpiao.api.model.dto.CinemaResponse;
import com.jianpiao.api.model.entity.Cinema;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CinemaMapper {

    public Cinema toEntity(CinemaRequest cinemaRequest) {
        Cinema cinema = new Cinema();
        BeanUtils.copyProperties(cinemaRequest, cinema);
        return cinema;
    }

    public CinemaResponse toResponse(Cinema cinema) {
        CinemaResponse cinemaResponse = new CinemaResponse();
        BeanUtils.copyProperties(cinema, cinemaResponse);
        return cinemaResponse;
    }

    public List<CinemaResponse> toResponses(List<Cinema> cinemas) {
        return cinemas.stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }
}
