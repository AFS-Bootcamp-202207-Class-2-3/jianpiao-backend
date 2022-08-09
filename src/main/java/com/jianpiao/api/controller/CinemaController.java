package com.jianpiao.api.controller;

import com.jianpiao.api.mapper.CinemaMapper;
import com.jianpiao.api.model.dto.Result;
import com.jianpiao.api.service.CinemaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cinemas")
public class CinemaController {

    private final CinemaService cinemaService;

    private final CinemaMapper cinemaMapper;

    public CinemaController(CinemaService cinemaService, CinemaMapper cinemaMapper) {
        this.cinemaService = cinemaService;
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

}
