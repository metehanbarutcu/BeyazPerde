package com.h5190019.ibrahim_metehan_barutcu.network;

import com.h5190019.ibrahim_metehan_barutcu.model.Film;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ServiceApi {

    @GET("CristopherNolanFilms.json")
    Observable<List<Film>> getFilms();
}
