package com.mystrore.controller.dto;

import com.mystrore.dao.AdminDAO;
import com.mystrore.model.Admin;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AdminRegistration", value = "/admin_register")
public class AdminRegistration extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/adminRegistration.jsp");
        dispatcher.forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String phone = req.getParameter("phone");


        Admin admin = new Admin();

        admin.setName(name);
        admin.setEmail(email);
        admin.setPassword(password);
        admin.setPhone(phone);

        AdminDAO adminDAO = new AdminDAO();
        adminDAO.new_admin_registration(admin);
        PrintWriter out = res.getWriter();
        out.println("Success!");

        res.sendRedirect("admin_login");
    }
}