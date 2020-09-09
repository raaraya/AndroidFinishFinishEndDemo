package com.example.businessapp.repositories;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.businessapp.api.models.PuntoVenta;
import com.example.businessapp.api.services.PuntosApiService;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PuntosVentaRepository {

    private PuntosApiService puntosApiService;
    private ArrayList<PuntoVenta> puntosVenta;

    @Inject
    public PuntosVentaRepository(PuntosApiService puntosApiService) {
        this.puntosApiService = puntosApiService;
    }

    public ArrayList<PuntoVenta> getPuntosVenta() {
        // llama el api aqui, pone el resultado en puntosVenta

        Call<ArrayList<PuntoVenta>> call = puntosApiService.getPuntosVenta();
        call.enqueue(new Callback<ArrayList<PuntoVenta>>() {
            @Override
            public void onResponse(Call<ArrayList<PuntoVenta>> call, Response<ArrayList<PuntoVenta>> response) {
                if (!response.isSuccessful()) return;

                puntosVenta = response.body();
            }

            @Override
            public void onFailure(Call<ArrayList<PuntoVenta>> call, Throwable t) {

            }
        });

        return puntosVenta;
    }

}
