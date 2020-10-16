package com.example.businessapp.api.services.retrofit;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.businessapp.R;
import com.example.businessapp.api.models.AuthenticateModel;
import com.example.businessapp.api.models.UsuarioJPS;
import com.example.businessapp.api.services.AuthenticationApiService;
import com.example.businessapp.api.services.retrofit.RetrofitService;

import java.io.IOException;

import javax.annotation.Nullable;

import okhttp3.Authenticator;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;
import retrofit2.Call;

public class TokenAuthenticator implements Authenticator {

    private Context context;
    private SharedPreferences sharedPreferences;
    private String baseUrl;

    public TokenAuthenticator(Context context) {
        this.context = context;
        this.sharedPreferences = this.context.getSharedPreferences(context.getApplicationInfo().name, Context.MODE_PRIVATE);
        baseUrl = this.context.getString(R.string.base_url);
    }

    @Nullable
    @Override
    public Request authenticate(@Nullable Route route, Response response) throws IOException {

        // se brinca el autenticar
        Request originalRequest = response.request();
        if (originalRequest.method() == "POST" && originalRequest.url().encodedPath().contains("/Users/authenticate")) {
            return originalRequest;
        }

        String userName = sharedPreferences.getString("userName", "user_puntosventa");  // TODO: Cambiar
        String password = sharedPreferences.getString("password", "123456.JPS");        // TODO: Cambiar

        String nuevoToken = obtenerNuevoToken(userName, password);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("token", nuevoToken);
        editor.apply();

        return response.request()
                .newBuilder()
                .header("Authorization", String.format("Bearer %s", nuevoToken))
                .build();
    }

    private String obtenerNuevoToken(String userName, String password) throws IOException {
        AuthenticationApiService authenticationApiService = RetrofitService.createAPIService(AuthenticationApiService.class, context);

        Call<UsuarioJPS> tokenCall = authenticationApiService.autenticar(new AuthenticateModel(userName, password));
        String nuevoToken = tokenCall.execute().body().getToken();

        return nuevoToken;
    }
}
