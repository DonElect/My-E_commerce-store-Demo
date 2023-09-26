package com.mystrore.controller.dto;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import static com.mystrore.dao.CustomerDao.login;

@WebServlet(name = "CustomerLogin", value = "/login")
public class CustomerLogin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/customerLogin.jsp");
        dispatcher.forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        try {
            if (login(email, password)){
                RequestDispatcher dispatcher = req.getRequestDispatcher("home");
                req.setAttribute("list", "list");
                dispatcher.forward(req, res);
//                res.sendRedirect("home");
            }
        } catch (SQLException ex) {
            System.out.println("Error Verifying customer. "+ex);
            PrintWriter out = res.getWriter();
            out.println("Invalid Email or Password. Go back and try again!");
            res.sendRedirect("login");
        }

    }
}