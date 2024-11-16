<%-- 
    Document   : Updatelibrary
    Created on : Nov 15, 2024, 7:26:00 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <body>
        <form action="update" method="post">
            Book Id:<input type="number" name="bookid"><br><br>
            Book Name: <input type="text" name="bookname" required><br><br>
            Author Name: <input type="text" name="authorname" required><br><br>
            Category: <input type="text" name="category" required><br><br>
        <button type="submit">UPDATE LIBRARY</button>
    </form>
    </body>
    </body>
</html>

