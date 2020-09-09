package com.example.businessapp.ui.screens.wizards.nuevovendedor.pasocuatro;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.businessapp.R;

public class PasoCuatroFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_paso_cuatro, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.paso_finalizar)
                .setOnClickListener(
                        Navigation.createNavigateOnClickListener(R.id.action_finalizar)
                );

        view.findViewById(R.id.paso_atras)
                .setOnClickListener((v) ->
                        Navigation.findNavController(v).popBackStack()
                );
    }
}