package com.example.businessapp.api.services;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitService {

    private static Retrofit retrofitBuilder(String baseUrl){
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static <T> T createAPI(Class<T> serviceClass, String baseUrl) {
        return retrofitBuilder(baseUrl).create(serviceClass);
    }

}
