package com.example.album.services;

import com.example.album.entities.Album;
import com.example.album.dao.AlbumDao;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;

import java.util.List;

@Stateless
public class AlbumService {

    @EJB
    private AlbumDao albumDao;

    public List<Album> getAllAlbums() {
        return albumDao.findAll();
    }

    public Album getAlbumById(Long id) {
        return albumDao.findById(id);
    }

    public void createAlbum(Album album) {
        albumDao.save(album);
    }

    public void deleteAlbum(Long id) {
        albumDao.delete(id);
    }

    public void updateAlbum(Album album) {
        albumDao.update(album);
    }

}
