package com.jianpiao.api.controller.admin;

import cn.dev33.satoken.annotation.SaCheckRole;
import com.jianpiao.api.mapper.HallMapper;
import com.jianpiao.api.model.dto.Result;
import com.jianpiao.api.model.entity.Hall;
import com.jianpiao.api.service.HallService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * @Author: Berlin
 * @Date: 2022/8/10 13:44
 */

@RestController
@RequestMapping("/admin/halls")
public class HallAdminController {

    private HallService hallService;

    private HallMapper hallMapper;

    public HallAdminController(HallService hallService, HallMapper hallMapper) {
        this.hallService = hallService;
        this.hallMapper = hallMapper;
    }

    @GetMapping()
    @SaCheckRole("cinema-admin")
    public Result getAllHalls() {
        List<Hall> halls = hallService.getAllHalls();
        return Result.ok().put("data", hallMapper.toResponses(halls));
    }

    @GetMapping("/{hallName}")
    @SaCheckRole("cinema-admin")
    public Result addHall(@PathVariable String hallName) {
        Hall newHall = hallService.addHall(hallName);
        return Result.ok().put("data", hallMapper.toResponse(newHall));
    }

}
