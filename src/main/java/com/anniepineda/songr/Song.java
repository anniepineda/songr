package com.anniepineda.songr;

import javax.persistence.*;

@Entity

public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @ManyToOne
    Album album;

    String title;
    String Album;
    int length;
    int trackNumber;

    //use Album or album?????
    public Song(String title, String Album, int length, int trackNumber){
        this.title = title;
        this.Album = Album;
        this.length = length;
        this.trackNumber = trackNumber;
    }

    @Override
    public String toString(){
        return "Just added" + this.title + "from the album" + this.Album + "the song is" + this.length + "long and the track number is" + this.trackNumber;
    }

    public Song(){

    }

}
