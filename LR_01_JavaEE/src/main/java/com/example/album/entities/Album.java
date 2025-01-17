package com.example.album.entities;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "album")
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String record_label;

}
