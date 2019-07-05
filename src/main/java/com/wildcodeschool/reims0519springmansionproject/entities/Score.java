package com.wildcodeschool.reims0519springmansionproject.entities;

public class Score {
    private int id;
    private String name;
    private long initialTime;
    private String timeString;

    public Score(){
        this.initialTime = System.currentTimeMillis();
    }

    public Score(int id, String name, String timeString) {
        this.id = id;
        this.name = name;
        this.timeString = timeString;
    }
    
    public long getEllapsedTime() {
        return System.currentTimeMillis() - initialTime;
    }

    public void setInitialTime(long time) {
        this.initialTime = time;
    }

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

    public String getTimeString() {
        return timeString;
    }

    public void setTimeString(String timeString) {
        this.timeString = timeString;
    }

    public static String formatTime(long time) {
        long seconds = (time % 60);
        long minutes = (time % 3600)/60;
        long hours = (time / 3600);
        return hours + "h " + minutes + "m "+ seconds + "s ";
    }
}