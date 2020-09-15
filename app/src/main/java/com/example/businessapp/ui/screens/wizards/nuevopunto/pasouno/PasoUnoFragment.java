package com.example.businessapp.ui.screens.wizards.nuevopunto.pasouno;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.businessapp.R;

public class PasoUnoFragment extends Fragment {

    private PasoUnoViewModel mViewModel;

    public static PasoUnoFragment newInstance() {
        return new PasoUnoFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.paso_uno_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(PasoUnoViewModel.class);
        // TODO: Use the ViewModel
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