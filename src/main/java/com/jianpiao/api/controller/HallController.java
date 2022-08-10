package com.jianpiao.api.controller;

import com.jianpiao.api.mapper.HallMapper;
import com.jianpiao.api.model.dto.Result;
import com.jianpiao.api.model.entity.Hall;
import com.jianpiao.api.service.HallService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * @Author: Berlin
 * @Date: 2022/8/10 13:44
 */

@RestController
@RequestMapping("/halls")
public class HallController {

    private HallService hallService;

    private HallMapper hallMapper;

    public HallController(HallService hallService, HallMapper hallMapper) {
        this.hallService = hallService;
        this.hallMapper = hallMapper;
    }

    @GetMapping()
    public Result getAllFilms() {
        List<Hall> halls = hallService.getAllHalls();
        return Result.ok().put("data", hallMapper.toResponses(halls));
    }

}
