package com.example.album.services;

import com.example.album.entities.Song;
import com.example.album.dao.SongDao;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;

import java.util.List;

@Stateless
public class SongService {

    @EJB
    private SongDao songDao;

    public List<Song> getAllSongs() {
        List<Song> songs = songDao.findAll();
        System.out.println("songs: "  + songs);
        return songs;
    }

    public void createSong(Song newTeam) {
        songDao.save(newTeam);
    }

    public void deleteSong(Long id) {
        songDao.delete(id);
    }

    public void updateSong(Song newTeam) {
        songDao.update(newTeam);
    }
}
