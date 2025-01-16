package com.example.LR2_Spring.services;

import com.example.LR2_Spring.entities.Album;
import com.example.LR2_Spring.repositories.AlbumRepository;
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

    public void save(Album entity) {
        albumRepository.save(entity);
    }
}
