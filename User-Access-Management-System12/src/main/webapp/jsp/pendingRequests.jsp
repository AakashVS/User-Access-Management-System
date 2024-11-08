<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Pending Requests</title>
</head>
<body>
    <h2>Pending Access Requests</h2>
    <form action="approval" method="post">
        <table border="1">
            <tr>
                <th>Employee Name</th>
                <th>Software</th>
                <th>Access Type</th>
                <th>Reason</th>
                <th>Action</th>
            </tr>
            <!-- Populate this table with pending requests from the database -->
            <tr>
                <td>John Doe</td>
                <td>Software 1</td>
                <td>Write</td>
                <td>For project development</td>
                <td>
                    <button name="request_id" value="1" formaction="approval?status=Approved">Approve</button>
                    <button name="request_id" value="1" formaction="approval?status=Rejected">Reject</button>
                </td>
            </tr>
            <!-- Repeat rows for each pending request -->
        </table>
    </form>
</body>
</html>
