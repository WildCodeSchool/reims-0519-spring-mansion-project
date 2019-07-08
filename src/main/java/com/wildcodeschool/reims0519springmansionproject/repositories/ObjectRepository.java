package com.wildcodeschool.reims0519springmansionproject.repositories;

import java.util.ArrayList;

import com.wildcodeschool.reims0519springmansionproject.entities.Object;


public class ObjectRepository {
    private ArrayList<Object> myObjects;

    public ObjectRepository() {
        myObjects = new ArrayList<Object>();
        myObjects.add(new Object("Rusty key", 6, 5));
    }

    public ArrayList<Object> getMyObjects() {
        return myObjects;
    }

    public boolean isEmpty() {
        return myObjects.isEmpty();
    }
}