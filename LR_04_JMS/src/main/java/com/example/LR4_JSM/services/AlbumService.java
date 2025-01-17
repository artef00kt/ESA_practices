package com.example.LR4_JSM.services;

import com.example.LR4_JSM.controllers.common.AuditService;
import com.example.LR4_JSM.dto.AlbumDto;
import com.example.LR4_JSM.entities.Album;
import com.example.LR4_JSM.mappers.AlbumMapper;
import com.example.LR4_JSM.repositories.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumService {

    private final AlbumRepository albumRepository;

    private final AuditService auditService;


    @Autowired
    public AlbumService(AlbumRepository albumRepository, AuditService auditService) {
        this.albumRepository = albumRepository;
        this.auditService = auditService;
    }

    public Album findById(Long id) {
        return albumRepository
            .findById(id)
            .orElseThrow(
                () -> new RuntimeException("No album with id: " + id)
            );
    }

    public List<Album> findAll() {
        return albumRepository.findAll();
    }

    public void save(AlbumDto dto) {
        Album album = albumRepository.save(
            AlbumMapper.toEntity(dto)
        );
        auditService.insertAuditEvent(album);
    }

    public void delete(Long id) {
        Album album = albumRepository
            .findById(id)
            .orElseThrow(
                () -> new RuntimeException("No album with id: " + id)
            );
        albumRepository.deleteById(id);
        auditService.deleteAuditEvent(album);
    }

    public void update(Album entity) {
        albumRepository
            .findById(entity.getId())
            .orElseThrow(
                () -> new RuntimeException("No album with id: " + entity.getId())
            );
        Album updatedLibrary = albumRepository.save(entity);
        auditService.updateAuditEvent(updatedLibrary);
    }

    public String getAlbumsAsXml() {
        List<Album> albums = findAll();
        StringBuilder xmlBuilder = new StringBuilder();
        xmlBuilder.append("<albums>");
        for (Album album : albums) {
            xmlBuilder
                .append("<album>")
                .append("<id>").append(album.getId()).append("</id>")
                .append("<name>").append(album.getName()).append("</name>")
                .append("<recordLabel>").append(album.getLabel()).append("</recordLabel>")
                .append("</album>");
        }
        xmlBuilder.append("</albums>");
        return xmlBuilder.toString();
    }
}
