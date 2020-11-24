package com.example.businessapp.ui.screens.ejemplospinner;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.example.businessapp.R;
import com.example.businessapp.databinding.EjemploSpinnerFragmentBinding;

public class EjemploSpinnerFragment extends Fragment {

    private EjemploSpinnerViewModel ejemploSpinnerViewModel;
    private EjemploSpinnerFragmentBinding ejemploSpinnerFragmentBinding;
    private EstadosCivilesSpinnerAdapter adapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        ejemploSpinnerViewModel = new ViewModelProvider(this).get(EjemploSpinnerViewModel.class);

        ejemploSpinnerFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.ejemplo_spinner_fragment, container, false);
        ejemploSpinnerFragmentBinding.setViewModel(ejemploSpinnerViewModel);
        ejemploSpinnerFragmentBinding.setLifecycleOwner(requireActivity());

        return ejemploSpinnerFragmentBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        adapter = new EstadosCivilesSpinnerAdapter(getContext(), R.layout.estado_civil_spinner_layout, ejemploSpinnerViewModel.estadosCiviles.getValue());
        ejemploSpinnerFragmentBinding.spinnerEstadosCiviles.setAdapter(adapter);

        // al dar click en un elemento se cambia el estado civil en el view model
        ejemploSpinnerFragmentBinding.spinnerEstadosCiviles.setOnItemClickListener((adapterView, view1, i, l) -> {
            ejemploSpinnerViewModel.estadoCivil.setValue(
                    ejemploSpinnerViewModel.estadosCiviles.getValue().get(i)
            );
        });

        // cuando se cambia el estado civil, se actualiza el texto del spinner, esto automaticamente cambia por si acaso el estado civil es cambiado en otro lugar, como cuando se carga
        ejemploSpinnerViewModel.estadoCivil.observe(getViewLifecycleOwner(), estadoCivil -> {
            ejemploSpinnerFragmentBinding.spinnerEstadosCiviles.setText(estadoCivil.getNombre(), false);
        });
    }
}