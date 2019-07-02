package com.wildcodeschool.reims0519springmansionproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ControllerGame {
    
    @GetMapping("/game")
    public String getGame() {
        return "";
    }

    @GetMapping("/game/{id}")
    public Room getRoom(@PathVariable int id, Player player) {
        return player.getMansion().get(id);
    }
}