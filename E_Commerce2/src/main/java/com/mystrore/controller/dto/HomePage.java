package com.mystrore.controller.dto;


import com.mystrore.dao.CustomerDao;
import com.mystrore.dao.UserFunctionsDAO;
import com.mystrore.model.Customer;
import com.mystrore.model.Products;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.swing.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

//@WebServlet(name = "HomePage", value = "/home")
@WebServlet({"/home", "/list", "/addToCart", "/removeFromCart", "/Cart", "/prod_cat"})
public class HomePage extends HttpServlet {
    private CustomerDao customerDao;
    private UserFunctionsDAO customerFunctions;
    private final Customer customer = new Customer();
    public HomePage(){

    }

    public void init() {
        this.customerDao = new CustomerDao();
        this.customerFunctions = new UserFunctionsDAO();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        this.doGet(req, res);
    }

//    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        try {
            if ("list".equals(req.getAttribute("list"))) {
                req.removeAttribute("list");
                this.list_products(req, res);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
//        req.getContextPath()
        try {
            switch (req.getServletPath()){
                case "/list" ->
                        this.list_products(req,res);
                case "/addToCart" ->
                        this.add_to_cart(req, res);
                case "/removeFromCart"->
                        this.remove_from_cart(req, res);
                case "/Cart"->
                        this.customer_cart(req, res);
                case "/prod_cat"->
                    this.view_by_category(req, res);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    private void list_products(HttpServletRequest req, HttpServletResponse res) throws SQLException, ServletException, IOException {
        List<Products> productsList = this.customerFunctions.listProducts();
        List<String> cat_list = this.customerFunctions.viewCategories();
        req.setAttribute("productList", productsList);
        req.setAttribute("categories", cat_list);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/homePage.jsp");
        dispatcher.forward(req, res);
    }

    private void add_to_cart(HttpServletRequest req, HttpServletResponse res) throws IOException, SQLException {
        int prod_id = Integer.parseInt(req.getParameter("id"));
        int cust_id = Customer.getId();
        this.customerDao.addToCart(prod_id, cust_id);
        res.sendRedirect("list");
    }

    private void customer_cart(HttpServletRequest req, HttpServletResponse res) throws SQLException, ServletException, IOException {
        List<Products> cart = this.customerDao.viewCart(Customer.getId());
        req.setAttribute("cart", cart);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/customerCart.jsp");
        dispatcher.forward(req, res);
    }

    private void remove_from_cart(HttpServletRequest req, HttpServletResponse res) throws SQLException, IOException {
        int prod_id = Integer.parseInt(req.getParameter("id"));
        int cust_id = Customer.getId();
        this.customerDao.removeFromCart(prod_id, cust_id);
        res.sendRedirect("Cart");
    }

    private void view_by_category(HttpServletRequest req, HttpServletResponse res) throws SQLException, ServletException, IOException {
        String cat = req.getParameter("cat");
        List<Products> productsList = this.customerFunctions.listByCategory(cat);
        List<String> cat_list = this.customerFunctions.viewCategories();
        req.setAttribute("productList", productsList);
        req.setAttribute("categories", cat_list);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/homePage.jsp");
        dispatcher.forward(req, res);
    }
}