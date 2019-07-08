package com.wildcodeschool.reims0519springmansionproject.entities;

import com.wildcodeschool.reims0519springmansionproject.entities.Player;
import com.wildcodeschool.reims0519springmansionproject.repositories.RoomRepository;

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