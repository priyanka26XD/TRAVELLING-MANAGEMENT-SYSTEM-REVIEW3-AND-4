<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Profile</title>
</head>
<body>
    <h1>User Profile</h1>

    <!-- Display user data -->
    <p><strong>Name:</strong> ${user.name}</p>
    <p><strong>Email:</strong> ${user.email}</p>

    <!-- Optional: Redirect to registration page if no user data exists -->
    <a href="register.jsp">Go to Registration Form</a>
</body>
</html>
