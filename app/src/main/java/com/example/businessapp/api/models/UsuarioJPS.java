package com.example.businessapp.api.models;

import java.util.Date;

public class UsuarioJPS {

    String id;
    String username;
    String firstName;
    String lastName;
    String token;
    Date expire;
    String password;

    public UsuarioJPS() {}

    public UsuarioJPS(String id, String username, String firstName, String lastName, String token, Date expire) {
        this.id = id;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.token = token;
        this.expire = expire;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getToken() {
        return token;
    }
    public void setToken(String token) {
        this.token = token;
    }

    public Date getExpire() {
        return expire;
    }
    public void setExpire(Date expire) {
        this.expire = expire;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
