package edu.fje.projectepelicules;

public class TVShow {
    private int imageResourceID_part1;
    private int imageResourceID_part2;
    private int imageResourceID_part3;
    private int imageResourceID_part4;


    private String name;

    public TVShow(String name, int imageResourceID_part1,int imageResourceID_part2, int imageResourceID_part3, int imageResourceID_part4) {

        this.imageResourceID_part1 = imageResourceID_part1;
        this.imageResourceID_part2 = imageResourceID_part2;
        this.imageResourceID_part3 = imageResourceID_part3;
        this.imageResourceID_part4 = imageResourceID_part4;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getImageResourceId() {
        return imageResourceID_part1;
    }

    private int IntentsInco; // Contador para los intentos incorrectos

    public int getIncorrectAttempts() {
        return IntentsInco;
    }

    public void incrementIncorrectAttempts() {
        IntentsInco++;
    }

    public int getImageResourceIdByAttempt() {
        switch (IntentsInco) {
            case 1:
                return imageResourceID_part2;
            case 2:
                return imageResourceID_part3;
            case 3:
                return imageResourceID_part4;
            default:
                return imageResourceID_part1;
        }
    }
}

