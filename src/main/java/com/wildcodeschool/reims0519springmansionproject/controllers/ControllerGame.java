package com.wildcodeschool.reims0519springmansionproject.controllers;

import java.util.ArrayList;

import com.wildcodeschool.reims0519springmansionproject.entities.Room;
import com.wildcodeschool.reims0519springmansionproject.repositories.RoomRepository;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ControllerGame {

    private static RoomRepository mansion = new RoomRepository();

    
    @PostMapping("/game")
    public String postRoom(Model model, @RequestParam("btn") Integer id) {
        ArrayList<Room> myList = new ArrayList<Room>();
        for (Integer roomId : mansion.getRoomById(id).getAdjacentRooms()) {
            Room room = mansion.getRoomById(roomId);
            myList.add(room);
        }
        model.addAttribute("rooms", myList);
        return "gamepage";
    }
}