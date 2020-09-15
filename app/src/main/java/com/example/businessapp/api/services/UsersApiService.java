package com.example.businessapp.api.services;

import com.example.businessapp.api.models.User;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface UsersApiService {

    @GET("V1/clients")
    Call<ArrayList<User>> getUsuarios();

    @GET("V1/clients/{id}")
    Call<User> getUsuario(@Path("id") String id);

}
