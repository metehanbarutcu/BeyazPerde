package com.h5190019.ibrahim_metehan_barutcu.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.h5190019.ibrahim_metehan_barutcu.R;

public class FilmViewHolder extends RecyclerView.ViewHolder {

    ImageView imgFilm;
    TextView txtFilmName;
    TextView txtType;
    TextView txtDate;

    public FilmViewHolder(@NonNull View itemView, FilmAdapter.OnItemClickListener listener) {
        super(itemView);

        imgFilm = itemView.findViewById(R.id.imgFilm);
        txtFilmName = itemView.findViewById(R.id.txtFilmName);
        txtType = itemView.findViewById(R.id.txtType);
        txtDate = itemView.findViewById(R.id.txtDate);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(getAdapterPosition());
            }
        });
    }
}
