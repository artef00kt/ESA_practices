package com.example.LR2_Spring.entities;


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

    @Column(name = "record_label")
    private String label;

}
