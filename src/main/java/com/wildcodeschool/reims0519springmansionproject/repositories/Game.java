package com.wildcodeschool.reims0519springmansionproject.repositories;

import com.wildcodeschool.reims0519springmansionproject.entities.Player;

public class Game {
    private static Game game = null;
    
    private Player player;
    private RoomRepository mansion;

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public RoomRepository getMansion() {
        return mansion;
    }

    public void setMansion(RoomRepository mansion) {
        this.mansion = mansion;
    }

    public String endTime() {
        String timeString = "";
        long diffT = (System.currentTimeMillis() - this.player.getScore().getTime())/1000;
        long seconds = (diffT % 60);
        long minutes = (diffT % 3600)/60;
        long hours = (diffT / 3600);
        timeString = hours + "h " + minutes + "m "+ seconds + "s ";
        return timeString;
    }

    public Game() {
        this.player = new Player();
        this.mansion = new RoomRepository();
    }

    public static Game getGame() {
        if (game == null) {
            game = new Game();
        }
        return game;
    }
}