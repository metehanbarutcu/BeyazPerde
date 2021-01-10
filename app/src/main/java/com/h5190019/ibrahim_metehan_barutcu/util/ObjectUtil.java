package com.h5190019.ibrahim_metehan_barutcu.util;

import com.google.gson.Gson;
import com.h5190019.ibrahim_metehan_barutcu.model.Film;

public class ObjectUtil {

    public static String filmToJsonString(Film film) {
        Gson gson = new Gson();
        return gson.toJson(film);
    }

    public static Film jsonStringToFilm(String jsonString) {
        Gson gson = new Gson();
        return gson.fromJson(jsonString, Film.class);
    }
}
