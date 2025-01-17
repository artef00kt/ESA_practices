package com.example.LR3_Rest.controllers.rest;

import com.example.LR3_Rest.entities.Album;
import com.example.LR3_Rest.services.AlbumService;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/v1/albums")
public class AlbumRestController {
    private final AlbumService service;

    public AlbumRestController(AlbumService service) {
        this.service = service;
    }

    public List<Album> getAll() {
        return service.findAll();
    }
}
