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
                new TVShow("Game of Thrones",R.drawable.got1_part1,R.drawable.got1_part2,R.drawable.got1_part3,R.drawable.got1_part4),
                new TVShow("Breaking Bad", R.drawable.bb_part1,R.drawable.bb_part2,R.drawable.bb_part3,R.drawable.bb_part4),
                new TVShow("The Sopranos", R.drawable.thesop_part1,R.drawable.thesop_part2,R.drawable.thesop_part3,R.drawable.thesop_part4),
                new TVShow("Better Call Saul", R.drawable.bcs_part1,R.drawable.bcs_part2,R.drawable.bcs_part3,R.drawable.bcs_part4),
                new TVShow("True Detective", R.drawable.td_part1,R.drawable.td_part2,R.drawable.td_part3,R.drawable.td_part4),
                new TVShow("The Wire", R.drawable.tw_part1,R.drawable.tw_part2,R.drawable.tw_part3,R.drawable.tw_part4),
                new TVShow("Prison Break", R.drawable.pb_part1,R.drawable.pb_part2,R.drawable.pb_part3,R.drawable.pb_part4),
                new TVShow("The Shield", R.drawable.theshie_part1,R.drawable.theshie_part2,R.drawable.theshie_part3,R.drawable.theshie_part4),
                new TVShow("Band of Brothers", R.drawable.bob_part1,R.drawable.bob_part2,R.drawable.bob_part3,R.drawable.bob_part4),
                new TVShow("Succecion", R.drawable.suc_part1,R.drawable.suc_part2,R.drawable.suc_part3,R.drawable.suc_part4),
                new TVShow("MadMan",-1,-1,-1,-1),
                new TVShow("Strenger Things",-1,-1,-1,-1),
                new TVShow("Dark",-1,-1,-1,-1),
        };
    }
}

