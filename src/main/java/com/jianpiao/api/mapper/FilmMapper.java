package com.jianpiao.api.mapper;

import com.jianpiao.api.model.dto.FilmRequest;
import com.jianpiao.api.model.dto.FilmResponse;
import com.jianpiao.api.model.entity.Film;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class FilmMapper {

    public Film toEntity(FilmRequest filmRequest) {
        Film film = new Film();
        BeanUtils.copyProperties(filmRequest, film);
        return film;
    }

    public FilmResponse toResponse(Film film) {
        FilmResponse filmResponse = new FilmResponse();
        BeanUtils.copyProperties(film, filmResponse);
        return filmResponse;
    }

    public List<FilmResponse> toResponses(List<Film> films) {
        return films.stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }
}
