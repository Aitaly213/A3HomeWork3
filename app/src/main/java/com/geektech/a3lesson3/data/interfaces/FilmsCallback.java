package com.geektech.a3lesson3.data.interfaces;

import com.geektech.a3lesson3.data.models.FilmModel;

import java.util.List;

public interface FilmsCallback extends BaseCallback<List<FilmModel>> {
    @Override
    void onSuccess(List<FilmModel> films);

    @Override
    void onFailure(Throwable e);
}
