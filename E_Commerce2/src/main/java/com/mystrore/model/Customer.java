package com.mystrore.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    public static void setId(int id) {
        Customer.id = id;
    }

    @Getter
    private static int id;
    private String first_name;
    private String last_name;
    private String email;
    private String password;
    private Date birth_date;
    private String phone;
    private String address;
    private String city;
    private String state;
    private String country;
}
