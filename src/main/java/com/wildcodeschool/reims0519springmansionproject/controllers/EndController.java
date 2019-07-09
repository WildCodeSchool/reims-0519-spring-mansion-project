package com.wildcodeschool.reims0519springmansionproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

import com.wildcodeschool.reims0519springmansionproject.entities.Game;
import com.wildcodeschool.reims0519springmansionproject.repositories.ScoreRepository;

@Controller
public class EndController{

    private static Game game = Game.getGame();

    @GetMapping("/end")
    public String getEnd(Model model){
        model.addAttribute("scores", ScoreRepository.selectAll());
        return "endgame";
    }

    @PostMapping("/end")
    public String postScore(Model model,HttpSession session, @RequestParam(name="username", required = false) String username) {
        if (username != null && username != "") {
            session.setAttribute("username", username);
        }
        ScoreRepository.insert(
            username,
            Game.getGame().getPlayer().getScore().getEllapsedTime()
        );
        game.getPlayer().getScore().setInitialTime(0);
        model.addAttribute("scores", ScoreRepository.selectAll());
        model.addAttribute("title", "Congratulations ! You have found the murderer !");
        return "endgame";
    }
}
