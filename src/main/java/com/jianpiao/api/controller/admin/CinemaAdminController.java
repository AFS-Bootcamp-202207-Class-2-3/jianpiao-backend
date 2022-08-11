package com.jianpiao.api.controller.admin;

import com.jianpiao.api.mapper.CinemaMapper;
import com.jianpiao.api.model.dto.Result;
import com.jianpiao.api.service.CinemaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Berlin
 * @Date: 2022/8/11 13:44
 */

@RestController
@RequestMapping("/admin/cinema")
public class CinemaAdminController {

    private final CinemaService cinemaService;

    private final CinemaMapper cinemaMapper;

    public CinemaAdminController(CinemaService cinemaService, CinemaMapper cinemaMapper) {
        this.cinemaService = cinemaService;
        this.cinemaMapper = cinemaMapper;
    }

    @GetMapping()
    public Result getAdminCinema() {
        return Result.ok().put("data", cinemaMapper.toResponse(cinemaService.getAdminCinema()));
    }

}
