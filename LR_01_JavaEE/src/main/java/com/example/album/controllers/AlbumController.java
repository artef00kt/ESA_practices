package com.example.album.controllers;

import com.example.album.entities.Album;
import com.example.album.services.AlbumService;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/albums")
public class AlbumController extends HttpServlet {

    @EJB
    private AlbumService albumService;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("albums", albumService.getAllAlbums());
            request.getRequestDispatcher("album.jsp").forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("add".equals(action)) {
            String name = request.getParameter("name");
            String record_label = request.getParameter("record_label");

            Album album = new Album();
            album.setName(name);
            album.setRecord_label(record_label);

            albumService.createAlbum(album);

        } else if ("delete".equals(action)) {
            Long id = Long.parseLong(request.getParameter("id"));
            albumService.deleteAlbum(id);

        }

        doGet(request, response);
    }
}
