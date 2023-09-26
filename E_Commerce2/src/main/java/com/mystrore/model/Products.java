package com.mystrore.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Products {
    private int id;
    private String name;
    private String category;
    private int quantity;
    private double unit_price;

    public Products(int id, String name, int quantity, double unitPrice) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.unit_price = unitPrice;
    }

    public Products(String name, int quantity, double unitPrice) {
        this.name = name;
        this.quantity = quantity;
        this.unit_price = unitPrice;
    }

    public Products(String name, String category, int quantity, double unitPrice) {
        this.name = name;
        this.category = category;
        this.quantity = quantity;
        this.unit_price = unitPrice;
    }
}
