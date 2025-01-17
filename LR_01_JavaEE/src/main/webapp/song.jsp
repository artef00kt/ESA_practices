<%@ page import="com.example.album.entities.Album" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.album.entities.Song" %>
<%@ page import="java.util.Collections" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>Songs</title></head>
<body>
<h1>Song Management</h1>

<h2>Add Song</h2>
<form action="songs" method="post">
    <input type="text" name="title" placeholder="Song Title" required>
    <input type="text" name="executor" placeholder="Song Executor" required>
    <select name="album_id">
        <option disabled selected>Select Album</option>
        <%
            List<Album> albumList = (List<Album>) request.getAttribute("albums");
            for (Album album : albumList) {
                %>
        <option value="<%= album.getId() %>"><%= album.getName() %></option>
        <% } %>
    </select>
    <input type="hidden" name="action" value="add">
    <button type="submit">Add Song</button>
</form>

<h2>All Songs</h2>
<ul>
    <%
        List<Song> songList =  (List<Song>) request.getAttribute("songs");
        for (Song song : songList) {
    %>
    <li>
        ID: <%= song.getId() %>, Title: <%= song.getTitle() %>, Executor: <%= song.getExecutor() %>, Album: <%= song.getAlbum().getName() %>
        <form action="songs" method="post" style="display:inline;">
            <input type="hidden" name="id" value="<%= song.getId() %>">
            <input type="hidden" name="action" value="delete">
            <button type="submit">Delete</button>
        </form>
    </li>
    <% } %>
</ul>

</body>
</html>
