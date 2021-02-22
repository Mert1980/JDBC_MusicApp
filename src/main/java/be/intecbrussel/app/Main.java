package be.intecbrussel.app;

import be.intecbrussel.data.Datasource;
import be.intecbrussel.model.Artist;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Datasource datasource = new Datasource();
        if(!datasource.open()) {
            System.out.println("Can't open datasource");
            return;
        }

        List<Artist> artists = datasource.queryArtists(3);
        if(artists == null){
            System.out.println("No artists!");
            return;
        }
        for (Artist artist:artists){
            System.out.printf("ID = %s, Name = %s \n", artist.getId(), artist.getName());
        }

        List<String> albumsForArtist = datasource.queryAlbumsForArtist("Iron Maiden", Datasource.ORDER_BY_ASC);

        for (String album: albumsForArtist){
            System.out.println(album);
        }
        datasource.close();
    }
}
