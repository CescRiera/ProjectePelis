package edu.fje.projectepelicules;

public class Resources {
    public static int[] TVShowImages = {
            R.drawable.got1,
            R.drawable.thesop,
            R.drawable.bb,
            R.drawable.bcs,
            R.drawable.theshie,
            R.drawable.bob,
            R.drawable.pb,
            R.drawable.td,
            R.drawable.suc,
            R.drawable.tw,

    };
    public TVShow[] getTVShows() {
        return new TVShow[] {
                new TVShow("Game of Thrones",R.drawable.got1),
                new TVShow("Breaking Bad", R.drawable.bb),
                new TVShow("The Sopranos", R.drawable.thesop),
                new TVShow("Better Call Saul", R.drawable.bcs),
                new TVShow("True Detective", R.drawable.td),
                new TVShow("The Wire", R.drawable.tw),
                new TVShow("Prison Break", R.drawable.pb),
                new TVShow("The Shield", R.drawable.theshie)
        };
    }
}

