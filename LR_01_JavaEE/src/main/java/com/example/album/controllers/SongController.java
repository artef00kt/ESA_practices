package com.example.album.controllers;

import com.example.album.entities.Song;
import com.example.album.services.SongService;
import com.example.album.services.AlbumService;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/songs")
public class SongController extends HttpServlet {

    @EJB
    private SongService songService;

    @EJB
    private AlbumService albumService;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("songs", songService.getAllSongs());
        request.setAttribute("albums", albumService.getAllAlbums());
        request.getRequestDispatcher("song.jsp").forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("add".equals(action)) {
            String title = request.getParameter("title");
            String executor = request.getParameter("executor");
            Long albumId = Long.parseLong(request.getParameter("album_id"));

            Song song = new Song();
            song.setTitle(title);
            song.setExecutor(executor);
            song.setAlbum(albumService.getAlbumById(albumId));

            songService.createSong(song);

        } else if ("delete".equals(action)) {
            Long id = Long.parseLong(request.getParameter("id"));
            songService.deleteSong(id);

        }

        doGet(request, response);
    }
}
