package com.example.businessapp.ui.screens.usuariosselect;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.example.businessapp.R;
import com.example.businessapp.api.models.User;
import com.example.businessapp.databinding.UsuariosSelectFragmentBinding;

import java.math.BigInteger;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class UsuariosSelectFragment extends Fragment {

    private UsuariosSelectViewModel mViewModel;
    private UsuariosSelectFragmentBinding binding;

    private UsuariosAdapter adapter;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        mViewModel = new ViewModelProvider(this).get(UsuariosSelectViewModel.class);

        binding = DataBindingUtil.inflate(inflater, R.layout.usuarios_select_fragment, container, false);
        binding.setViewmodel(mViewModel);
        binding.setLifecycleOwner(getViewLifecycleOwner());

        return binding.getRoot();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mViewModel.usuarios.observe(getViewLifecycleOwner(),
                users -> {
                    adapter.users = users;
                    adapter.notifyDataSetChanged();
                }
        );

        adapter = new UsuariosAdapter(requireContext(), android.R.layout.simple_spinner_item, mViewModel.usuarios.getValue());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);

        binding.usuarioSelect.setAdapter(adapter);
        binding.usuarioSelect.setOnItemClickListener((adapterView, view1, i, l) -> {
            mViewModel.usuarioSeleccionado.setValue(adapter.getItem(i));
        });

//        binding.usuarioSelect.setOnFocusChangeListener((v, b) -> {
//            if (!b) {
//                binding.usuarioSelect.setError("Mamon");
//            }
//        });




    }

}