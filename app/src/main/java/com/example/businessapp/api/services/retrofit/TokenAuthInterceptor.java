package com.example.businessapp.api.services.retrofit;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class TokenAuthInterceptor implements Interceptor {

    private SharedPreferences sharedPreferences;

    public TokenAuthInterceptor(Context context) {
        this.sharedPreferences = context.getSharedPreferences(context.getApplicationInfo().name, Context.MODE_PRIVATE);
    }

    @Override
    public Response intercept(Chain chain) throws IOException {

        // se brinca ciertas URLs que no necesitan token
        Request originalRequest = chain.request();
        if (originalRequest.method() == "POST" && originalRequest.url().encodedPath().contains("/Users/authenticate")) {
            return chain.proceed(originalRequest);
        }

        // construye un nuevo basado en el original, pero con el token
        Request.Builder requestBuilder = originalRequest.newBuilder();

        String token = sharedPreferences.getString("token", null);

        if (token == null) {
            return chain.proceed(originalRequest);
        }

        requestBuilder.addHeader("Authorization", String.format("Bearer %s", token)); //.url(originalRequest.url()); - no se si hace falta

        return chain.proceed(requestBuilder.build());
    }
}
