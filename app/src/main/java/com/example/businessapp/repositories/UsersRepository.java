package com.example.businessapp.repositories;

import android.app.Application;

import com.example.businessapp.R;
import com.example.businessapp.api.models.AuthenticateModel;
import com.example.businessapp.api.models.UsuarioJPS;
import com.example.businessapp.api.models.User;
import com.example.businessapp.api.services.AuthenticationApiService;
import com.example.businessapp.api.services.ResultCallBacks;
import com.example.businessapp.api.services.UsersApiService;

import java.util.ArrayList;

import javax.inject.Inject;
import javax.inject.Singleton;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@Singleton
public class UsersRepository {

    private UsersApiService usersApiService;
    private AuthenticationApiService authenticationApiService;


    @Inject
    public UsersRepository(UsersApiService service, AuthenticationApiService authenticationApiService) {
        this.usersApiService = service;
        this.authenticationApiService = authenticationApiService;
    }

    public void authenticar(AuthenticateModel authenticateModel, ResultCallBacks<UsuarioJPS> callBacks) {

        Call<UsuarioJPS> call = authenticationApiService.autenticar(authenticateModel);
        call.enqueue(new Callback<UsuarioJPS>() {
            @Override
            public void onResponse(Call<UsuarioJPS> call, Response<UsuarioJPS> response) {
                if (!response.isSuccessful()) {
                    callBacks.onFailure();
                }

                callBacks.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<UsuarioJPS> call, Throwable t) {
                callBacks.onFailure();
            }
        });

    }

    public void getUsuarios(final ResultCallBacks<ArrayList<User>> callBacks) {

        Call<ArrayList<User>> call = usersApiService.getUsuarios();
        call.enqueue(new Callback<ArrayList<User>>() {
            @Override
            public void onResponse(Call<ArrayList<User>> call, Response<ArrayList<User>> response) {
                if (!response.isSuccessful())
                    return;

                callBacks.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<ArrayList<User>> call, Throwable t) {
                callBacks.onFailure();
            }
        });
    }

    public void getUsuario(String id, ResultCallBacks<User> callBacks) {

        Call<User> call = usersApiService.getUsuario(id);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (!response.isSuccessful())
                    return;

                callBacks.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                callBacks.onFailure();
            }
        });
    }

}
