package com.h5190019.ibrahim_metehan_barutcu.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;


import com.h5190019.ibrahim_metehan_barutcu.R;
import com.h5190019.ibrahim_metehan_barutcu.adapter.FilmAdapter;
import com.h5190019.ibrahim_metehan_barutcu.model.Film;
import com.h5190019.ibrahim_metehan_barutcu.network.Service;
import com.h5190019.ibrahim_metehan_barutcu.util.AlertUtil;
import com.h5190019.ibrahim_metehan_barutcu.util.Constants;
import com.h5190019.ibrahim_metehan_barutcu.util.ObjectUtil;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class FilmsActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ProgressDialog progressDialog;

    @Override
    public void onBackPressed() {
        AlertUtil.showExitAlert(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_films);

        init();

    }

    private void init() {
        createProgressDialog();
        getFilms();
    }

    private void getFilms() {

        new Service().getServiceApi().getFilms().
                subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<Film>>() {

                    List<Film> films = new ArrayList<>();

                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(List<Film> filmList) {
                        films = filmList;
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onComplete() {
                        if (films.size() > 0) {
                            initRecycleView(films);
                        }
                        progressDialog.dismiss();
                    }
                });
    }

    private void initRecycleView(List<Film> filmList) {
        recyclerView = findViewById(R.id.rcvFilms);
        FilmAdapter filmAdapter = new FilmAdapter(filmList, getApplicationContext(), new FilmAdapter.OnItemClickListener() {
            @Override
            public void onClick(int position) {

                Film clickedFilm = filmList.get(position);
                openNextActivity(clickedFilm);
            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(filmAdapter);
    }

    private void openNextActivity(Film clickedFilm) {
        Intent filmDetailActivity = new Intent(getApplicationContext(), FilmDetailActivity.class);
        String clickedFilmString = ObjectUtil.filmToJsonString(clickedFilm);
        filmDetailActivity.putExtra(Constants.CLICKED_FILM_IS_THE_TITLE_OF_THE_MOVED_ONE, clickedFilmString);
        startActivity(filmDetailActivity);
    }

    private void createProgressDialog() {
        progressDialog = new ProgressDialog(FilmsActivity.this);
        progressDialog.setMessage(getResources().getString(R.string.please_wait));
        progressDialog.show();
    }
}