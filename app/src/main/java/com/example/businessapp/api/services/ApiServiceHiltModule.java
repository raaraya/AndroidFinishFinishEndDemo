package com.example.businessapp.api.services;

import android.content.Context;

import com.example.businessapp.R;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ApplicationComponent;
import dagger.hilt.android.qualifiers.ActivityContext;
import dagger.hilt.android.qualifiers.ApplicationContext;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


@Module
@InstallIn(ApplicationComponent.class)
public class ApiServiceHiltModule {

    @Singleton
    @Provides
    public static PuntosApiService providePuntosApiService(@ApplicationContext Context context) {
        return new Retrofit.Builder()
                .baseUrl(context.getString(R.string.base_url))
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(PuntosApiService.class);
    }

}
