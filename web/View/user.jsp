<%--
  Created by IntelliJ IDEA.
  User: Nout
  Date: 11.11.2019
  Time: 23:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

            <h4>Hello ${user.name} !</h4>
            <h4>Your id: ${user.id}</h4>
            <h4>Name: ${user.name}</h4>
            <h4>Job: ${user.job}</h4>
            <h4>Salary: ${user.salary}</h4>

            <button onclick="location.href='/homepage'">Logout</button>


</body>
</html>
