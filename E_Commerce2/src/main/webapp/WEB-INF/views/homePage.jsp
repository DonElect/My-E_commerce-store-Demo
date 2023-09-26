<%--
  Created by IntelliJ IDEA.
  User: Donatus
  Date: 24/09/2023
  Time: 3:55 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Home</title>
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
          <li><a style="color: gold" href="prod_cat?cat=<c:out value='${category}' />"><c:out value="${category}" /></a></li>
        </c:forEach>
      </ul>
      <a  href="<%=request.getContextPath()%>/Cart">MY CART</a>
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
          <td><a style="color: maroon" href="addToCart?id=<c:out value='${prod.getId()}' />">Add To Cart</a></td>
<%--            &nbsp;&nbsp;&nbsp;&nbsp; <a style="color: darkgreen"--%>
<%--                    href="removeFromCart?id=<c:out value='${prod.getId()}' />">Remove From Cart</a></td>--%>
        </tr>
      </c:forEach>
      <!-- } -->
      </tbody>

    </table>
</body>
</html>
