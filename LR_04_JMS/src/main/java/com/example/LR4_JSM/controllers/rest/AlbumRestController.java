package com.example.LR4_JSM.controllers.rest;

import com.example.LR4_JSM.dto.AlbumDto;
import com.example.LR4_JSM.entities.Album;
import com.example.LR4_JSM.services.AlbumService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/albums")
public class AlbumRestController {
    private final AlbumService service;

    public AlbumRestController(AlbumService service) {
        this.service = service;
    }

    @GetMapping
    public List<Album> getAll() {
        return service.findAll();
    }

    @PutMapping
    public void add(@RequestBody AlbumDto dto) {
        service.save(dto);
    }

    @PostMapping
    public void update(@RequestBody Album album) {
        service.update(album);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        service.delete(id);
    }
}
