package edu.fje.projectepelicules;

public class TVShow {
    private int imageResourceID;
    private String name;

    public TVShow(String name, int imageResourceID) {
        this.imageResourceID = imageResourceID;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getImageResourceId() {
        return imageResourceID;
    }
}
