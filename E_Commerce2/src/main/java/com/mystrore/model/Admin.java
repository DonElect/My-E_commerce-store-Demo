package com.mystrore.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Admin {

    public static void setId(int id) {
        Admin.id = id;
    }

    @Getter
    private static int id;
    private String name;
    private String email;
    private String password;
    private String phone;
}
