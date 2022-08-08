package com.jianpiao.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/welcome")
public class HelloController {
    @GetMapping(path = "/{userName}")
    public String getAll(@PathVariable String userName) {
        return "Test-API Hello, world! Welcome: " + userName;
    }
}
