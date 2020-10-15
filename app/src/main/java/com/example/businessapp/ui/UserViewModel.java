package com.example.businessapp.ui;

import androidx.constraintlayout.solver.state.Dimension;
import androidx.hilt.lifecycle.ViewModelInject;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class UserViewModel extends ViewModel {

    public MutableLiveData<Boolean> usuarioLogeado = new MutableLiveData<>(false);

    public MutableLiveData<Boolean> getUsuarioLogeado() {
        return usuarioLogeado;
    }
    public Boolean EstaLogueado() {
        return usuarioLogeado.getValue();
    }

    @ViewModelInject
    public UserViewModel() { }



    public void iniciarSesion() {
        usuarioLogeado.setValue(true);
    }

    public void cerrarSesion() {
        usuarioLogeado.setValue(false);
    }

}
