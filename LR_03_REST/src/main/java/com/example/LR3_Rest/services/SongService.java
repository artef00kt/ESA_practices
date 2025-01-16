package com.example.LR3_Rest.services;

import com.example.LR3_Rest.entities.Song;
import com.example.LR3_Rest.repositories.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService {

    private final SongRepository songRepository;

    private final AlbumService albumService;

    @Autowired
    public SongService(SongRepository songRepository, AlbumService albumService) {
        this.songRepository = songRepository;
        this.albumService = albumService;
    }

    public List<Song> findAll() {
        return songRepository.findAll();
    }

    public String getSongsAsXml() {
        List<Song> songs = findAll();
        StringBuilder xmlBuilder = new StringBuilder();
        xmlBuilder.append("<songs>");
        for (Song song : songs) {
            xmlBuilder.append("<song>")
                    .append("<id>").append(song.getId()).append("</id>")
                    .append("<title>").append(song.getTitle()).append("</title>")
                    .append("<executor>").append(song.getExecutor()).append("</executor>")
                    .append("</song>");
        }
        xmlBuilder.append("</songs>");
        return xmlBuilder.toString();
    }
}
