<%--
  Created by IntelliJ IDEA.
  User: Donatus
  Date: 26/09/2023
  Time: 9:25 am
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin Registration</title>
</head>
<body>
  <h1>
    New Admin Registration
  </h1>
  <form action="admin_register" method="post">
    <table style="width:300px">
      <tr>
        <td>Name</td>
        <td><input type="text" name="name"><br></td>
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
        <td>Phone No.</td>
        <td><input type="text" name="phone"><br></td>
      </tr>

    </table>

    <input type="submit" value="submit">
  </form>
</body>
</html>
