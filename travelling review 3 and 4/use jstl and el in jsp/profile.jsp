<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Profile</title>
</head>
<body>
    <h1>User Profile</h1>

    <!-- Use EL to access the 'user' object from session -->
    <c:if test="${not empty user}">
        <p><strong>Name:</strong> ${user.name}</p>
        <p><strong>Email:</strong> ${user.email}</p>

        <!-- Format the password (just for demonstration, but typically you'd avoid displaying passwords) -->
        <p><strong>Password:</strong> ${user.password}</p>
    </c:if>

    <c:if test="${empty user}">
        <p>No user data found. Please <a href="register.jsp">register</a> first.</p>
    </c:if>

    <a href="register.jsp">Go to Registration Form</a>
</body>
</html>
