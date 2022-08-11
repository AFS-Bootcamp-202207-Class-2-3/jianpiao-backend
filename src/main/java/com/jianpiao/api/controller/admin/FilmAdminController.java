package com.jianpiao.api.controller.admin;

import cn.dev33.satoken.annotation.SaCheckRole;
import cn.hutool.json.JSONUtil;
import com.jianpiao.api.model.dto.*;
import com.jianpiao.api.model.entity.Film;
import com.jianpiao.api.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: BaBy
 * @Date: 2022/8/10 15:22
 */
@RestController
@RequestMapping("/admin/films")
public class FilmAdminController {
    @Autowired
    private FilmService filmService;

//    @GetMapping("/")
//    @SaCheckRole("cinema-admin")
//    public Result getPageByParams(@RequestParam Map<String, Object> params){
//        return Result.ok().put("data", filmService.getPageByParams(params));
//    }

    @GetMapping("/")
    @SaCheckRole("cinema-admin")
    public Result getFilmAndCinemaListByStatus(@RequestParam String status){
        return Result.ok().put("data", filmService.getFilmAndCinemaListByStatus(status));
    }

    @GetMapping("/{filmCinemaId}")
    @SaCheckRole("cinema-admin")
    public Result getFilmAndCinemaByFilmCinemaId(@PathVariable String filmCinemaId){
        return Result.ok().put("data", filmService.getFilmAndCinemaByFilmCinemaId(filmCinemaId));
    }

    @PostMapping("/")
    @SaCheckRole("cinema-admin")
    public Result createFilmCinema(@RequestBody CreateFilmCinemaRequest request){
        HashMap params = JSONUtil.parseObj(request).toBean(HashMap.class);
        return Result.ok().put("data", filmService.createFilmCinema(params));
    }

    @PutMapping("/{filmCinemaId}")
    @SaCheckRole("cinema-admin")
    public Result updateFilmByFilmCinemaId(@PathVariable String filmCinemaId, @RequestBody UpdateFilmCinemaRequest request){
        HashMap params = JSONUtil.parseObj(request).toBean(HashMap.class);
        params.put("filmCinemaId", filmCinemaId);
        return Result.ok();
    }

    @PostMapping("/delete-by-ids")
    @SaCheckRole("cinema-admin")
    public Result delete(@RequestBody String[] ids){
        filmService.removeByIds(Arrays.asList(ids));
        return Result.ok();
    }
}
