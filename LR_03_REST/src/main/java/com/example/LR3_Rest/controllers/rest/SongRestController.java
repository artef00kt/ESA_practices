package com.example.LR3_Rest.controllers.rest;

import com.example.LR3_Rest.entities.Song;
import com.example.LR3_Rest.services.SongService;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/v1/books")
public class SongRestController  {
    private final SongService service;

    public SongRestController(SongService service) {
       this.service = service;
    }

    public List<Song> getAll() {
        return service.findAll();
    }
}
