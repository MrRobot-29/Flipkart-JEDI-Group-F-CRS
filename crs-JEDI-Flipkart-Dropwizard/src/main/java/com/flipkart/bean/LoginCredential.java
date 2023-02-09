package com.flipkart.bean;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Email;



public class LoginCredential {
    @NotBlank
    @Email
    private String userId;

    @NotBlank @Length(min=4)
    private String Password;
    @NotBlank
    private String Role;

    public LoginCredential(){

    }
    public LoginCredential(String userId, String password, String role) {
        this.userId = userId;
        Password = password;
        Role = role;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String role) {
        Role = role;
    }





}

