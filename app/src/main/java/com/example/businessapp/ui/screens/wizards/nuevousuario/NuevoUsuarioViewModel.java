package com.example.businessapp.ui.screens.wizards.nuevousuario;

import android.os.Handler;

import androidx.hilt.lifecycle.ViewModelInject;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.businessapp.api.models.User;

public class NuevoUsuarioViewModel extends ViewModel {

    public MutableLiveData<User> user = new MutableLiveData<>(new User());

    public MutableLiveData<Boolean> working = new MutableLiveData<Boolean>(false);
    public MutableLiveData<Boolean> saved = new MutableLiveData<>(false);


    @ViewModelInject
    public NuevoUsuarioViewModel() {

    }


    public void saveUser() {

        working.postValue(true);

        // simula una llamada asyncrona al repositorio y a su vez al API
        Handler handler = new Handler();
        handler.postDelayed((Runnable) () -> {
            user.getValue().setId("ID_ID_ID_ID");
            working.postValue(false);
            saved.postValue(true);
        }, 10000);
    }

}