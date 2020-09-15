package com.example.businessapp.ui.screens.wizards.nuevopunto.pasodos;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.businessapp.R;

public class PasoDosFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.paso_dos_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.paso_siguiente)
                .setOnClickListener(
                        Navigation.createNavigateOnClickListener(R.id.action_nuevo_next)
                );

        view.findViewById(R.id.paso_atras)
                .setOnClickListener((v) ->
                        Navigation.findNavController(v).popBackStack()
                );
    }
}