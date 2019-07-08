package com.wildcodeschool.reims0519springmansionproject.entities;

public class Object {
    private String name;
    private boolean useful;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isUseful() {
        return useful;
    }

    public void setUseful(boolean useful) {
		this.useful = useful;
	}

    public Object(String name, boolean useful) {
        this.name = name;
        this.useful = useful;
    }

}