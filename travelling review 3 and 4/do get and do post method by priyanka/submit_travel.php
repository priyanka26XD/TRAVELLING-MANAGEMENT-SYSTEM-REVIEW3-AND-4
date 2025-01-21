<?php
// Check if the form was submitted using GET method
if ($_SERVER['REQUEST_METHOD'] == 'GET') {
    // Retrieve travel data from the URL parameters
    $name = isset($_GET['name']) ? $_GET['name'] : '';
    $destination = isset($_GET['destination']) ? $_GET['destination'] : '';
    $date = isset($_GET['date']) ? $_GET['date'] : '';
    $email = isset($_GET['email']) ? $_GET['email'] : '';

    echo "<h1>Travel Booking Details (GET Method)</h1>";
    echo "<p><strong>Name:</strong> $name</p>";
    echo "<p><strong>Destination:</strong> $destination</p>";
    echo "<p><strong>Travel Date:</strong> $date</p>";
    echo "<p><strong>Email:</strong> $email</p>";
}

// Check if the form was submitted using POST method
if ($_SERVER['REQUEST_METHOD'] == 'POST') {
    // Retrieve travel data from the POST form submission
    $name = isset($_POST['name']) ? $_POST['name'] : '';
    $destination = isset($_POST['destination']) ? $_POST['destination'] : '';
    $date = isset($_POST['date']) ? $_POST['date'] : '';
    $email = isset($_POST['email']) ? $_POST['email'] : '';

    echo "<h1>Travel Booking Details (POST Method)</h1>";
    echo "<p><strong>Name:</strong> $name</p>";
    echo "<p><strong>Destination:</strong> $destination</p>";
    echo "<p><strong>Travel Date:</strong> $date</p>";
    echo "<p><strong>Email:</strong> $email</p>";
}
?>
