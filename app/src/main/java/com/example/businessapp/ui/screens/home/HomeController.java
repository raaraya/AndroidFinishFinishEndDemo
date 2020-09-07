package com.example.businessapp.ui.screens.home;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.businessapp.ui.screens.common.BaseView;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class HomeController extends Fragment {

    private BaseView homeView;

    public HomeController() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        homeView = new HomeView(inflater, container);

        return homeView.getRootView();
    }
}