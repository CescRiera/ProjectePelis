package edu.fje.projectepelicules;

import java.util.Set;

public class Resources {
    public TVShow[] getTVShows() {
        return new TVShow[] {
                new TVShow("Game of Thrones",R.drawable.got1_part1,R.drawable.got1_part2,R.drawable.got1_part3,R.drawable.got1_part4,"Novela que se caracteriza por sus esecenas medievales"),
                new TVShow("Breaking Bad", R.drawable.bb_part1,R.drawable.bb_part2,R.drawable.bb_part3,R.drawable.bb_part4,"Serie creada en el 2008, Imperio de la droga"),
                new TVShow("The Sopranos", R.drawable.thesop_part1,R.drawable.thesop_part2,R.drawable.thesop_part3,R.drawable.thesop_part4, "Estados Unidos, Mafias, Dinero, etc.."),
                new TVShow("Better Call Saul", R.drawable.bcs_part1,R.drawable.bcs_part2,R.drawable.bcs_part3,R.drawable.bcs_part4,"Estafas, Derecho, Crimen, Spin Off"),
                new TVShow("True Detective", R.drawable.td_part1,R.drawable.td_part2,R.drawable.td_part3,R.drawable.td_part4,"Casos de investigacion, Homicidios, etc.."),
                new TVShow("The Wire", R.drawable.tw_part1,R.drawable.tw_part2,R.drawable.tw_part3,R.drawable.tw_part4,"Intervenciones judiciales, Policiaca, Bandas Criminales"),
                new TVShow("Prison Break", R.drawable.pb_part1,R.drawable.pb_part2,R.drawable.pb_part3,R.drawable.pb_part4,"Hermanos, Supervivencia, Escapar"),
                new TVShow("The Shield", R.drawable.theshie_part1,R.drawable.theshie_part2,R.drawable.theshie_part3,R.drawable.theshie_part4,"Policias corruptos, Bandas Criminales, Ganadora de Emmy"),
                new TVShow("Band of Brothers", R.drawable.bob_part1,R.drawable.bob_part2,R.drawable.bob_part3,R.drawable.bob_part4,"Segunda Guerra mundial"),
                new TVShow("Succecion", R.drawable.suc_part1,R.drawable.suc_part2,R.drawable.suc_part3,R.drawable.suc_part4,"Negocios Familiares y sus problemas..., "),
                new TVShow("MadMan",-1,-1,-1,-1,"Agencia de publicidad"),
                new TVShow("Strenger Things",-1,-1,-1,-1,"Grupo de amigos, Desaparicion"),
                new TVShow("Dark",-1,-1,-1,-1,"Suspense, Alemana"),
        };
    }
    public boolean NoQuedenImatges(Set<TVShow> tvShows) {
        int imatgesValides = 0;

        for (TVShow shows : tvShows) {
            if (shows.getImageResourceId() != -1) {
                imatgesValides++;
            }
        }

        return imatgesValides == 0;
    }
}