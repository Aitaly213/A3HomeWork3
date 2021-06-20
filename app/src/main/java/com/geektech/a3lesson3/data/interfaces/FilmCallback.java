package com.geektech.a3lesson3.data.interfaces;

import com.geektech.a3lesson3.data.models.FilmModel;

import java.util.List;

public interface FilmCallback extends BaseCallback<FilmModel> {
    void onSuccess(FilmModel model);

    void onFailure(Throwable throwable);
}
