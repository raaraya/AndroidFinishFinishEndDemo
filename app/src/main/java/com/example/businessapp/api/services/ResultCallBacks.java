package com.example.businessapp.api.services;

public interface ResultCallBacks<T> {
    void onSuccess(T result);
    void onFailure();
}
