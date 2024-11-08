<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Create Software</title>
</head>
<body>
    <h2>Create New Software Application</h2>
    <form action="software" method="post">
        <label for="name">Software Name:</label>
        <input type="text" id="name" name="name" required>
        <br><br>
        
        <label for="description">Description:</label>
        <textarea id="description" name="description" rows="3" cols="30"></textarea>
        <br><br>
        
        <label>Access Levels:</label>
        <input type="checkbox" name="access_levels" value="Read"> Read
        <input type="checkbox" name="access_levels" value="Write"> Write
        <input type="checkbox" name="access_levels" value="Admin"> Admin
        <br><br>
        
        <button type="submit">Create Software</button>
    </form>
</body>
</html>
