package com.example.businessapp.ui.screens.detalleusuario;

import androidx.hilt.lifecycle.ViewModelInject;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.businessapp.api.models.User;
import com.example.businessapp.api.services.ResultCallBacks;
import com.example.businessapp.repositories.UsersRepository;

public class DetalleUsuarioViewModel extends ViewModel {

    UsersRepository repositorio;

    public MutableLiveData<User> usuario = new MutableLiveData<>();

    @ViewModelInject
    public DetalleUsuarioViewModel(UsersRepository repositorio) {
        this.repositorio = repositorio;
    }

    public void getUsuario(String userId) {
        repositorio.getUsuario(userId, new ResultCallBacks<User>() {
            @Override
            public void onSuccess(User result) {
                usuario.postValue(result);
            }

            @Override
            public void onFailure() {

            }
        });
    }
}