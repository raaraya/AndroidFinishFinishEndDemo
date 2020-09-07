package com.example.businessapp.ui.screens.home;

import androidx.hilt.lifecycle.ViewModelInject;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;


import com.example.businessapp.api.models.PuntoVenta;
import com.example.businessapp.repositories.PuntosVentaRepository;

import java.util.List;

import javax.inject.Inject;


public class HomeViewModel extends ViewModel {

    private PuntosVentaRepository puntosVentaRepository;
    private LiveData<List<PuntoVenta>> puntosVenta;

//    public HomeViewModel() { }

    @ViewModelInject
    public HomeViewModel(PuntosVentaRepository repository) {
        this.puntosVentaRepository = repository;
    }

    public void getPuntosVenta() {
        puntosVenta = puntosVentaRepository.getPuntosVenta();
    }

}
