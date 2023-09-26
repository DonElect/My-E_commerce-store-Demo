<%--
  Created by IntelliJ IDEA.
  User: Donatus
  Date: 22/09/2023
  Time: 8:23 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer registration Portal</title>
</head>
<body>
    <h1>
        New Customer Registration
    </h1>
    <form action="register" method="post">
        <table style="width:300px">
            <tr>
                <td>First Name</td>
                <td><input type="text" name="firstName"><br></td>
            </tr>
            <tr>
                <td>Last Name</td>
                <td><input type="text" name="lastName"><br></td>
            </tr>
            <tr>
                <td>Email</td>
                <td><input type="email" name="email"><br></td>
            </tr>
            <tr>
                <td>Password</td>
                <td><input type="password" name="password"><br></td>
            </tr>
            <tr>
<%--                <label for="date">Birth Date(Optional) (YYYY-MM-DD):</label>--%>
<%--                <input type="date" name="date" id="date" placeholder="YYYY-MM-DD">--%>
                <td><label for="date">Birth Date(Optional) (YYYY-MM-DD):</label></td>
                <td><input type="text" name="birthDate" id="date" placeholder="YYYY-MM-DD"><br></td>
            </tr>
            <tr>
                <td>Phone No.</td>
                <td><input type="text" name="phone"><br></td>
            </tr>
            <tr>
                <td>Address</td>
                <td><input type="text" name="address"><br></td>
            </tr>
            <tr>
                <td>City</td>
                <td><input type="text" name="city"><br></td>
            </tr>
            <tr>
                <td>State</td>
                <td><input type="text" name="state"><br></td>
            </tr>
            <tr>
                <td>Country</td>
                <td><input type="text" name="country"><br></td>
            </tr>
        </table>

        <input type="submit" value="submit">
    </form>
</body>
</html>
