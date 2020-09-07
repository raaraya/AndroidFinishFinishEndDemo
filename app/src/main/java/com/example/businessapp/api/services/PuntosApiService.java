package com.example.businessapp.api.services;

import com.example.businessapp.api.models.PuntoVenta;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PuntosApiService {

    @GET("puntosventa")
    Call<List<PuntoVenta>> getPuntosVenta();

}
