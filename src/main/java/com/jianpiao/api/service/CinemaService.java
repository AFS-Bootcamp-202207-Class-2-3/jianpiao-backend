package com.jianpiao.api.service;

import com.jianpiao.api.exception.CinemaException;
import com.jianpiao.api.model.entity.Cinema;
import com.jianpiao.api.model.entity.CinemaFilm;
import com.jianpiao.api.repository.CinemaFilmRepository;
import com.jianpiao.api.repository.CinemaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class CinemaService {
    private final CinemaRepository cinemaRepository;

    private final CinemaFilmRepository cinemaFilmRepository;

    public CinemaService(CinemaRepository cinemaRepository, CinemaFilmRepository cinemaFilmRepository) {
        this.cinemaRepository = cinemaRepository;
        this.cinemaFilmRepository = cinemaFilmRepository;
    }

    public List<Cinema> getAllCinemas(String filmId) {
        if (Objects.nonNull(filmId)) {
            return cinemaFilmRepository.findByFilmId(filmId)
                    .stream()
                    .map(CinemaFilm::getCinema)
                    .collect(Collectors.toList());
        }
        return cinemaRepository.findAll();
    }

    public Cinema getCinemaById(String cinemaId) {
        return cinemaRepository.findById(cinemaId).orElseThrow(() -> new CinemaException(CinemaException.CINEMA_NOT_FOUND));
    }


}
