package com.mystrore.controller.dto;


import com.mystrore.dao.AdminDAO;
import com.mystrore.dao.UserFunctionsDAO;
import com.mystrore.model.Products;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet({"/admin_home", "/product_list", "/removeProduct", "/addProduct", "/view_by_cat"})
public class AdminHomePage extends HttpServlet {

    private UserFunctionsDAO adminFunctions;
    private AdminDAO adminDAO;

    public void init(){
        this.adminFunctions = new UserFunctionsDAO();
        this.adminDAO = new AdminDAO();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        this.doGet(req, res);
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        try {
            if ("product_list".equals(req.getAttribute("product_list"))) {
                req.removeAttribute("product_list");
                this.list_products(req, res);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            switch (req.getServletPath()) {
                case "/product_list", "/admin_home" -> this.list_products(req, res);
                case "/removeProduct" -> this.removeProduct(req, res);
                case "/addProduct" -> this.addProduct(req, res);
                case "/view_by_cat"  -> this.view_by_category(req, res);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void list_products(HttpServletRequest req, HttpServletResponse res) throws SQLException, ServletException, IOException {
        List<Products> productsList = this.adminFunctions.listProducts();
        List<String> cat_list = this.adminFunctions.viewCategories();
        req.setAttribute("productList", productsList);
        req.setAttribute("categories", cat_list);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/adminHomePage.jsp");
        dispatcher.forward(req, res);
    }

    private void removeProduct(HttpServletRequest req, HttpServletResponse res) throws SQLException, IOException {
        int prod_id = Integer.parseInt(req.getParameter("id"));
        this.adminDAO.remove_product(prod_id);

        System.out.println("Product removed!");
        res.sendRedirect("product_list");
    }

    private void addProduct(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/addNewProduct.jsp");
        dispatcher.forward(req, res);
    }

    private void view_by_category(HttpServletRequest req, HttpServletResponse res) throws SQLException, ServletException, IOException {
        String cat = req.getParameter("cat");
        List<Products> productsList = this.adminFunctions.listByCategory(cat);
        List<String> cat_list = this.adminFunctions.viewCategories();
        req.setAttribute("productList", productsList);
        req.setAttribute("categories", cat_list);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/adminHomePage.jsp");
        dispatcher.forward(req, res);
    }
}