package com.mystrore.e_commerce2;

import com.mystrore.controller.dto.DBUtil;

import java.sql.*;

public class TestJDBC {

    public static void main(String[] args) {

        try (Connection myConn = DBUtil.getConnection()){
            Statement statement = myConn.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM products");

            while(resultSet.next()) {
                System.out.printf("%-5s %-12s %-15s %-12s %s\n", resultSet.getInt("product_id"),
                                                                resultSet.getString("name"),
                                                                resultSet.getString("category"),
                                                                resultSet.getInt("quantity"),
                                                                resultSet.getDouble("unit_price"));
            }
        } catch (SQLException e) {
            System.out.println("SQL exception thrown. "+e);
        }



    }
}
