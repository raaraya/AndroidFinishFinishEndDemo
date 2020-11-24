package com.example.businessapp.ui.screens.ejemplospinner;

public class EstadoCivil {
    private String id;
    private String nombre;

    public EstadoCivil(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
