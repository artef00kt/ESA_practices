<%@ page import="com.example.album.entities.Album" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Collections" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>Albums</title></head>
<body>
<h1>Album Management</h1>

<h2>Add Album</h2>
<form action="albums" method="post">
    <input type="text" name="name" placeholder="Album Name" required>
    <input type="text" name="record_label" placeholder="Album Record Label" required>
    <input type="hidden" name="action" value="add">
    <button type="submit">Add Album</button>
</form>

<h2>All Albums</h2>
<ul>
    <%  List<Album> albumList = (List<Album>) request.getAttribute("albums");
        for (Album album : albumList) {
    %>
    <li>
        <form action="albums" method="post" style="display:inline;">
            ID: <%= album.getId() %>, Name: <%= album.getName() %>, Address: <%= album.getRecord_label() %>
            <input type="hidden" name="id" value="<%= album.getId() %>">
            <input type="hidden" name="action" value="delete">
            <button type="submit">Delete</button>
        </form>
    </li>
    <% } %>
</ul>

</body>
</html>
