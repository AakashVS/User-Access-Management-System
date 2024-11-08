<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>User Sign-Up</title>
</head>
<body>
    <h2>Sign Up</h2>
    <form action="signup" method="post">
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" required>
        <br><br>
        
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required>
        <br><br>
        
        <input type="hidden" name="role" value="Employee">
        <button type="submit">Sign Up</button>
    </form>
    <p>Already have an account? <a href="login.jsp">Log in here</a>.</p>
</body>
</html>
