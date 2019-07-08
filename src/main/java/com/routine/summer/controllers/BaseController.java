package com.routine.summer.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseController {
    @RequestMapping(value = "/")
    public String home() {
        return "Welcome Home!";
    }
}
