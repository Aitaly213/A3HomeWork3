package com.geektech.a3lesson3.data.interfaces;

import com.geektech.a3lesson3.data.models.FilmModel;

public interface OnClickListener {

    void onClick(FilmModel m, int position);

    void deleteFilm(FilmModel m,int position);

}
