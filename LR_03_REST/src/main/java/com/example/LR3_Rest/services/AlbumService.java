package com.example.LR3_Rest.services;

import com.example.LR3_Rest.entities.Album;
import com.example.LR3_Rest.repositories.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumService {

    private final AlbumRepository albumRepository;

    @Autowired
    public AlbumService(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    public List<Album> findAll() {
        return albumRepository.findAll();
    }

    public String getAlbumsAsXml() {
        List<Album> albums = findAll();
        StringBuilder xmlBuilder = new StringBuilder();
        xmlBuilder.append("<albums>");
        for (Album album : albums) {
            xmlBuilder.append("<album>")
                    .append("<id>").append(album.getId()).append("</id>")
                    .append("<name>").append(album.getName()).append("</name>")
                    .append("<recordLabel>").append(album.getLabel()).append("</recordLabel>")
                    .append("</album>");
        }
        xmlBuilder.append("</albums>");
        return xmlBuilder.toString();
    }
}
