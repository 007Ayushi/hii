<%@page import="ayushi.showlibrary"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="ayushi.showlibrary"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Book Details</title>
    </head>
    <body>
        <form action="showlibrary" method="POST">
            <label> Enter Book Id </label>
            <input type="number" name="bookid" >
            <input type="text" name="category">
            <input type="submit" name="Submit">
        </form>
     
        <h1>LIBRARY DISPLAYED</h1>
        <h3>Book ID: <%= request.getAttribute("bookid") %></h3>
        <h3>Book Name: <%= request.getAttribute("bookname") %></h3>
        <h3>Author name: <%= request.getAttribute("authorname") %></h3>
        <h3>Category: <%= request.getAttribute("category") %></h3>
    </body>
</html>
