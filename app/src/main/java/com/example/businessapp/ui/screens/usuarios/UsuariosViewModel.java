package com.example.businessapp.ui.screens.usuarios;

import androidx.hilt.lifecycle.ViewModelInject;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.businessapp.api.models.User;
import com.example.businessapp.api.services.ResultCallBacks;
import com.example.businessapp.repositories.UsersRepository;

import java.util.ArrayList;

public class UsuariosViewModel extends ViewModel {

    private UsersRepository usersRepository;

    public MutableLiveData<ArrayList<User>> users = new MutableLiveData<>(new ArrayList<>());
    public User usuario;

    @ViewModelInject
    public UsuariosViewModel(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }


    public void getUsuarios() {
        usersRepository.getUsuarios(new ResultCallBacks<ArrayList<User>>() {
            @Override
            public void onSuccess(ArrayList<User> result) {
                users.postValue(result);
            }

            @Override
            public void onFailure() {

            }
        });
    }


}