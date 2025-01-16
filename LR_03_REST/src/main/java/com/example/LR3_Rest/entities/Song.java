package com.example.LR3_Rest.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "song")
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
