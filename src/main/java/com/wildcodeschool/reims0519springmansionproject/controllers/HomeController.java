package com.wildcodeschool.reims0519springmansionproject.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {

    @GetMapping("/")
    public String getHome(HttpSession session) {
        session.setAttribute("username", "AAA");
        return "homepage";
    }
}