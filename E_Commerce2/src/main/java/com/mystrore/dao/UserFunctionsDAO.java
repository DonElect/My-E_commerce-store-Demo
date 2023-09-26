package com.mystrore.dao;

import com.mystrore.controller.dto.DBUtil;
import com.mystrore.model.Products;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserFunctionsDAO {

    public List<Products> searchProduct(String item_name) throws SQLException {
        List<Products> searchList = new ArrayList<>();

        Connection myConn = DBUtil.getConnection();
        // Product name or part of the name
        CallableStatement search = myConn.prepareCall("{call item_search(?)}");

        search.setString(1, item_name);

        ResultSet searchResult = search.executeQuery();

        while (searchResult.next()){
            int id = searchResult.getInt("product_id");
            String name = searchResult.getString("name");
            String category = searchResult.getString("category");
            int quantity = searchResult.getInt("quantity");
            double unit_price = searchResult.getDouble("unit_price");

            searchList.add(new Products(id,name,category,quantity,unit_price));
        }

        myConn.close();
        search.close();
        return searchList;
    }

    public List<String> viewCategories() throws SQLException {
        Connection myConn = DBUtil.getConnection();

        List<String> categoryList = new ArrayList<>();

        CallableStatement search = myConn.prepareCall("{call view_categories()}");
        ResultSet searchResult = search.executeQuery();

        while (searchResult.next()){
            categoryList.add(searchResult.getString("name"));
        }

        myConn.close();
        search.close();
        return categoryList;
    }

    public List<Products> listByCategory(String category) throws SQLException {
        Connection myConn = DBUtil.getConnection();

        List<Products> productList = new ArrayList<>();

        CallableStatement search = myConn.prepareCall("{call list_by_category(?)}");

        search.setString(1, category);
        ResultSet searchResult = search.executeQuery();


        while (searchResult.next()){
            int id = searchResult.getInt("product_id");
            String name = searchResult.getString("name");
            int quantity = searchResult.getInt("quantity");
            double unit_price = searchResult.getDouble("unit_price");

            productList.add(new Products(id,name,quantity,unit_price));
        }

        myConn.close();
        search.close();
        return productList;
    }

    public List<Products> listProducts() throws SQLException {
        Connection myConn = DBUtil.getConnection();

        List<Products> list = new ArrayList<>();

        CallableStatement search = myConn.prepareCall("{call list_products()}");

        ResultSet resultSet = search.executeQuery();

        while (resultSet.next()){
            int id = resultSet.getInt("product_id");
            String name = resultSet.getString("name");
            String category = resultSet.getString("category");
            int quantity = resultSet.getInt("quantity");
            double unit_price = resultSet.getDouble("unit_price");
            list.add(new Products(id,name,category,quantity,unit_price));
        }

        myConn.close();
        search.close();
        return list;
    }
}
