package com.mystrore.controller.dto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    private static final String URL = "jdbc:mysql://localhost:3306/my_store";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Onyeka$1996";
    private static Connection connection;


    public static Connection getConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Error connecting to Database. "+e);
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found exception. "+e);
        }
        return connection;
    }
}
