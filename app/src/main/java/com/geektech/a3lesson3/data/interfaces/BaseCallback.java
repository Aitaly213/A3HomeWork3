package com.geektech.a3lesson3.data.interfaces;

public interface BaseCallback<T> {
    void onSuccess(T model);

    void onFailure(Throwable throwable);
}
