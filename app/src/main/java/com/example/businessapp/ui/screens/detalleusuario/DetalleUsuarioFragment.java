package com.example.businessapp.ui.screens.detalleusuario;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.icu.util.BuddhistCalendar;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.businessapp.R;
import com.example.businessapp.databinding.DetalleUsuarioFragmentBinding;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class DetalleUsuarioFragment extends Fragment {

    private DetalleUsuarioViewModel mViewModel;
    private DetalleUsuarioFragmentBinding detalleUsuarioFragmentBinding;



    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        mViewModel = new ViewModelProvider(this).get(DetalleUsuarioViewModel.class);

        detalleUsuarioFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.detalle_usuario_fragment, container, false);
        detalleUsuarioFragmentBinding.setViewmodel(mViewModel);
        detalleUsuarioFragmentBinding.setLifecycleOwner(getActivity());

        return detalleUsuarioFragmentBinding.getRoot();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Bundle bundle = getArguments();

        if(bundle != null) {
            String userId = bundle.getString("userId");

            mViewModel.getUsuario(userId);
        }
    }
}