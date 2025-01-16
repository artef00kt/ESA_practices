package com.example.LR2_Spring.services;

import com.example.LR2_Spring.entities.Song;
import com.example.LR2_Spring.repositories.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService {

    private final SongRepository songRepository;

    @Autowired
    public SongService(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    public List<Song> findAll() {
        return songRepository.findAll();
    }

    public void save(Song entity) {
        songRepository.save(entity);
    }
}
