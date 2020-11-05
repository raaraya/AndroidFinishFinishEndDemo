package com.example.businessapp.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.businessapp.R;
import com.example.businessapp.ui.screens.login.LoginFragment;
import com.google.android.material.navigation.NavigationView;

import dagger.hilt.android.AndroidEntryPoint;


@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private UserViewModel userViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // sets the toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        //sets the drawer
        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        mAppBarConfiguration = new AppBarConfiguration.Builder(R.id.homeFragment)
            .setOpenableLayout(drawerLayout)
            .build();

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);

        NavigationView navigationView = findViewById(R.id.nav_view);
        NavigationUI.setupWithNavController(navigationView, navController);

        // sets the user view model to handle user operations
        userViewModel = new ViewModelProvider(this).get(UserViewModel.class);

        // pone el click en el menu que desloguea el usuario
        navigationView.setNavigationItemSelectedListener(menuItem -> {
            if (menuItem.getItemId() == R.id.loginFragment) {
                userViewModel.cerrarSesion();
                return true;
            }
            return false;
        });

        // observa el estado de la sesion del usuario,
        // si el usuario no esta logueado o se desloguea, se navega al login
        userViewModel.usuarioLogeado.observe(this, logueado -> {
            if (!logueado) {
                navController.navigate(R.id.loginFragment);
            }
        });

    }


    @Override
    public boolean onSupportNavigateUp() {

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);

        return NavigationUI.navigateUp(navController, mAppBarConfiguration) || super.onSupportNavigateUp();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        // encuentra un NavController que corresponde a la navegacion
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);

        // con el NavController, obtenemos el entry de la historia actual, correspondiente al home Fragment
        NavBackStackEntry navBackStackEntry = navController.getCurrentBackStackEntry();

        // del NavBackStackEntry obtenemos el saved state handle, que es un hashmap que sirve para pasar parametros al navegar
        SavedStateHandle savedStateHandle = navBackStackEntry.getSavedStateHandle();

        //checkea si el saved state tiene un una variable LOGIN_SUCCESSFUL
        Boolean loginSuccessful = savedStateHandle.get(LoginFragment.LOGIN_SUCCESSFUL);
        if (loginSuccessful != null && !loginSuccessful) {
            this.finish();
        }
    }
}