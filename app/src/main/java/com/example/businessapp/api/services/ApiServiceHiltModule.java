package com.example.businessapp.api.services;

import android.content.Context;

import com.example.businessapp.api.services.retrofit.RetrofitService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ApplicationComponent;
import dagger.hilt.android.qualifiers.ApplicationContext;


@Module
@InstallIn(ApplicationComponent.class)
public class ApiServiceHiltModule {

    @Singleton
    @Provides
    public static UsersApiService provideUsersApiService(@ApplicationContext Context context) {
        return RetrofitService.createAPIService(UsersApiService.class, context);
    }

    @Singleton
    @Provides
    public static AuthenticationApiService provideAuthenticationApiService(@ApplicationContext Context context) {
        return RetrofitService.createAPIService(AuthenticationApiService.class, context);
    }

}
