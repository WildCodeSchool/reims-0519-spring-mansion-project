package com.wildcodeschool.reims0519springmansionproject.repositories;

import java.util.ArrayList;
import java.util.Arrays;

import com.wildcodeschool.reims0519springmansionproject.entities.Room;


public class RoomRepository {
    private ArrayList<Room> myRooms;

    public RoomRepository() {
        myRooms = new ArrayList<Room>();
        myRooms.add(new Room(0, "Yard", 11, 11, new ArrayList<Integer>(Arrays.asList(1))));
        myRooms.add(new Room(1, "Hall", 22, 11, new ArrayList<Integer>(Arrays.asList(2, 3, 4, 5))));
        myRooms.add(new Room(2, "Salon", 11, 11, new ArrayList<Integer>(Arrays.asList(1, 3, 5))));
        myRooms.add(new Room(3, "Office", 11, 11, new ArrayList<Integer>(Arrays.asList(1, 2))));
        myRooms.add(new Room(4, "Reception", 22, 11, new ArrayList<Integer>(Arrays.asList(1, 6))));
        myRooms.add(new Room(5, "Library", 11, 22, new ArrayList<Integer>(Arrays.asList(1, 2))));
        myRooms.add(new Room(6, "Kitchen", 11, 11, new ArrayList<Integer>(Arrays.asList(4))));
        myRooms.get(5).setLocked(true);
    }



    public Room getRoomById(int id) {
        for(Room room : myRooms) {
            if(room.getId() == id) {
                return room;
            }
        }
        return null;
    }
}