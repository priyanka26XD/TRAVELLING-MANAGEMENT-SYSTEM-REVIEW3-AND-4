<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Travel Management System - POST</title>
</head>
<body>
    <h1>Submit Travel Details (POST Method)</h1>
    
    <!-- POST method form -->
    <form action="SubmitServlet" method="post">
        <label for="name">Name:</label><br>
        <input type="text" id="name" name="name" required><br><br>

        <label for="destination">Destination:</label><br>
        <input type="text" id="destination" name="destination" required><br><br>

        <label for="date">Travel Date:</label><br>
        <input type="date" id="date" name="date" required><br><br>

        <label for="email">Email:</label><br>
        <input type="email" id="email" name="email" required><br><br>

        <input type="submit" value="Submit">
    </form>

</body>
</html>
