<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 26/09/2023
  Time: 9:53 am
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin Login</title>
</head>
<body>
    <form action="admin_login" method="post">
        <table style="width:300px">
            <tr>
                <td>Email</td>
                <td><input type="email" name="email"><br></td>
            </tr>

            <tr>
                <td>Password</td>
                <td><input type="password" name="password"><br></td>
            </tr>
        </table>
        <button type="submit">Login</button>
        <button><a href="admin_register" style="color: black">Create Account</a> </button>
    </form>
</body>
</html>
