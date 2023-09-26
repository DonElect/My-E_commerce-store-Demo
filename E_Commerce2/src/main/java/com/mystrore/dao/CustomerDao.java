package com.mystrore.dao;

import com.mystrore.controller.dto.DBUtil;
import com.mystrore.model.Customer;
import com.mystrore.model.Products;
import lombok.NoArgsConstructor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
public class CustomerDao {
    private static Customer customer = new Customer();
    public CustomerDao(Customer customer){
        this.customer = customer;
    }
    public int registerNewCustomer(){
        int result = 0;
        try{
            Connection myConn = DBUtil.getConnection();
            CallableStatement newCustomerReg = myConn.prepareCall("{call reqister_new_customer(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}");

            newCustomerReg.setString(1, customer.getFirst_name());
            newCustomerReg.setString(2, customer.getLast_name());
            newCustomerReg.setString(3, customer.getEmail());
            newCustomerReg.setString(4, customer.getPassword());
            newCustomerReg.setDate(5, customer.getBirth_date());
            newCustomerReg.setString(6, customer.getPhone());
            newCustomerReg.setString(7, customer.getAddress());
            newCustomerReg.setString(8, customer.getCity());
            newCustomerReg.setString(9, customer.getState());
            newCustomerReg.setString(10, customer.getCountry());


            result = newCustomerReg.executeUpdate();
            myConn.close();
            newCustomerReg.close();
        } catch (SQLException e) {
            System.out.println("Error storing new customer details "+e);
        }

        return result;
    }

    public static boolean login(String email, String password) throws SQLException {
        Connection myConn = DBUtil.getConnection();
        CallableStatement verifyCustomer = myConn.prepareCall("{call my_store.customer_login_verification(?, ?, ?)}");

        verifyCustomer.setString(1, email);
        verifyCustomer.setString(2, password);
        verifyCustomer.registerOutParameter(3, Types.BOOLEAN);

        ResultSet resultSet = verifyCustomer.executeQuery();

        while(resultSet.next()) {
            Customer.setId(resultSet.getInt("id"));
        }

        return verifyCustomer.getBoolean(3);
    }

    public void addToCart(int prod_id, int cust_id) throws SQLException {
        Connection myConn = DBUtil.getConnection();
        // product_id,customer_id,quantity,unit_price
        CallableStatement cart_add = myConn.prepareCall("{call add_to_cart(?,?)}");
        cart_add.setInt(1, prod_id);
        cart_add.setInt(2, cust_id);

        cart_add.executeUpdate();

        myConn.close();
        cart_add.close();
    }

    public void removeFromCart(int prod_id, int cust_id) throws SQLException {
        Connection myConn = DBUtil.getConnection();
        // product_id,customer_id
        CallableStatement cart_remove = myConn.prepareCall("{call remove_from_cart(?,?)}");

        cart_remove.setInt(1, prod_id);
        cart_remove.setInt(2, cust_id);

        cart_remove.executeUpdate();

        myConn.close();
        cart_remove.close();
    }

    public void updateCart(Products product, int quantity) throws SQLException {
        Connection myConn = DBUtil.getConnection();
        // product_id,customer_id, quantity
        CallableStatement cart_update = myConn.prepareCall("{call update_cart(?,?,?)}");

        cart_update.setInt(1, product.getId());
        cart_update.setInt(2, customer.getId());
        cart_update.setInt(3, quantity);

        cart_update.executeUpdate();

        myConn.close();
        cart_update.close();
    }


    public List<Products> viewCart(int id) throws SQLException {
        Connection myConn = DBUtil.getConnection();

        List<Products> myCart = new ArrayList<>();

        CallableStatement search = myConn.prepareCall("{call view_cart(?)}");

        search.setInt(1, id);

        ResultSet cartResult = search.executeQuery();

        while (cartResult.next()){
            int product_id = cartResult.getInt("product_id");
            String name = cartResult.getString("name");
            int quantity = cartResult.getInt("quantity");
            double unit_price = cartResult.getDouble("unit_price");

            myCart.add(new Products(product_id,name,quantity,unit_price));
        }

        myConn.close();
        search.close();
        return myCart;
    }

}
