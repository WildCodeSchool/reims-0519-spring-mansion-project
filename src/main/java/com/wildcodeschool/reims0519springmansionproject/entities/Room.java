package com.wildcodeschool.reims0519springmansionproject.entities;

import java.util.ArrayList;

public class Room {
    private int id;
    private String name;
    private int roomHeight;
    private int roomWidth;
    private boolean locked = false;
    private ArrayList<String> adjacentRooms;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRoomHeight() {
        return roomHeight;
    }

    public void setRoomHeight(int roomHeight) {
        this.roomHeight = roomHeight;
    }

    public int getRoomWidth() {
        return roomWidth;
    }

    public void setRoomWidth(int roomWidth) {
        this.roomWidth = roomWidth;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public ArrayList<String> getAdjacentRooms() {
        return adjacentRooms;
    }

    public void setAdjacentRooms(ArrayList<String> adjacentRooms) {
        this.adjacentRooms = adjacentRooms;
    }

    public Room(int id, String name, int roomHeight, int roomWidth, ArrayList<String> adjacentRooms) {
        this.id = id;
        this.name = name;
        this.roomHeight = roomHeight;
        this.roomWidth = roomWidth;
        this.adjacentRooms = adjacentRooms;
    }
}