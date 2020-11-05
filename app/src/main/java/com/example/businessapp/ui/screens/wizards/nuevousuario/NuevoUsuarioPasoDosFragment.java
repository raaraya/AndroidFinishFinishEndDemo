package com.example.businessapp.ui.screens.wizards.nuevousuario;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.businessapp.R;
import com.example.businessapp.databinding.FragmentNuevoUsuarioPasoDosBinding;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class NuevoUsuarioPasoDosFragment extends Fragment {

    private NuevoUsuarioViewModel viewModel;
    private FragmentNuevoUsuarioPasoDosBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        NavController controller = NavHostFragment.findNavController(this);
        ViewModelStoreOwner owner = controller.getViewModelStoreOwner(R.id.nav_nuevoUsuario);
        viewModel = new ViewModelProvider(owner).get(NuevoUsuarioViewModel.class);

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_nuevo_usuario_paso_dos, container, false);
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