package com.jianpiao.api.controller;

import com.jianpiao.api.mapper.SessionMapper;
import com.jianpiao.api.model.dto.Result;
import com.jianpiao.api.model.entity.Session;
import com.jianpiao.api.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/sessions")
public class SessionController {

    @Autowired
    private SessionService sessionService;

    @Autowired
    private SessionMapper sessionMapper;


    @GetMapping("/{sessionId}")
    public Result getSessionById(@PathVariable String sessionId) {
        return Result.ok().put("data", sessionMapper.toResponse(sessionService.findById(sessionId)));
    }

    @GetMapping
    public Result getSessionsByCinemaIdAndFilmId(@RequestParam("cinemaId") String cinemaId,
                                                 @RequestParam("filmId") String filmId) {
        System.out.println(cinemaId + "===" + filmId);
        Map<Date, List<Session>> sessions = sessionService.findByCinemaIdAndFilmId(cinemaId, filmId);
        System.out.println(sessions);
        return Result.ok().put("data", sessionMapper.toResponse(sessions));
    }

}
