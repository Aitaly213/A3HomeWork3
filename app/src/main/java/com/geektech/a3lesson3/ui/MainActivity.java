package com.geektech.a3lesson3.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;


import com.geektech.a3lesson3.App;
import com.geektech.a3lesson3.R;
import com.geektech.a3lesson3.data.interfaces.FilmCallback;
import com.geektech.a3lesson3.data.interfaces.FilmsCallback;
import com.geektech.a3lesson3.data.interfaces.OnClickListener;
import com.geektech.a3lesson3.data.models.FilmModel;

import java.util.List;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    FilmAdapter adapter;
    RecyclerView recyclerView;
    Button addBtn;



    public static final String FILM_MODEL = "film";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new FilmAdapter();
        adapter.setListener(this);
        recyclerView = findViewById(R.id.rv);
        addBtn = findViewById(R.id.add_btn);

        recyclerView.setAdapter(adapter);

        App.service.getFilms(new FilmsCallback() {
            @Override
            public void onSuccess(List<FilmModel> films) {
                adapter.setFilms(films);
            }

            @Override
            public void onFailure(Throwable t) {
            }
        });
        addBtn.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this,FilmActivity.class);
            startActivity(intent);
        });
    }

    @Override
    public void onClick(FilmModel m, int position) {
        Intent i = new Intent(this,FilmActivity.class);
        i.putExtra(FILM_MODEL, m);
        startActivity(i);
    }

    @Override
    public void deleteFilm(FilmModel m, int position) {
        App.service.deleteFilm(m.getFilmId(), new FilmCallback() {
            @Override
            public void onSuccess(FilmModel model) {
                Toast.makeText(MainActivity.this, "Пост удален!", Toast.LENGTH_SHORT).show();
                adapter.deleteFilm(position);
            }

            @Override
            public void onFailure(Throwable throwable) {
                Log.d("errorFilm",throwable.getMessage());
            }
        });
    }
}