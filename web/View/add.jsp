<%--
  Created by IntelliJ IDEA.
  User: Nout
  Date: 06.11.2019
  Time: 12:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add new user</title>
</head>
<body>
<form method="POST">
    <label>Name:
        <input type="text" name="name"><br/>
    </label>

    <label>Password:
        <input type="text" name="password"><br/>
    </label>

    <label>Role:
        <input type="text" name="role"><br/>
    </label>

    <label>Job:
        <input type="text" name="job"><br/>
    </label>

    <label>Salary:
        <input type="text" name="salary"><br/>
    </label>

    <button type="submit">Submit</button>

</form>
    <button onclick="location.href='/admin/users'">Back</button>
</body>
</html>
