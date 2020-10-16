package com.example.businessapp.ui;

import androidx.constraintlayout.solver.state.Dimension;
import androidx.hilt.lifecycle.ViewModelInject;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.businessapp.api.models.AuthenticateModel;
import com.example.businessapp.api.models.AuthenticateResponse;
import com.example.businessapp.api.models.User;
import com.example.businessapp.api.services.ResultCallBacks;
import com.example.businessapp.repositories.UsersRepository;

public class UserViewModel extends ViewModel {

    UsersRepository usersRepository;

    public MutableLiveData<Boolean> usuarioLogeado = new MutableLiveData<>(false);

    public MutableLiveData<Boolean> getUsuarioLogeado() {
        return usuarioLogeado;
    }
    public Boolean EstaLogueado() {
        return usuarioLogeado.getValue();
    }

    @ViewModelInject
    public UserViewModel(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }



    public void iniciarSesion(AuthenticateModel authenticateModel) {

        usersRepository.authenticar(authenticateModel, new ResultCallBacks<AuthenticateResponse>() {
            @Override
            public void onSuccess(AuthenticateResponse result) {
                usuarioLogeado.setValue(true);
            }

            @Override
            public void onFailure() {

            }
        });
    }

    public void cerrarSesion() {
        usuarioLogeado.setValue(false);
    }

}
