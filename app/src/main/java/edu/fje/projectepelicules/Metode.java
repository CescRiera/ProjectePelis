package edu.fje.projectepelicules;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class Metode {
    public static void shuffleArray(Object[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            int aleatori = (int) (Math.random() * (i + 1));
            Object temp = array[i];
            array[i] = array[aleatori];
            array[aleatori] = temp;
        }
    }

    public static List<String> getRandomOptions(String correctOption, Set<TVShow> tvShowsSet) {
        List<String> options = new ArrayList<>();
        options.add(correctOption);

        while (options.size() < 4) {
            TVShow randomTVShow = getRandomTVShow(tvShowsSet);
            if (!options.contains(randomTVShow.getName())) {
                options.add(randomTVShow.getName());
            }
        }

        return options;
    }

    public static TVShow getRandomTVShow(Set<TVShow> tvShowsSet) {
        List<TVShow> tvShowsList = new ArrayList<>(tvShowsSet);
        Collections.shuffle(tvShowsList);
        return tvShowsList.get(0);
    }



}
