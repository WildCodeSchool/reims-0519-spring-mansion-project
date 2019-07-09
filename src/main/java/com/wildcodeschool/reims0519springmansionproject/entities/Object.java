package com.wildcodeschool.reims0519springmansionproject.entities;

public class Object {
    private String key;
    private int idLocation;
    private int roomAssociated;


    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Object(String key) {
        this.key = key;
    }

    public int getIdLocation() {
        return idLocation;
    }

    public void setIdLocation(int idLocation) {
        this.idLocation = idLocation;
    }

    public int getRoomAssociated() {
        return roomAssociated;
    }

    public void setRoomAssociated(int roomAssociated) {
        this.roomAssociated = roomAssociated;
    }

    public Object(String key, int idLocation, int roomAssociated) {
        this.key = key;
        this.idLocation = idLocation;
        this.roomAssociated = roomAssociated;
    }
}