package com.wildcodeschool.reims0519springmansionproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ControllerAccueil {

    @GetMapping("/")
    public String getAccueil() {
        return "homepage.html";
    }


}