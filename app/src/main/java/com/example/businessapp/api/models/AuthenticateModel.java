package com.example.businessapp.api.models;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.example.businessapp.BR;

public class AuthenticateModel extends BaseObservable {
    String userName;
    String password;

    public AuthenticateModel(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    @Bindable
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
        notifyPropertyChanged(BR.userName);
    }

    @Bindable
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
        notifyPropertyChanged(BR.password);
    }
}
