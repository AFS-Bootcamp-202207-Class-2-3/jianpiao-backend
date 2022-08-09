package com.jianpiao.api.service;

import com.jianpiao.api.model.entity.CinemaFilm;
import com.jianpiao.api.repository.CinemaFilmRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CinemaFilmService {

    private final CinemaFilmRepository cinemaFilmRepository;

    public CinemaFilmService(CinemaFilmRepository cinemaFilmRepository) {
        this.cinemaFilmRepository = cinemaFilmRepository;
    }

    public List<CinemaFilm> getCinemaFilmsByFilmId(String filmId) {
        return cinemaFilmRepository.findByFilmId(filmId);
    }

}
