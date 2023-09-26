<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 26/09/2023
  Time: 12:47 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add New Product</title>
</head>
<body>
    <h1>
        New Product
    </h1>

    <form action="AddNewProduct" method="post">
        <table style="width:300px">
            <tr>
                <td>Name</td>
                <td><input type="text" name="name"><br></td>
            </tr>

            <tr>
                <td>Category</td>
                <td><input type="text" name="category"><br></td>
            </tr>
            <tr>
                <td>Quantity</td>
                <td><input type="text" name="quantity"><br></td>
            </tr>

            <tr>
                <td>Price</td>
                <td><input type="text" name="price"><br></td>
            </tr>

        </table>

        <input type="submit" value="submit">
        <a href="${pageContext.request.contextPath}/admin_home" style="color: black;
                                    text-decoration: none"> Done </a>
    </form>
</body>
</html>
