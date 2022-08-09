package com.jianpiao.api.service;

import com.jianpiao.api.exception.FilmNotFoundException;
import com.jianpiao.api.mapper.FilmMapper;
import com.jianpiao.api.model.entity.Film;
import com.jianpiao.api.model.entity.CinemaFilm;
import com.jianpiao.api.repository.FilmCinemaRepository;
import com.jianpiao.api.repository.FilmRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FilmService {

    private FilmCinemaRepository filmCinemaRepository;

    private FilmRepository filmRespository;

    private FilmMapper filmMapper;

    public FilmService(FilmCinemaRepository filmCinemaRepository, FilmRepository filmRespository, FilmMapper filmMapper) {
        this.filmCinemaRepository = filmCinemaRepository;
        this.filmRespository = filmRespository;
        this.filmMapper = filmMapper;
    }

    public List<Film> getAllFilms() {
        List<Film> films = filmRespository.findAll();
        return films;
    }

    public Film findFilmById(String id) {
        Film film = filmRespository.findById(id).orElseThrow(FilmNotFoundException::new);
        return film;
    }

    public Film addFilm(Film film) {
        Film saveFilm = filmRespository.save(film);
        return saveFilm;
    }

    public List<Film> getFilmsByCinemaIdAndStatus(String cinemaId, String status) {
        List<String> filmIds = filmCinemaRepository.findAllByCinemaIdAndStatus(cinemaId, status).stream()
                .map(CinemaFilm::getFilmId)
                .collect(Collectors.toList());
        return filmRespository.findAllById(filmIds);
    }

    public List<Film> getShowingFilmsByCinemaId(String cinemaId){
        return getFilmsByCinemaIdAndStatus(cinemaId, "showing");
    }
}
