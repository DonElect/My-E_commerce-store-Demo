<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Donatus
  Date: 25/09/2023
  Time: 8:41 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cart</title>
</head>
<body>
<header>
    <nav style="background-color: red;
                    width: auto;
                    height: 100px;
                    text-align: center">
        <h2>My Cart</h2>
    </nav>
    <h3><a href="<%=request.getContextPath()%>/list">Complete List</a></h3>
</header>

<table class="table table-bordered">
    <thead>
    <tr>
        <th>Name</th>
        <th>QUANTITY</th>
        <th>UNIT PRICE</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <!--   for (Todo todo: todos) {  -->
    <jsp:useBean id="cart" scope="request" type="java.util.List"/>
    <c:forEach var="prod" items="${cart}">

        <tr>
            <td><c:out value="${prod.getName()}" /></td>
            <td><c:out value="${prod.getQuantity()}" /></td>
            <td><c:out value="${prod.getUnit_price()}" /></td>
            <td><a style="color: darkgreen" href="removeFromCart?id=<c:out value='${prod.getId()}' />">Remove</a>
        </tr>
    </c:forEach>
    <!-- } -->
    </tbody>

</table>

</body>
</html>
