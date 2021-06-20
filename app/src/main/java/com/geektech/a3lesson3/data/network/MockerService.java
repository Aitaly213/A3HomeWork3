package com.geektech.a3lesson3.data.network;

import android.util.Log;

import com.geektech.a3lesson3.data.interfaces.FilmCallback;
import com.geektech.a3lesson3.data.interfaces.FilmsCallback;
import com.geektech.a3lesson3.data.models.FilmModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MockerService {

    private Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://android-3-mocker.herokuapp.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    private MockerApi client = retrofit.create(MockerApi.class);

    public void getFilms(FilmsCallback filmCallback){
        client.getFilms().enqueue(new Callback<List<FilmModel>>() {
            @Override
            public void onResponse(Call<List<FilmModel>> call, Response<List<FilmModel>> response) {
                filmCallback.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<List<FilmModel>> call, Throwable t) {
                filmCallback.onFailure(t);
            }
        });
    }

    public void addFilm(FilmModel filmModel,FilmCallback f){
        client.addFilm(filmModel).enqueue(new Callback<FilmModel>() {
            @Override
            public void onResponse(Call<FilmModel> call, Response<FilmModel> response) {
                f.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<FilmModel> call, Throwable t) {
            }
        });
    }

    public void deleteFilm(int id, FilmCallback f){
        client.deleteFilm(id).enqueue(new Callback<FilmModel>() {
            @Override
            public void onResponse(Call<FilmModel> call, Response<FilmModel> response) {
                f.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<FilmModel> call, Throwable t) {
                f.onFailure(t);
            }
        });
    }

    public void updatePost(int id,FilmModel filmModel, FilmCallback f){
        client.update(id,filmModel).enqueue(new Callback<FilmModel>() {
            @Override
            public void onResponse(Call<FilmModel> call, Response<FilmModel> response) {
                f.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<FilmModel> call, Throwable t) {
                f.onFailure(t);
            }
        });
    }

    public void getFilmById(int id, FilmCallback f){
        client.getFilmById(id).enqueue(new Callback<FilmModel>() {
            @Override
            public void onResponse(Call<FilmModel> call, Response<FilmModel> response) {
                f.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<FilmModel> call, Throwable t) {
                f.onFailure(t);
            }
        });
    }

}
