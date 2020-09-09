package com.example.businessapp.ui.screens.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.businessapp.R;
import com.example.businessapp.ui.screens.common.BaseView;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class HomeFragment extends Fragment {

    private BaseView homeView;
    public HomeViewModel viewModel;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        homeView = new HomeView(inflater, container);

        return homeView.getRootView();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        viewModel.getPuntosVenta();

        view.findViewById(R.id.nuevo_punto_wizard_button).setOnClickListener(
                Navigation.createNavigateOnClickListener(R.id.action_homeFragment_to_nuevo_punto_wizard)
        );

        view.findViewById(R.id.nuevo_vendedor_wizard_button).setOnClickListener(
                Navigation.createNavigateOnClickListener(R.id.action_homeFragment_to_nuevo_vendedor_wizard)
        );
    }
}