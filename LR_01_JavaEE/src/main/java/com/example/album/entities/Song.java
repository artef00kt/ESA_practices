package com.example.album.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name = "song")
@Entity
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String executor;

    @ManyToOne
    @JoinColumn(name = "album_id")
    private Album album;

}
