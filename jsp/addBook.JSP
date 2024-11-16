<!DOCTYPE html>
<html>
<head>
    <title>Add Book</title>
</head>
<body>
    <h1>Add a New Book</h1>
    <form action="add" method="post">
        Book Id:<input type="number" name="bookid"><br><br>
        Book Name: <input type="text" name="bookname" required><br><br>
        Author Name: <input type="text" name="authorname" required><br><br>
        Category: <input type="text" name="category" required><br><br>
        <button type="submit">Add Book</button>
    </form>
</body>
</html>


