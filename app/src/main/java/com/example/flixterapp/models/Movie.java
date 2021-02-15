package com.example.flixterapp.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.List;
@Parcel
public class Movie {
    int movieid;
    String backdroppath;
    String posterPath;
    String title;
    String overview;
    double voteavg;

    public Movie() {
    }

    public Movie(JSONObject jsonObject) throws JSONException {
        posterPath = jsonObject.getString("poster_path");
        title = jsonObject.getString("title");
        overview = jsonObject.getString("overview");
        backdroppath = jsonObject.getString("backdrop_path");
        voteavg = jsonObject.getDouble("vote_average");
        movieid = jsonObject.getInt("id");
    }

    public static List <Movie> fromJSONArray (JSONArray movieJsonArray) throws JSONException {
        List <Movie> movies = new ArrayList<>();
        for(int i = 0; i< movieJsonArray.length(); i++){
            movies.add(new Movie(movieJsonArray.getJSONObject(i)));
        }
        return movies;
    }

    public String getPosterPath() {
        return String.format("https://image.tmdb.org/t/p/w342/%s", posterPath);
    }

    public String getTitle() {
        return title;
    }

    public String getOverview() {
        return overview;
    }

    public String getBackdroppath() {
        return String.format("https://image.tmdb.org/t/p/w342/%s", backdroppath);
    }

    public double getVoteavg() {
        return voteavg;
    }

    public int getMovieid() {
        return movieid;
    }
}
