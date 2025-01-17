package com.example.LR4_JSM.services;

import com.example.LR4_JSM.controllers.common.AuditService;
import com.example.LR4_JSM.dto.SongDto;
import com.example.LR4_JSM.entities.Song;
import com.example.LR4_JSM.mappers.SongMapper;
import com.example.LR4_JSM.repositories.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class SongService {

    private final SongRepository songRepository;

    private final AlbumService albumService;

    private final AuditService auditService;

    @Autowired
    public SongService(SongRepository songRepository, AlbumService albumService, AuditService auditService) {
        this.songRepository = songRepository;
        this.albumService = albumService;
        this.auditService = auditService;
    }

    public Song findById(Long id) {
        return songRepository
            .findById(id)
            .orElseThrow(
                () -> new NoSuchElementException("No song with id: " + id)
            );
    }

    public List<Song> findAll() {
        return songRepository.findAll();
    }

    public void save(SongDto dto) {
        Song song = SongMapper.toEntity(dto);
        song.setAlbum(
            albumService.findById(dto.getAlbumId())
        );
        Song newBook = songRepository.save(song);
        auditService.insertAuditEvent(newBook);
    }

    public void delete(Long id) {
        Song song = songRepository
            .findById(id)
            .orElseThrow(
                () -> new NoSuchElementException("No song with id: " + id)
            );
        songRepository.deleteById(id);
        auditService.deleteAuditEvent(song);
    }

    public void update(Song entity) {
        songRepository
            .findById(entity.getId())
            .orElseThrow(
                () -> new NoSuchElementException("No song with id: " + entity.getId())
            );
        Song updatedBook = songRepository.save(entity);
        auditService.updateAuditEvent(updatedBook);
    }

    public String getSongsAsXml() {
        List<Song> songs = findAll();
        StringBuilder xmlBuilder = new StringBuilder();
        xmlBuilder.append("<songs>");
        for (Song song : songs) {
            xmlBuilder
                .append("<song>")
                .append("<id>").append(song.getId()).append("</id>")
                .append("<title>").append(song.getTitle()).append("</title>")
                .append("<executor>").append(song.getExecutor()).append("</executor>")
                .append("</song>");
        }
        xmlBuilder.append("</songs>");
        return xmlBuilder.toString();
    }
}
