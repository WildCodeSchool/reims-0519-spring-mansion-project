package com.wildcodeschool.reims0519springmansionproject.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class ControllerAccueil {

@GetMapping("/")
public String getAccueil() {
    return null;
}

}