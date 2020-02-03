package com.anniepineda.songr;

import com.sun.javafx.beans.IDProperty;
import javax.persistence.*;
import java.util.List;

@Entity
public class Album {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @OneToMany(mappedBy = "album")
    public List<Song> song;

    public String  title;
    public String artist;
    public int songCount;
    public int length;
    public String imageUrl;


    public Album(String title, String artist, int songCount, int length, String imageUrl){
        this.title = title;
        this.artist = artist;
        this.songCount = songCount;
        this.length = length;
        this.imageUrl = imageUrl;
    }

    public Album(){

    }

    @Override
    public String toString(){
        return this.title + " " + this.artist + " " + this.songCount + " " + this.length + " ";
    }

}



