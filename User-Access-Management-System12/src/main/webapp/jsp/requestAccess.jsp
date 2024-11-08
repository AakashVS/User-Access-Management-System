<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Request Access</title>
</head>
<body>
    <h2>Request Access to Software</h2>
    <form action="requestAccess" method="post">
        <label for="software">Software:</label>
        <select id="software" name="software_id" required>
            <!-- Populate with software options dynamically from the database -->
            <option value="1">Software 1</option>
            <option value="2">Software 2</option>
        </select>
        <br><br>
        
        <label for="access_type">Access Type:</label>
        <select id="access_type" name="access_type" required>
            <option value="Read">Read</option>
            <option value="Write">Write</option>
            <option value="Admin">Admin</option>
        </select>
        <br><br>
        
        <label for="reason">Reason for Access:</label>
        <textarea id="reason" name="reason" rows="3" cols="30"></textarea>
        <br><br>
        
        <button type="submit">Submit Request</button>
    </form>
</body>
</html>
