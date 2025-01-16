package com.example.LR3_Rest.mappers;


import com.example.LR3_Rest.dto.AlbumDto;
import com.example.LR3_Rest.entities.Album;

public class AlbumMapper {
    public static Album toEntity(AlbumDto dto) {
        Album album = new Album();
        album.setName(dto.getName());
        album.setLabel(dto.getLabel());
        return album;
    }
}
