package com.anniepineda.songr;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepository extends JpaRepository<Song, Long> {

    public Song findSongByAlbum(long albumId);

}

