package com.geektech.a3lesson3.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import androidx.recyclerview.widget.RecyclerView;

import com.geektech.a3lesson3.R;
import com.geektech.a3lesson3.data.interfaces.OnClickListener;
import com.geektech.a3lesson3.data.models.FilmModel;

import java.util.ArrayList;
import java.util.List;

public class FilmAdapter extends RecyclerView.Adapter<FilmViewHolder> {

    private List<FilmModel> filmModels = new ArrayList();
    OnClickListener listener;

    public void setFilms(List<FilmModel> films){
        filmModels.addAll(films);
        notifyDataSetChanged();
    }

    public void setListener(OnClickListener listener){
        this.listener = listener;
    }

    public void deleteFilm(int pos){
        filmModels.remove(pos);
        notifyItemRemoved(pos);
    }

    public FilmViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.film_item,parent,false);
        return new FilmViewHolder(v,listener);
    }

    @Override
    public void onBindViewHolder( FilmViewHolder holder, int position) {
        holder.onBind(filmModels.get(position));
    }

    @Override
    public int getItemCount() {
        return filmModels.size();
    }
}

class FilmViewHolder extends RecyclerView.ViewHolder{

    TextView title;
    FilmModel model;

    public FilmViewHolder(View itemView, OnClickListener listener) {
        super(itemView);
        title = itemView.findViewById(R.id.title);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(model,getAdapterPosition());
            }
        });

        itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                listener.deleteFilm(model,getAdapterPosition());
                return true;
            }
        });

    }

    public void onBind(FilmModel model){
        this.title.setText(model.getTitle());
        this.model = model;
    }

}
