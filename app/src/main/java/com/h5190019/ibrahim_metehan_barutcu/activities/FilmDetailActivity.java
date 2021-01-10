package com.h5190019.ibrahim_metehan_barutcu.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.widget.ImageView;
import android.widget.TextView;

import com.h5190019.ibrahim_metehan_barutcu.R;
import com.h5190019.ibrahim_metehan_barutcu.model.Film;
import com.h5190019.ibrahim_metehan_barutcu.util.Constants;
import com.h5190019.ibrahim_metehan_barutcu.util.GlideUtil;
import com.h5190019.ibrahim_metehan_barutcu.util.ObjectUtil;

public class FilmDetailActivity extends AppCompatActivity {

    ImageView imgHeader;
    TextView txtFilmName, txtPlot, txtDate, txtDuration, txtDirector, txtImdb, txtFilmType, txtCountry;
    String htmlString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_film_detail);

        init();

    }

    private void init() {

        String movedFilmString = getIntent().getStringExtra(Constants.CLICKED_FILM_IS_THE_TITLE_OF_THE_MOVED_ONE);
        Film film = ObjectUtil.jsonStringToFilm(movedFilmString);
        htmlString = film.getPlot();


        imgHeader = findViewById(R.id.imgHeader);
        txtFilmName = findViewById(R.id.txtFilmDetailName);
        txtCountry = findViewById(R.id.txtCountry);
        txtDate = findViewById(R.id.txtReleaseDate);
        txtDuration = findViewById(R.id.txtDuration);
        txtDirector = findViewById(R.id.txtDirector);
        txtFilmType = findViewById(R.id.txtFilmType);
        txtImdb = findViewById(R.id.txtImdb);
        txtPlot = findViewById(R.id.txtPlot);

        txtFilmName.setText(film.getFilmName());
        txtImdb.setText(film.getIMDB());
        txtFilmType.setText(film.getType());
        txtDirector.setText(film.getDirector());
        txtDuration.setText(film.getDuration());
        txtDate.setText(film.getReleaseDate());
        txtCountry.setText(film.getCountry());

        showHtmlData(txtPlot, htmlString);
        GlideUtil.downloadAndShowImage(getApplicationContext(), film.getHeaderImageURL(), imgHeader);

    }

    private void showHtmlData(TextView textView, String htmlData) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            textView.setText(Html.fromHtml(htmlData, Html.FROM_HTML_MODE_LEGACY));
        } else {
            textView.setText(Html.fromHtml(htmlData));
        }
    }

}