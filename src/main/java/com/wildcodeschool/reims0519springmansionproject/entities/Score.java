package com.wildcodeschool.reims0519springmansionproject.entities;

public class Score {
    private long time;

    public Score(){
        this.time = System.currentTimeMillis();
    }
    
    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}