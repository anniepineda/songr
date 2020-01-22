package com.anniepineda.songr;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class HomeController {

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
        Album[] album = new Album[] {new Album("This Album", "Neo", 5, 180, "https://cdn8.openculture.com/2018/02/26214700/First-Aid-Kit-Ruins-e1519715301105.jpg"),
                new Album("Small Town Girl", "Soda Can", 11, 190, "https://images.squarespace-cdn.com/content/v1/573b5c41859fd0f0389aac73/1560545974101-B5CXS3DPVWCDE2DZGYXQ/ke17ZwdGBToddI8pDm48kNu93_l1Rc0JoXikXAEKHf17gQa3H78H3Y0txjaiv_0fDoOvxcdMmMKkDsyUqMSsMWxHk725yiiHCCLfrh8O1z5QHyNOqBUUEtDDsRWrJLTmDJyaVitQ06bkWUY0OMxkmN-bdz7wg8la12Me-ub45vBE5029s6uMXtkNCzVgxK8m/a66f04f3-5465-457b-87d1-325c2641c1a8.jpg?format=2500w"),
                new Album("Heart of Glass", "Blondie", 9, 270, "https://img.discogs.com/oGZxbLpSZhGAVN6hO9m2HOwm3m0=/fit-in/600x600/filters:strip_icc():format(jpeg):mode_rgb():quality(90)/discogs-images/R-455676-1115906653.jpg.jpg")};
        m.addAttribute("albumList", album);
        return "album";
    }

}
