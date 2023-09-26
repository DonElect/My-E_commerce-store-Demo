package com.mystrore.dao;

import com.mystrore.controller.dto.DBUtil;
import com.mystrore.model.Admin;
import com.mystrore.model.Customer;
import com.mystrore.model.Products;

import java.sql.*;

public class AdminDAO {
    private Admin admin;

    public AdminDAO(){

    }

    public int new_admin_registration(Admin admin) {
        int result = 0;
        try {
            Connection myConn = DBUtil.getConnection();
            CallableStatement register = myConn.prepareCall("{call new_admin(?,?,?,?)}");

            register.setString(1, admin.getName());
            register.setString(2, admin.getEmail());
            register.setString(3, admin.getPassword());
            register.setString(4, admin.getPhone());

            result = register.executeUpdate();

            myConn.close();
            register.close();

        } catch (SQLException e) {
            System.out.println("Error registering new admin! "+e);
        }

        return result;
    }

    public static boolean login(String email, String password) throws SQLException {
        Connection myConn = DBUtil.getConnection();
        CallableStatement verifyCustomer = myConn.prepareCall("{call my_store.admin_login_verification(?, ?, ?)}");

        verifyCustomer.setString(1, email);
        verifyCustomer.setString(2, password);
        verifyCustomer.registerOutParameter(3, Types.BOOLEAN);

        ResultSet resultSet = verifyCustomer.executeQuery();

        while(resultSet.next()) {
            Admin.setId(resultSet.getInt("admin_id"));
        }

        return verifyCustomer.getBoolean(3);
    }

    public int remove_product(int prod_id) throws SQLException {
        int result = 0;
        Connection myConn = DBUtil.getConnection();

        CallableStatement remove = myConn.prepareCall("{call delete_product(?)}");

        remove.setInt(1, prod_id);

        result = remove.executeUpdate();

        myConn.close();
        remove.close();

        return result;
    }

    public static int addProduct(Products product) throws SQLException {
        int result = 0;
        Connection myConn = DBUtil.getConnection();

        CallableStatement newProduct = myConn.prepareCall("{call add_products(?, ?, ?, ?)}");

        newProduct.setString(1, product.getName());
        newProduct.setString(2, product.getCategory());
        newProduct.setInt(3, product.getQuantity());
        newProduct.setDouble(4, product.getUnit_price());

        result = newProduct.executeUpdate();

        myConn.close();
        newProduct.close();

        return result;
    }
}
