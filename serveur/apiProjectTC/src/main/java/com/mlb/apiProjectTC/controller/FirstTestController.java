package com.mlb.apiProjectTC.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstTestController {

    @GetMapping("/message")
    public String welcomeMessage() {
        return "Hello Murciana" ;
    }
}
