package com.wildcodeschool.reims0519springmansionproject.entities;

public class Player {
    private Room currentRoom;
    private boolean murdererFound;
    private Score score;

    public Player(){
        this.murdererFound = false;
        this.score = new Score();
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public boolean isMurdererFound() {
        return murdererFound;
    }

    public void setMurdererFound(boolean murdererFound) {
        this.murdererFound = murdererFound;
    }

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }
}