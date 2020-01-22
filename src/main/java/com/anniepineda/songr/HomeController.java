package com.anniepineda.songr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

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



}
