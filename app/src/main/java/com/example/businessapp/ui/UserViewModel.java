package com.example.businessapp.ui;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import androidx.hilt.lifecycle.ViewModelInject;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.businessapp.api.models.AuthenticateModel;
import com.example.businessapp.api.models.UsuarioJPS;
import com.example.businessapp.api.services.ResultCallBacks;
import com.example.businessapp.repositories.UsersRepository;

import dagger.hilt.android.qualifiers.ApplicationContext;

public class UserViewModel extends ViewModel {

    private final UsersRepository usersRepository;
    private final SharedPreferences sharedPreferences;

    public MutableLiveData<Boolean> usuarioLogeado = new MutableLiveData<>(false);
    public UsuarioJPS usuarioJPS;

    public MutableLiveData<Boolean> getUsuarioLogeado() {
        return usuarioLogeado;
    }
    public Boolean EstaLogueado() {
        return usuarioLogeado.getValue();
    }

    @ViewModelInject
    public UserViewModel(UsersRepository usersRepository, @ApplicationContext Context context) {
        this.usersRepository = usersRepository;

        sharedPreferences = context.getSharedPreferences(context.getApplicationInfo().name, Context.MODE_PRIVATE);

        usuarioJPS = new UsuarioJPS();

        cargarUsuarioSharedPreferences();
    }



    public void iniciarSesion() {

        AuthenticateModel authenticateModel = new AuthenticateModel(usuarioJPS.getUsername(), usuarioJPS.getPassword());

        usersRepository.authenticar(authenticateModel, new ResultCallBacks<UsuarioJPS>() {
            @Override
            public void onSuccess(UsuarioJPS result) {
                usuarioLogeado.setValue(true);
                usuarioJPS = result;

                guardarUsuarioSharedPreferences();
            }

            @Override
            public void onFailure() {
                usuarioLogeado.setValue(false);
                Log.e("REST", "API JPS Error");
            }
        });
    }

    public void cerrarSesion() {
        usuarioLogeado.setValue(false);
        removerUsuarioSharedPrerefences();
    }


    public void cargarUsuarioSharedPreferences() {

        usuarioJPS.setUsername(sharedPreferences.getString("userName", null));
        usuarioJPS.setPassword(sharedPreferences.getString("password", null));
        usuarioJPS.setToken(sharedPreferences.getString("token", null));

        usuarioLogeado.postValue(sharedPreferences.getBoolean("logueado", false));
    }

    public void guardarUsuarioSharedPreferences() {

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("userName", usuarioJPS.getUsername());
        editor.putString("password", "123456.JPS"); // TODO: Cambiar
        editor.putString("token", usuarioJPS.getToken());

        editor.putBoolean("logueado", usuarioLogeado.getValue());

        editor.apply();
    }

    public void removerUsuarioSharedPrerefences() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();

        //resetea el usuario a uno en limpio, como en el principio
        usuarioJPS = new UsuarioJPS();
    }

}
