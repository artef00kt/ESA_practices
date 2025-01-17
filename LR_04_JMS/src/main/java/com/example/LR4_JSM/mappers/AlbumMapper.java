package com.example.LR4_JSM.mappers;

import com.example.LR4_JSM.dto.AlbumDto;
import com.example.LR4_JSM.entities.Album;

public class AlbumMapper {
    public static Album toEntity(AlbumDto dto) {
        Album album = new Album();
        album.setName(dto.getName());
        album.setLabel(dto.getLabel());
        return album;
    }
}
