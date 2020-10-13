package com.example.businessapp.ui.screens.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.databinding.DataBindingUtil;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.businessapp.R;
import com.example.businessapp.databinding.LoginFragmentBinding;
import com.example.businessapp.ui.UserViewModel;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class LoginFragment extends Fragment {

    public static String LOGIN_SUCCESSFUL = "LOGIN_SUCCESSFUL";

    private UserViewModel userViewModel;
    private SavedStateHandle savedStateHandle;

    private LoginFragmentBinding loginFragmentBinding;



    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        userViewModel = new ViewModelProvider(requireActivity()).get(UserViewModel.class);

        loginFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.login_fragment, container, false);
        loginFragmentBinding.setLifecycleOwner(getActivity());

        return loginFragmentBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        DeshabilitarBaryMenu();

        savedStateHandle = Navigation.findNavController(view)
                                     .getPreviousBackStackEntry()
                                     .getSavedStateHandle();
        savedStateHandle.set(LOGIN_SUCCESSFUL, false);


        loginFragmentBinding.loginUser.setOnClickListener(v -> {
            savedStateHandle.set(LOGIN_SUCCESSFUL, true);
            userViewModel.LogUserIn();
            HabilitarBaryMenu();
            Navigation.findNavController(view).popBackStack();
        });

    }

    void DeshabilitarBaryMenu() {
        DrawerLayout drawerLayout = requireActivity().findViewById(R.id.drawer_layout);
        drawerLayout.closeDrawer(GravityCompat.START);
        drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);

        ((AppCompatActivity)requireActivity()).getSupportActionBar().hide();
    }

    void HabilitarBaryMenu() {
        DrawerLayout drawerLayout = requireActivity().findViewById(R.id.drawer_layout);
        drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);

        ((AppCompatActivity)requireActivity()).getSupportActionBar().show();
    }

}