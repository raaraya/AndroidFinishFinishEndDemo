package com.example.businessapp.ui.screens.login;

import androidx.appcompat.app.ActionBar;
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
import androidx.navigation.NavOptions;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.businessapp.R;
import com.example.businessapp.api.models.AuthenticateModel;
import com.example.businessapp.databinding.LoginFragmentBinding;
import com.example.businessapp.ui.UserViewModel;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class LoginFragment extends Fragment {

    public static String LOGIN_SUCCESSFUL = "LOGIN_SUCCESSFUL";

    private UserViewModel userViewModel;
    private LoginViewModel loginViewModel;

    private SavedStateHandle savedStateHandle;
    private LoginFragmentBinding loginFragmentBinding;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        userViewModel = new ViewModelProvider(requireActivity()).get(UserViewModel.class);
        userViewModel.usuarioLogeado.observe(requireActivity(), logueado -> {
            if(logueado) {
                // si el login es exitoso, cambia el dato a true para indicar que el usuario pudo loguearse
                savedStateHandle.set(LOGIN_SUCCESSFUL, true);
                HabilitarAppBaryMenu();
                // usa pop back stack para borrar toda la historia hasta llegar al home
                NavHostFragment.findNavController(this).popBackStack(R.id.homeFragment, false);
            }
        });

        loginViewModel = new ViewModelProvider(this).get(LoginViewModel.class);

        loginFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.login_fragment, container, false);
        loginFragmentBinding.setLifecycleOwner(getActivity());
        loginFragmentBinding.setLoginViewModel(loginViewModel);

        return loginFragmentBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        DeshabilitarAppBaryMenu();

        // crea y almacena el resultado en el saveState del navigation entry anterior
        savedStateHandle = Navigation.findNavController(view)
                                     .getPreviousBackStackEntry()   // obtiene el back stack entry anterior
                                     .getSavedStateHandle();        // obtiene el saved state handle para guardar el dato
        // almacena el dato, este es un hashmap
        savedStateHandle.set(LOGIN_SUCCESSFUL, false);

        loginFragmentBinding.loginUser.setOnClickListener(v -> {
            loginViewModel.esperandoRespuesta.postValue(true);
            AuthenticateModel authenticateModel = new AuthenticateModel("user_puntosventa", "123456.JPS");
            userViewModel.iniciarSesion(authenticateModel);
        });
    }

    void DeshabilitarAppBaryMenu() {
        DrawerLayout drawerLayout = requireActivity().findViewById(R.id.drawer_layout);
        drawerLayout.closeDrawer(GravityCompat.START);
        drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);

        ActionBar actionBar = ((AppCompatActivity)requireActivity()).getSupportActionBar();
        actionBar.hide();
    }

    void HabilitarAppBaryMenu() {
        DrawerLayout drawerLayout = requireActivity().findViewById(R.id.drawer_layout);
        drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);

        ActionBar actionBar = ((AppCompatActivity)requireActivity()).getSupportActionBar();
        actionBar.show();
    }

}