package com.example.businessapp.api.services;

import android.content.Context;

import com.example.businessapp.R;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitService {

    private static OkHttpClient customClient(Context context) {
        return new OkHttpClient.Builder()
                .authenticator(new TokenAuthenticator(context))
                .addInterceptor(new TokenAuthInterceptor(context))
                .build();

    }

    private static Retrofit retrofitBuilder(Context context){

        String baseUrl = context.getString(R.string.base_url);

        return new Retrofit.Builder()
                .baseUrl(baseUrl)
//                .client(customClient(context))
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static <T> T createAPIService(Class<T> serviceClass, Context context) {
        return retrofitBuilder(context).create(serviceClass);
    }

}
