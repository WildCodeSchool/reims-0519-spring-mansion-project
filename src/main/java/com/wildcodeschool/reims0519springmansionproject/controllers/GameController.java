package com.wildcodeschool.reims0519springmansionproject.controllers;

import java.util.ArrayList;

import com.wildcodeschool.reims0519springmansionproject.entities.Game;
import com.wildcodeschool.reims0519springmansionproject.entities.Object;
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
    public String postRoom(Model model, @RequestParam(defaultValue = "1") Integer id, @RequestParam(name="nickname", required=false) String nickname) {
        if (game.getPlayer().getScore().getName() == null) {
            if (nickname != null && !nickname.equals("")) {
                game.getPlayer().getScore().setName(nickname);
            }
            else {
                game.getPlayer().getScore().setName("AAA");
            }
        }
        if (id == 5) {
            model.addAttribute("end_message", "End game");
        }
        else {
            ArrayList<Room> myList = new ArrayList<Room>();
            ArrayList<Object> myObjects = game.getObjects().getMyObjects();
            if (!myObjects.isEmpty()) {
                if (id == myObjects.get(0).getIdLocation() && game.getMansion().getRoomById(myObjects.get(0).getRoomAssociated()).isLocked()) {
                    model.addAttribute("key", "You found the key !");
                    game.getMansion().getRoomById(myObjects.get(0).getRoomAssociated()).setLocked(false);
                }
            }
            for (Integer roomId : game.getMansion().getRoomById(id).getAdjacentRooms()) {
                Room room = game.getMansion().getRoomById(roomId);
                if (room.isLocked()) {
                    model.addAttribute("locked", room.getName() + " is locked ! Find the key !");
                }
                myList.add(room); 
                model.addAttribute("rooms", myList);
            }
        }
        model.addAttribute("currentRoom", game.getMansion().getRoomById(id));
        return "game";
    }
}