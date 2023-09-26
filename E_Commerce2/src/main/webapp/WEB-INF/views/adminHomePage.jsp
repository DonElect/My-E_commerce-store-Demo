<%--
  Created by IntelliJ IDEA.
  User: Donatus
  Date: 26/09/2023
  Time: 10:27 am
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <header>
        <nav class="navbar navbar-expand-md navbar-dark"
             style="background-color: tomato">
            <div>
                <a class="navbar-brand"> WELCOME TO DON FEAST </a>
            </div>

            <ul class="navbar-nav">
                <h3><a href="<%=request.getContextPath()%>/list"
                       class="nav-link">CATEGORIES</a></h3>
                <jsp:useBean id="categories" scope="request" type="java.util.List"/>
                <c:forEach var="category" items="${categories}">
                    <%--                     <li> <td><c:out value="${category}" /></td></li>--%>
                    <li><a style="color: gold" href="view_by_cat/>"><c:out value="${category}" /></a></li>
                </c:forEach>
            </ul>
            <a  href="<%=request.getContextPath()%>/addProduct">Add New Product</a>
        </nav>
    </header>
    <br>

    <div class="container">
        <h3 class="text-center">List of Products</h3>
        <hr>
    </div>
    <br>
    <table class="table table-bordered">
        <thead>
        <tr>
            <th>Name</th>
            <th>CATEGORY</th>
            <th>QUANTITY</th>
            <th>UNIT PRICE</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <!--   for (Todo todo: todos) {  -->
        <jsp:useBean id="productList" scope="request" type="java.util.List"/>
        <c:forEach var="prod" items="${productList}">

            <tr>
                <td><c:out value="${prod.getName()}" /></td>
                <td><c:out value="${prod.getCategory()}" /></td>
                <td><c:out value="${prod.getQuantity()}" /></td>
                <td><c:out value="${prod.getUnit_price()}" /></td>
                <td><a style="color: maroon" href="${pageContext.request.contextPath}/removeProduct?id=<c:out value='${prod.getId()}' />">Remove product</a></td>
                    <%--            &nbsp;&nbsp;&nbsp;&nbsp; <a style="color: darkgreen"--%>
                    <%--                    href="removeFromCart?id=<c:out value='${prod.getId()}' />">Remove From Cart</a></td>--%>
            </tr>
        </c:forEach>
        <!-- } -->
        </tbody>

    </table>
</body>
</html>
