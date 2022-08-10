package com.jianpiao.api.service;

import com.jianpiao.api.exception.CinemaException;
import com.jianpiao.api.exception.FilmNotFoundException;
import com.jianpiao.api.model.entity.Cinema;
import com.jianpiao.api.model.entity.CinemaFilm;
import com.jianpiao.api.repository.CinemaRepository;
import com.jianpiao.api.repository.FilmCinemaRepository;
import com.jianpiao.api.repository.FilmRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CinemaService {
    public static final String STATUS_SHOWING = "showing";

    private final CinemaRepository cinemaRepository;

    private final FilmCinemaRepository filmCinemaRepository;

    private final FilmRepository filmRepository;

    public CinemaService(CinemaRepository cinemaRepository, FilmCinemaRepository filmCinemaRepository, FilmRepository filmRepository) {
        this.cinemaRepository = cinemaRepository;
        this.filmCinemaRepository = filmCinemaRepository;
        this.filmRepository = filmRepository;
    }

    public List<Cinema> getAllCinemas() {
        return cinemaRepository.findAll();
    }

    public Cinema getCinemaById(String cinemaId) {
        return cinemaRepository.findById(cinemaId).orElseThrow(() -> new CinemaException(CinemaException.CINEMA_NOT_FOUND));
    }

    public CinemaFilm saveRelatedFilmAndCinema(String filmId, String cinemaId, String status) {
        if (!filmRepository.existsById(filmId)) {
            throw new FilmNotFoundException();
        }
        if (!cinemaRepository.existsById(cinemaId)) {
            throw new CinemaException(CinemaException.CINEMA_NOT_FOUND);
        }

        String id = UUID.randomUUID().toString();
        CinemaFilm cinemaFilm = new CinemaFilm(id, filmId, cinemaId, status);
        return filmCinemaRepository.save(cinemaFilm);
    }

    public List<Cinema> getCinemasByFilmIdAndStatus(String filmId, String status) {
        List<String> cinemaIds = filmCinemaRepository.findAllByFilmIdAndStatus(filmId, status).stream()
                .map(CinemaFilm::getCinemaId)
                .collect(Collectors.toList());
        return cinemaRepository.findAllById(cinemaIds);
    }

    public List<Cinema> getShowingCinemasByFilmId(String filmId) {
        return getCinemasByFilmIdAndStatus(filmId, STATUS_SHOWING);
    }
}
