package com.example.LR2_Spring.controllers;

import com.example.LR2_Spring.entities.Song;
import com.example.LR2_Spring.services.SongService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/songs")
public class SongController {

    private final SongService songService;

    public SongController(SongService songService) {
        this.songService = songService;
    }

    @GetMapping
    public String listSongs(Model model) {
        model.addAttribute("songs", songService.findAll());
        return "songs";
    }

    @PostMapping
    public String saveSong(@ModelAttribute Song song) {
        songService.save(song);
        return "redirect:/songs";
    }
}
