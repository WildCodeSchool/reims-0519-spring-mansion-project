package com.wildcodeschool.reims0519springmansionproject.controllers;

import java.util.ArrayList;

import com.wildcodeschool.reims0519springmansionproject.entities.Room;
import com.wildcodeschool.reims0519springmansionproject.repositories.RoomRepository;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ControllerGame {

    private static RoomRepository mansion = new RoomRepository();

    @GetMapping("/game")
    public String getRoomZero() {
        return "redirect:/game/0";
    }

    @GetMapping("/game/{id}")
    public String getRoom(Model model, @PathVariable int id) {
        ArrayList<Room> myList = new ArrayList<Room>();
        for (Integer roomId : mansion.getRoomById(id).getAdjacentRooms()) {
            Room room = mansion.getRoomById(roomId);
            myList.add(room);
        }
        model.addAttribute("rooms", myList);
        return "gamepage";
    }
}