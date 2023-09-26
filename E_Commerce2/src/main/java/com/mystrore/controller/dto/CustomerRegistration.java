package com.mystrore.controller.dto;

import com.mystrore.dao.CustomerDao;
import com.mystrore.model.Customer;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

@WebServlet(name = "CustomerRegistration", value = "/register")
public class CustomerRegistration extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/customerRegistration.jsp");
        dispatcher.forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String first_name = req.getParameter("firstName");
        String last_name = req.getParameter("lastName");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String[] date = req.getParameter("birthDate").split("-");
        Date birth_date = Date.valueOf(String.format("%s-%s-%s",date[0],date[1],date[2]));
        String phone = req.getParameter("phone");
        String address = req.getParameter("address");
        String city = req.getParameter("city");
        String state = req.getParameter("state");
        String country = req.getParameter("country");

        Customer customer = new Customer();
        customer.setFirst_name(first_name);
        customer.setLast_name(last_name);
        customer.setEmail(email);
        customer.setPassword(password);
        customer.setBirth_date(birth_date);
        customer.setPhone(phone);
        customer.setAddress(address);
        customer.setCity(city);
        customer.setState(state);
        customer.setCountry(country);

        CustomerDao customerDao = new CustomerDao(customer);
        customerDao.registerNewCustomer();
        PrintWriter out = res.getWriter();
        out.println("Success!");

        res.sendRedirect("login");
    }
}