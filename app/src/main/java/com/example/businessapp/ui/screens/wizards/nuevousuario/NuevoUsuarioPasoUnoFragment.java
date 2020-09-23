package com.example.businessapp.ui.screens.wizards.nuevousuario;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.businessapp.R;
import com.example.businessapp.databinding.FragmentNuevoUsuarioPasoUnoBinding;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class NuevoUsuarioPasoUnoFragment extends Fragment {

    NuevoUsuarioViewModel viewModel;
    FragmentNuevoUsuarioPasoUnoBinding binding;

     @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

         NavController navController = NavHostFragment.findNavController(this);
         viewModel = new ViewModelProvider(navController.getViewModelStoreOwner(R.id.nav_nuevoUsuario)).get(NuevoUsuarioViewModel.class);

         binding = DataBindingUtil.inflate(inflater, R.layout.fragment_nuevo_usuario_paso_uno, container, false);
         binding.setLifecycleOwner(getActivity());
         binding.setViewModel(viewModel);

         return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.nuevoUsuarioNext.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_nuevoUsuarioNext));
    }
}