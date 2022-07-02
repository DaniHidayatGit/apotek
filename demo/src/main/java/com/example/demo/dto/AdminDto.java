package com.example.demo.dto;

public class AdminDto {
    private String id_adm;
    private String name, email, password;

    public String getId_adm() {
        return id_adm;
    }

    public void setId_adm(String id_adm) {
        this.id_adm = id_adm;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
