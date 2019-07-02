package main.java.com.wildcodeschool.reims0519springmansionproject.entities;

public class Objects {
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

    public Objects(String name, boolean useful) {
        this.name = name;
        this.useful = useful;
    }

}