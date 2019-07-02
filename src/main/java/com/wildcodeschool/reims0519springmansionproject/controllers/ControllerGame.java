package com.wildcodeschool.reims0519springmansionproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControllerGame {
    
    @GetMapping("/game")
    public String getGame() {
        return "";
    }
}