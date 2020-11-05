package com.example.businessapp.ui.screens.usuariosselect;

import androidx.hilt.lifecycle.ViewModelInject;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.businessapp.api.models.User;
import com.example.businessapp.api.models.UsuarioJPS;
import com.example.businessapp.api.services.ResultCallBacks;
import com.example.businessapp.repositories.UsersRepository;

import java.util.ArrayList;

public class UsuariosSelectViewModel extends ViewModel {
    private UsersRepository usersRepository;

    public MutableLiveData<ArrayList<User>> usuarios = new MutableLiveData<>(new ArrayList<>());
    public MutableLiveData<User> usuarioSeleccionado = new MutableLiveData<>(new User());

    @ViewModelInject
    public UsuariosSelectViewModel(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;

        getUsuarios();
    }

    public void getUsuarios() {
        usersRepository.getUsuarios(new ResultCallBacks<ArrayList<User>>() {
            @Override
            public void onSuccess(ArrayList<User> result) {
                usuarios.postValue(result);
            }

            @Override
            public void onFailure() {

            }
        });
    }
}