package com.jianpiao.api.controller;

import com.jianpiao.api.mapper.CinemaMapper;
import com.jianpiao.api.model.dto.CinemaFilmRequest;
import com.jianpiao.api.model.dto.Result;
import com.jianpiao.api.service.CinemaService;
import com.jianpiao.api.service.FilmService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cinemas")
public class CinemaController {

    private final CinemaService cinemaService;

    private final FilmService filmService;

    private final CinemaMapper cinemaMapper;

    public CinemaController(CinemaService cinemaService, FilmService filmService, CinemaMapper cinemaMapper) {
        this.cinemaService = cinemaService;
        this.filmService = filmService;
        this.cinemaMapper = cinemaMapper;
    }

    @GetMapping
    public Result getAllCinemas() {
        return Result.ok().put("data", cinemaMapper.toResponses(cinemaService.getAllCinemas()));
    }

    @GetMapping("/{id}")
    public Result getCinemaById(@PathVariable String id) {
        return Result.ok().put("data", cinemaMapper.toResponse(cinemaService.getCinemaById(id)));
    }

    @GetMapping("/{cinemaId}/showingFilms")
    public Result getShowingFilmByCinemaId(@PathVariable String cinemaId) {
        return Result.ok().put("data", filmService.getShowingFilmsByCinemaId(cinemaId));
    }

    @GetMapping("/{cinemaId}/films")
    public Result getFilmByCinemaIdAnd(@PathVariable String cinemaId, @RequestParam String status) {
        return Result.ok().put("data", filmService.getFilmsByCinemaIdAndStatus(cinemaId, status));
    }

    @PostMapping("/saveRelatedFilmAndCinema")
    public Result saveRelatedFilmAndCinema(@RequestBody CinemaFilmRequest cinemaFilmRequest) {
        return Result.ok()
                .put("data", cinemaService.saveRelatedFilmAndCinema(
                        cinemaFilmRequest.getFilmId(),
                        cinemaFilmRequest.getCinemaId(),
                        cinemaFilmRequest.getStatus()));
    }

    @PostMapping("/post-cinema-film")
    public Result postCinemaFilm(@RequestBody CinemaFilmRequest cinemaFilmRequest) {
        return Result.ok()
                .put("data", cinemaService.saveRelatedFilmAndCinema(
                        cinemaFilmRequest.getFilmId(),
                        cinemaFilmRequest.getCinemaId(),
                        cinemaFilmRequest.getStatus()));
    }
}
