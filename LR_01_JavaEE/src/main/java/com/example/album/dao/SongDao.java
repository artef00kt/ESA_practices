package com.example.album.dao;


import com.example.album.entities.Song;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;


import java.util.List;


@Stateless
public class SongDao {

    @PersistenceContext
    private EntityManager entityManager;


    public void save(Song song) {
        entityManager.persist(song);
    }

    public Song update(Song song) {
        return entityManager.merge(song);
    }

    public void delete(Long id) {
        Song song = entityManager.find(Song.class, id);
        if (song != null) {
            entityManager.remove(song);
        }
    }

    public List<Song> findAll() {
        List<Song> songs =  entityManager
                .createQuery("SELECT s FROM Song s", Song.class)
                .getResultList();
        System.out.println("songs: "  + songs);
        return songs;
    }

    public Song findById(Long id) {
        return entityManager.find(Song.class, id);
    }

    public List<Song> getSongsByAlbumId(Long albumId) {
        return entityManager.createQuery("SELECT s FROM Song s WHERE s.album.id = :albumId", Song.class)
                .setParameter("albumId", albumId)
                .getResultList();
    }
}
