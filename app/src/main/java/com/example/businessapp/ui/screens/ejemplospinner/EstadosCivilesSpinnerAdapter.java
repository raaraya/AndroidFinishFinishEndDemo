package com.example.businessapp.ui.screens.ejemplospinner;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.businessapp.R;

import java.util.ArrayList;

public class EstadosCivilesSpinnerAdapter extends ArrayAdapter<EstadoCivil> {

    private ArrayList<EstadoCivil> estadosCiviles;

    private Context context;
    private int resource;

    public EstadosCivilesSpinnerAdapter(@NonNull Context context, int resource, @NonNull ArrayList<EstadoCivil> estadosCiviles) {
        super(context, resource, estadosCiviles);

        this.context = context;
        this.resource = resource;
        this.estadosCiviles = estadosCiviles;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        EstadoCivil estadoCivil = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(resource, parent, false);
        }

        TextView tvEstadoCivil = (TextView) convertView.findViewById(R.id.tvEstadoCivil);
        tvEstadoCivil.setText(estadoCivil.getNombre());

        return convertView;
    }

}


