package com.anniepineda.songr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;


@Controller
public class HomeController {

    @Autowired
    AlbumRepository albumRepository;

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
    public RedirectView addedAlbum(String albumName, String artist, int songCount){
        String title = albumName;
        Album newAlbum = new Album(title, artist, songCount, 300, "https://upload.wikimedia" +
                ".org/wikipedia/en/b/b7/NirvanaNevermindalbumcover.jpg");
        albumRepository.save(newAlbum);
    return new RedirectView("/albums");
}

@PostMapping





}
