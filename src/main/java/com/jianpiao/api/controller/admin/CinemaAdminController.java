package com.jianpiao.api.controller.admin;

import cn.dev33.satoken.annotation.SaCheckRole;
import com.jianpiao.api.mapper.CinemaMapper;
import com.jianpiao.api.model.dto.CinemaAdminRequest;
import com.jianpiao.api.model.dto.Result;
import com.jianpiao.api.service.CinemaService;
import org.springframework.web.bind.annotation.*;

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
    @SaCheckRole("cinema-admin")
    public Result getAdminCinema() {
        return Result.ok().put("data", cinemaMapper.toResponse(cinemaService.getAdminCinema()));
    }

    @PutMapping("/{cinemaId}")
    @SaCheckRole("cinema-admin")
    public Result updateAdminCinema(@PathVariable String cinemaId, @RequestBody CinemaAdminRequest cinemaAdminRequest) {
        return Result.ok().put("data", cinemaMapper.toResponse(cinemaService.updateAdminCinema(cinemaId, cinemaAdminRequest)));

    }

}
