package com.jianpiao.api.controller;

import com.jianpiao.api.mapper.SessionMapper;
import com.jianpiao.api.model.dto.Result;
import com.jianpiao.api.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
