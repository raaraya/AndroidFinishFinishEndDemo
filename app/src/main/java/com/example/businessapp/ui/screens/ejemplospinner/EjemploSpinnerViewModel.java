package com.example.businessapp.ui.screens.ejemplospinner;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

public class EjemploSpinnerViewModel extends ViewModel {

    public MutableLiveData<ArrayList<EstadoCivil>> estadosCiviles = new MutableLiveData<>();
    public MutableLiveData<EstadoCivil> estadoCivil = new MutableLiveData<>();

    public EjemploSpinnerViewModel() {
        this.estadosCiviles.setValue(new ArrayList<EstadoCivil>() {
            {
                add(new EstadoCivil("S", "Soltero"));
                add(new EstadoCivil("C", "Casado"));
                add(new EstadoCivil("D", "Divorciado"));
                add(new EstadoCivil("U", "Unión Libre"));
            }
        });

        estadoCivil.setValue(estadosCiviles.getValue().get(0)); // default al primero
    }
}