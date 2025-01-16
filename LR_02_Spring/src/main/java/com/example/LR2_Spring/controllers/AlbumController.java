package com.example.LR2_Spring.controllers;

import com.example.LR2_Spring.entities.Album;
import com.example.LR2_Spring.services.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/albums")
public class AlbumController {

    private final AlbumService albumService;

    @Autowired
    public AlbumController(AlbumService albumService) {
        this.albumService = albumService;
    }

    @GetMapping
    public String listAlbums(Model model) {
        model.addAttribute("albums", albumService.findAll());
        return "albums";
    }

    @PostMapping
    public String saveAlbums(@ModelAttribute Album album) {
        albumService.save(album);
        return "redirect:/albums";
    }
}
