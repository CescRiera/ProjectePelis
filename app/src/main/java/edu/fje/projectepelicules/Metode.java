package edu.fje.projectepelicules;

public class Metode {
    public static void shuffleArray(Object[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            int index = (int) (Math.random() * (i + 1));
            Object temp = array[i];
            array[i] = array[index];
            array[index] = temp;
        }
    }
}
