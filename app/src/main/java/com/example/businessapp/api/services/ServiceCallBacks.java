package com.example.businessapp.api.services;

public interface ServiceCallBacks<T> {
    void onSuccess(T result);
    void onFailure();
}
