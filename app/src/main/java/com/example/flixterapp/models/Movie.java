package com.example.flixterapp.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Movie {
    String backdroppath;
    String posterPath;
    String title;
    String overview;
    int voteavg;

    public Movie(JSONObject jsonObject) throws JSONException {
        posterPath = jsonObject.getString("poster_path");
        title = jsonObject.getString("title");
        overview = jsonObject.getString("overview");
        backdroppath = jsonObject.getString("backdrop_path");
        voteavg = jsonObject.getInt("vote_average");
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

    public int getVoteavg() {
        return voteavg;
    }
}
