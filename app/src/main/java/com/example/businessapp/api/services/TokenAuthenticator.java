package com.example.businessapp.api.services;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.businessapp.R;
import com.example.businessapp.api.models.AuthenticateModel;
import com.example.businessapp.api.models.AuthenticateResponse;

import java.io.IOException;

import javax.annotation.Nullable;

import okhttp3.Authenticator;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;
import retrofit2.Call;

public class TokenAuthenticator implements Authenticator {

    private String baseUrl;
    private Context context;

    public TokenAuthenticator(Context context) {
        this.context = context;
        baseUrl = context.getString(R.string.base_url);
    }

    @Nullable
    @Override
    public Request authenticate(@Nullable Route route, Response response) throws IOException {

        String token = obtenerNuevoToken();

        SharedPreferences prefs = context.getSharedPreferences(context.getApplicationInfo().name, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("TOKEN", token);
        editor.apply();

        return response.request()
                .newBuilder()
                .header("Authorization", String.format("Bearer %s", token))
                .build();
    }

    private String obtenerNuevoToken() throws IOException {
        AuthenticationApiService authenticationApiService = RetrofitService.createAPIService(AuthenticationApiService.class, context);

        Call<AuthenticateResponse> tokenCall = authenticationApiService.autenticar(new AuthenticateModel("user_puntoventa", "123456.JPS"));
        String nuevoToken = tokenCall.execute().body().getToken();

        return nuevoToken;
    }
}
