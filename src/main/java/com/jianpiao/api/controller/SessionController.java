package com.jianpiao.api.controller;

import com.jianpiao.api.mapper.SessionMapper;
import com.jianpiao.api.model.dto.Result;
import com.jianpiao.api.model.entity.Session;
import com.jianpiao.api.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;

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
    public Result getSessions(@RequestParam(value = "cinemaId", required = false) String cinemaId,
                                                 @RequestParam(value = "filmId", required = false) String filmId) {
        if(Objects.isNull(cinemaId) && Objects.isNull(filmId))
            return Result.error(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase());

        Map<Date, List<Session>> sessions = sessionService.findSessions(cinemaId, filmId);
        return Result.ok().put("data", sessionMapper.toResponse(sessions));
    }

}
