package com.wildcodeschool.reims0519springmansionproject.controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import com.wildcodeschool.reims0519springmansionproject.entities.Game;
import com.wildcodeschool.reims0519springmansionproject.entities.Room;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GameController {

    private static Game game = Game.getGame();

    @GetMapping("/game")
    public String getRoom(){
        return "redirect:/";
    }
    
    @PostMapping("/game")
    public String postRoom(Model model, HttpSession session, @RequestParam(defaultValue = "1") Integer id) {
        if (id == 1 && game.getPlayer().getScore().getInitialTime() == 0) {
            game.getPlayer().getScore().setInitialTime(System.currentTimeMillis());
        }
        if (id == 5) {
            model.addAttribute("end_message", "End game");
        }
        else {
            ArrayList<Room> myList = new ArrayList<Room>();
            for (Integer roomId : game.getMansion().getRoomById(id).getAdjacentRooms()) {
                Room room = game.getMansion().getRoomById(roomId);
                if (!room.isLocked()) {
                    myList.add(room);
                }
                else {
                    model.addAttribute("locked", room.getName() + " is locked ! Find the key !");
                }
                model.addAttribute("rooms", myList);
            }
        }
        model.addAttribute("currentRoom", game.getMansion().getRoomById(id));
        return "game";
    }
}