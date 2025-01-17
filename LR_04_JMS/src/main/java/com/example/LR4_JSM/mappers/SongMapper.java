package com.example.LR4_JSM.mappers;

import com.example.LR4_JSM.dto.SongDto;
import com.example.LR4_JSM.entities.Album;
import com.example.LR4_JSM.entities.Song;

public class SongMapper {
    public static Song toEntity(SongDto dto) {
        Song song = new Song();
        Album album = new Album();
        album.setId(dto.getAlbumId());
        song.setAlbum(album);
        song.setTitle(dto.getTitle());
        song.setExecutor(dto.getExecutor());
        return song;
    }
}
