package com.example.album.dao;


import com.example.album.entities.Album;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;


@Stateless
public class AlbumDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Album album) {
        entityManager.persist(album);
    }

    public Album findById(Long id) {
        return entityManager.find(Album.class, id);
    }

    public List<Album> findAll() {
        return entityManager.createQuery("SELECT a FROM Album a", Album.class).getResultList();
    }

    public Album update(Album album) {
        return entityManager.merge(album);
    }

    public void delete(Long id) {
        Album album = entityManager.find(Album.class, id);
        if (album != null) {
            entityManager.remove(album);
        }
    }
}
