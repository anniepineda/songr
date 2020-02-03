package com.anniepineda.songr;

import javax.persistence.*;

@Entity

public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    Album album;

    String title;
    String Album;
    int length;
    int trackNumber;

    public Song(){}


    public Song(String title, String Album, int length, int trackNumber){
        this.title = title;
        this.Album = Album;
        this.length = length;
        this.trackNumber = trackNumber;
    }


    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }

    public int getTrackNumber() {
        return trackNumber;
    }



    @Override
    public String toString(){
        return "Just added" + this.title + "from the album" + this.Album + "the song is" + this.length +
                "long and the track number is" + this.trackNumber;
    }


}
