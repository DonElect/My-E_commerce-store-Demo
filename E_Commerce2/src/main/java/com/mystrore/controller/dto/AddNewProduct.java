package com.mystrore.controller.dto;


import com.mystrore.dao.AdminDAO;
import com.mystrore.model.Products;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "AddNewProduct", value = "/AddNewProduct")
public class AddNewProduct extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        this.doPost(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        if("done".equals(req.getParameter("done"))){
            RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/adminHomePage.jsp");
            dispatcher.forward(req, res);
        }
        Products product = new Products(req.getParameter("name"),
                                        req.getParameter("category"),
                                        Integer.parseInt(req.getParameter("quantity")),
                                        Double.parseDouble(req.getParameter("price")));


        try {
            AdminDAO.addProduct(product);
        } catch (SQLException e) {
            System.out.println("Error adding new product! "+e);
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/addNewProduct.jsp");
        dispatcher.forward(req, res);
    }
}