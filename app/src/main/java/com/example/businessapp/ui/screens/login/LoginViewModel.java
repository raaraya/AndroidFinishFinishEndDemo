package com.example.businessapp.ui.screens.login;

import androidx.hilt.lifecycle.ViewModelInject;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class LoginViewModel extends ViewModel {

    public MutableLiveData<Boolean> esperandoRespuesta = new MutableLiveData<>(false);

    @ViewModelInject
    public LoginViewModel() {
    }
}
