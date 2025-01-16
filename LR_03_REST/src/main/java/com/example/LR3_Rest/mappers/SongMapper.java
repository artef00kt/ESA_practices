package com.example.LR3_Rest.mappers;

import com.example.LR3_Rest.dto.SongDto;
import com.example.LR3_Rest.entities.Album;
import com.example.LR3_Rest.entities.Song;

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
