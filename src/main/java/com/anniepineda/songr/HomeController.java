package com.anniepineda.songr;

//import org.graalvm.compiler.nodes.java.NewArrayNode;
//import org.springframework.boot.autoconfigure.AutoConfigureOrder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;


@Controller
public class HomeController {


    @Autowired
    AlbumRepository albumRepository;
    @Autowired
    SongRepository songRepository;


    @GetMapping("/hello")
    public String hello(){
        return "hello-world";
    }

    @GetMapping("/capitalize/{wordToCaps}")
    public String hello(@PathVariable String wordToCaps, Model m){
        wordToCaps = wordToCaps.toUpperCase();
        m.addAttribute("capWord", wordToCaps );
        return "hello-caps";
    }

    @GetMapping("/albums")
    public String getAlbum(Model m){
        List<Album> albums = albumRepository.findAll();
        m.addAttribute("albumList", albums);
        return "album";
    }


@PostMapping("/albums")
    public RedirectView addedAlbum(String albumName, String artist, int length, int songCount, String imageUrl){
        String title = albumName;
        Album newAlbum = new Album(title, artist, songCount, length, imageUrl );
        albumRepository.save(newAlbum);
    return new RedirectView("/albums");
}

@PostMapping("/albums/delete/{id}")
    public RedirectView deleteAlbum(@PathVariable long id){
    System.out.println("delete" + id);

    albumRepository.deleteById(id);
        return new RedirectView("/albums");

}

@GetMapping("/albums/{id}")
public String albumDetails(@PathVariable long id, Model m){
        Album album = albumRepository.findById(id).get();
        m.addAttribute("album", album);
        Song song = songRepository.findSongByAlbum(id);
        m.addAttribute("song", song);
        return "albumDetails";
}


@GetMapping("/album-details")
public String song(Model m){
        List<Song> song = songRepository.findAll();
        m.addAttribute("song", song);
        return "album-details";
}


@PostMapping("/song")
    public RedirectView addSong(long id,String title, String album, int length, int trackNumber){
        Album existingAlbum = albumRepository.findAlbumByTitle(title);
        Song newSong = new Song(title, album, length, trackNumber);
        newSong.album = existingAlbum;
        songRepository.save(newSong);
        return new RedirectView("/albums");

}



}
