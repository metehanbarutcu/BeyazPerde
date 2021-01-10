package com.h5190019.ibrahim_metehan_barutcu.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.h5190019.ibrahim_metehan_barutcu.R;
import com.h5190019.ibrahim_metehan_barutcu.model.Film;
import com.h5190019.ibrahim_metehan_barutcu.util.GlideUtil;

import java.util.List;

public class FilmAdapter extends RecyclerView.Adapter<FilmViewHolder> {

    List<Film> films;
    Context context;
    OnItemClickListener listener;

    public interface OnItemClickListener {
        void onClick(int position);
    }

    public FilmAdapter(List<Film> films, Context context, OnItemClickListener listener) {
        this.films = films;
        this.context = context;
        this.listener = listener;
    }

    @NonNull
    @Override
    public FilmViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_film, parent, false);
        return new FilmViewHolder(itemView, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull FilmViewHolder holder, int position) {

        holder.txtFilmName.setText(films.get(position).getFilmName());
        holder.txtType.setText(films.get(position).getType());
        holder.txtDate.setText(films.get(position).getReleaseDate());
        GlideUtil.downloadAndShowImage(context, films.get(position).getImageURL(), holder.imgFilm);

    }

    @Override
    public int getItemCount() {
        return films.size();
    }
}
