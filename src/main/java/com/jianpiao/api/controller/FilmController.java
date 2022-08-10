package com.jianpiao.api.controller;

import com.jianpiao.api.mapper.FilmMapper;
import com.jianpiao.api.model.dto.FilmRequest;
import com.jianpiao.api.model.dto.Result;
import com.jianpiao.api.model.entity.Film;
import com.jianpiao.api.service.CinemaService;
import com.jianpiao.api.service.FilmService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/films")
public class FilmController {


    private FilmService filmService;

    private FilmMapper filmMapper;

    private CinemaService cinemaService;

    public FilmController(FilmService filmService, FilmMapper filmMapper, CinemaService cinemaService) {
        this.filmService = filmService;
        this.filmMapper = filmMapper;
        this.cinemaService = cinemaService;
    }

    @GetMapping()
    public Result getAllFilms() {
        List<Film> allFilms = filmService.getAllFilms();
        return Result.ok().put("films", filmMapper.toResponses(allFilms));
    }


    @GetMapping("/{id}")
    public Result getFilmById(@PathVariable String id) {
        Film filmById = filmService.findFilmById(id);
        return Result.ok().put("film", filmMapper.toResponse(filmById));
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Result addFilm(@RequestBody FilmRequest filmRequest) {
        Film film = filmMapper.toEntity(filmRequest);
        film.setId(String.valueOf(UUID.randomUUID()));
        Film newFilm = filmService.addFilm(film);
        return Result.ok().put("film: ", newFilm);
    }

    @GetMapping("/{filmId}/showingCinemas")
    public Result getShowingCinemasByFilmId(@PathVariable String filmId) {
        return Result.ok().put("data", cinemaService.getShowingCinemasByFilmId(filmId));
    }
}
