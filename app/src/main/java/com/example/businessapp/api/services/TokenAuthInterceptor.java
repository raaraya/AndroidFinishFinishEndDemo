package com.example.businessapp.api.services;

import android.content.Context;
import android.content.SharedPreferences;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class TokenAuthInterceptor implements Interceptor {

    private Context context;

    public TokenAuthInterceptor(Context context) {
        this.context = context;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {

        // se brinca ciertas URLs que no necesitan token
        Request originalRequest = chain.request();
        if (originalRequest.method() == "post" && originalRequest.url().encodedPath().contains("Users/authenticate")) {
            return chain.proceed(originalRequest);
        }

        // construye un nuevo basado en el original, pero con el token
        Request.Builder requestBuilder = originalRequest.newBuilder();

        SharedPreferences prefs = context.getSharedPreferences(context.getApplicationInfo().name, Context.MODE_PRIVATE);
        String token = prefs.getString("TOKEN", null);

        requestBuilder.addHeader("Authorization", String.format("Bearer %s", token)); //.url(originalRequest.url()); - no se si hace falta

        return chain.proceed(requestBuilder.build());
    }
}
