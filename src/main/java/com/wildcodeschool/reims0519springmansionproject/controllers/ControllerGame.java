package com.wildcodeschool.reims0519springmansionproject.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerGame {
    
    @GetMapping("/Game")
    public String getGame() {
        return "";
    }
}