package com.example.businessapp.ui.screens.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.businessapp.R;
import com.example.businessapp.databinding.FragmentHomeBinding;


import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class HomeFragment extends Fragment {

    public HomeViewModel viewModel;

    private FragmentHomeBinding binding;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false);

        return binding.getRoot();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewModel = new ViewModelProvider(this).get(HomeViewModel.class);

        binding.usuariosButton.setOnClickListener(
                Navigation.createNavigateOnClickListener(R.id.action_homeFragment_to_usuariosFragment)
        );

        binding.usuariosNuevo.setOnClickListener(
                Navigation.createNavigateOnClickListener(R.id.action_nuevoUsuario)
        );

        binding.nuevoPuntoWizardButton.setOnClickListener(
                Navigation.createNavigateOnClickListener(R.id.action_homeFragment_to_nuevo_punto_wizard)
        );

        binding.nuevoVendedorWizardButton.setOnClickListener(
                Navigation.createNavigateOnClickListener(R.id.action_homeFragment_to_nuevo_vendedor_wizard)
        );
    }
}