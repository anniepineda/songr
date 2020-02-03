package com.anniepineda.songr;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository extends JpaRepository <Album, Long>{
    //can create method
    public Album findAlbumByTitle(String title);

}
