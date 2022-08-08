package com.jianpiao.api.service;

import com.jianpiao.api.exception.FilmNotFoundException;
import com.jianpiao.api.mapper.FilmMapper;
import com.jianpiao.api.model.dto.FilmRequest;
import com.jianpiao.api.model.entity.Film;
import com.jianpiao.api.repository.FilmRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class FilmService {

    private FilmRepository filmRespository;

    private FilmMapper filmMapper;

    public FilmService(FilmRepository filmRespository, FilmMapper filmMapper) {
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
}
