package com.example.mvvmdemo.api;

import rx.Observer;

// API 觀察者
public abstract class ApiObserver<T> implements Observer<T> {
    public ApiObserver() {
    }

    @Override
    public void onNext(T t) {
        onNext(t);
    }

    @Override
    public void onCompleted() {
    }

    @Override
    public void onError(Throwable e) {
    }
}
