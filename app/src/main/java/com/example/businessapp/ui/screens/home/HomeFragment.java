package com.example.businessapp.ui.screens.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavController;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import com.example.businessapp.R;
import com.example.businessapp.databinding.FragmentHomeBinding;
import com.example.businessapp.ui.UserViewModel;
import com.example.businessapp.ui.screens.login.LoginFragment;

import dagger.hilt.android.AndroidEntryPoint;


@AndroidEntryPoint
public class HomeFragment extends Fragment {

    public UserViewModel userViewModel;
    private FragmentHomeBinding binding;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false);

        return binding.getRoot();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // sets the user view model to handle user operations
        userViewModel = new ViewModelProvider(requireActivity()).get(UserViewModel.class);

        binding.setUserViewModel(userViewModel);

        // pone el evento al boton de desloguear
        binding.btnLogout.setOnClickListener(v -> userViewModel.cerrarSesion());

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