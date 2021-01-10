package com.h5190019.ibrahim_metehan_barutcu.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Film {

    @SerializedName("FilmName")
    @Expose
    private String filmName;
    @SerializedName("Country")
    @Expose
    private String country;
    @SerializedName("ImageURL")
    @Expose
    private String imageURL;
    @SerializedName("HeaderImageURL")
    @Expose
    private String headerImageURL;
    @SerializedName("Type")
    @Expose
    private String type;
    @SerializedName("Duration")
    @Expose
    private String duration;
    @SerializedName("ReleaseDate")
    @Expose
    private String releaseDate;
    @SerializedName("Director")
    @Expose
    private String director;
    @SerializedName("IMDB")
    @Expose
    private String iMDB;
    @SerializedName("Plot")
    @Expose
    private String plot;

    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getHeaderImageURL() {
        return headerImageURL;
    }

    public void setHeaderImageURL(String headerImageURL) {
        this.headerImageURL = headerImageURL;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getIMDB() {
        return iMDB;
    }

    public void setIMDB(String iMDB) {
        this.iMDB = iMDB;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

}