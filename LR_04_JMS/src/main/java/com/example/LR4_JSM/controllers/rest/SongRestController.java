package com.example.LR4_JSM.controllers.rest;
import com.example.LR4_JSM.dto.SongDto;
import com.example.LR4_JSM.entities.Song;
import com.example.LR4_JSM.services.SongService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/songs")
public class SongRestController  {
    private final SongService service;

    public SongRestController(SongService service) {
        this.service = service;
    }

    @GetMapping
    public List<Song> getAll() {
        return service.findAll();
    }

    @PutMapping
    public void add(@RequestBody SongDto dto) {
        service.save(dto);
    }

    @PostMapping
    public void update(@RequestBody Song song) {
        service.update(song);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        service.delete(id);
    }
}
