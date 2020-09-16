package com.example.businessapp.api.models;

import androidx.annotation.NonNull;

public class User {
    String id;
    String name;
    String email;
    String telephone;
    String age;

    public User(String id, String name, String email, String telephone, String age) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.telephone = telephone;
        this.age = age;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
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

    public String getTelephone() {
        return telephone;
    }
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAge() {
        return age;
    }
    public void setAge(String age) {
        this.age = age;
    }
}
