package com.example.businessapp.ui.screens.usuarios;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.businessapp.R;
import com.example.businessapp.databinding.UsuariosFragmentBinding;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class UsuariosFragment extends Fragment {

    private UsuariosViewModel usuariosViewModel;
    private UsuariosFragmentBinding binding;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        usuariosViewModel = new ViewModelProvider(this).get(UsuariosViewModel.class);

        binding = DataBindingUtil.inflate(inflater, R.layout.usuarios_fragment, container, false);
        binding.setViewmodel(usuariosViewModel);


        setupUsersRecyclerView();

        return binding.getRoot();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        usuariosViewModel.getUsuarios();
    }


    void setupUsersRecyclerView() {
        recyclerView = binding.usersRecyclerView;

        adapter = new UsersRecyclerViewAdapter(usuariosViewModel.users);
        recyclerView.setAdapter(adapter);

        usuariosViewModel.users.observe(getActivity(), users -> adapter.notifyDataSetChanged());
    }
}