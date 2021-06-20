package com.geektech.a3lesson3.data.network;

import com.geektech.a3lesson3.data.models.FilmModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MockerApi {

    @GET("posts/")
    Call<List<FilmModel>> getFilms();

    @POST("posts/")
    Call<FilmModel> addFilm(@Body FilmModel model);

    @DELETE("posts/{postId}")
    Call<FilmModel> deleteFilm(@Path("postId") int id);

    @GET("posts/")
    Call<FilmModel> getFilmById(@Query("id") int id);

    @PUT("posts/{postId}")
    Call<FilmModel> update(@Path("postId") int id,
                           @Body FilmModel filmModel);


}
