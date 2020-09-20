package com.example.businessapp.api.models;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.example.businessapp.BR;

public class User extends BaseObservable {
    String id;
    String name;
    String email;
    String telephone;
    int age;


    @Bindable
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
        notifyPropertyChanged(BR.id);
    }

    @Bindable
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    @Bindable
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
        notifyPropertyChanged(BR.email);
    }

    @Bindable
    public String getTelephone() {
        return telephone;
    }
    public void setTelephone(String telephone) {
        this.telephone = telephone;
        notifyPropertyChanged(BR.telephone);
    }

    @Bindable
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
        notifyPropertyChanged(BR.age);
    }
}
