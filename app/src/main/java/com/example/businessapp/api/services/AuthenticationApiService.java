package com.example.businessapp.api.services;

import com.example.businessapp.api.models.AuthenticateModel;
import com.example.businessapp.api.models.UsuarioJPS;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface AuthenticationApiService {

    @POST("/Users/authenticate")
    Call<UsuarioJPS> autenticar(@Body AuthenticateModel authenticateModel);
}
