package com.example.businessapp.ui.screens.common;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.businessapp.R;

public abstract class BaseView {

    private View rootView;

    public BaseView(LayoutInflater inflater, ViewGroup container) {
        rootView = inflater.inflate(R.layout.fragment_home, container, false);
    }

    public View getRootView() {
        return rootView;
    }

    public <T extends View> T findViewById(int id){
        return getRootView().findViewById(id);
    }

    public Context getContext() {
        return getRootView().getContext();
    }
}
