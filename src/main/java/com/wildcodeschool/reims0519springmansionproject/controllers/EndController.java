package com.wildcodeschool.reims0519springmansionproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.wildcodeschool.reims0519springmansionproject.entities.Game;
import com.wildcodeschool.reims0519springmansionproject.repositories.ScoreRepository;

@Controller
public class EndController{
    @GetMapping("/end")
    public String getEnd(Model model){
        model.addAttribute("scores", ScoreRepository.selectAll());
        return "endgame";
    }

    @PostMapping("/end")
    public String postScore(Model model) {
        ScoreRepository.insert(
            Game.getGame().getPlayer().getScore().getName(),
            Game.getGame().getPlayer().getScore().getEllapsedTime()
        );
        model.addAttribute("scores", ScoreRepository.selectAll());
        return "endgame";
    }
}
