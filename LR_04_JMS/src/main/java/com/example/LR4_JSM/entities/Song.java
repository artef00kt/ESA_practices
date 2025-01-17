package com.example.LR4_JSM.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

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
    @ToString.Exclude
    private Album album;

}
