package com.example.flixterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.RatingBar;
import android.widget.TextView;

import com.codepath.asynchttpclient.AsyncHttpClient;
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler;
import com.example.flixterapp.models.Movie;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.parceler.Parcels;

import okhttp3.Headers;

public class DetailActivity extends YouTubeBaseActivity {
    public static final String YOTUBE_API_KEY = "AIzaSyBKeLqmghYjYzBQBuRkQdARPavmeRGoTIQ";
    public static final String videourl = "https://api.themoviedb.org/3/movie/%d/videos?api_key=a07e22bc18f5cb106bfe4cc1f83ad8ed";
    TextView dtitle, doverview;
    RatingBar ratingBar;
    YouTubePlayerView youTubePlayerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        dtitle = findViewById(R.id.dtitle);
        doverview = findViewById(R.id.doverview);
        ratingBar = findViewById(R.id.ratingBar);
        youTubePlayerView = findViewById(R.id.player);

        Movie movie = Parcels.unwrap(getIntent().getParcelableExtra("movie"));

        dtitle.setText(movie.getTitle());
        doverview.setText(movie.getOverview());
        ratingBar.setRating((float) movie.getVoteavg());
        double rating = movie.getVoteavg();

        AsyncHttpClient client = new AsyncHttpClient();
        client.get(String.format(videourl, movie.getMovieid()), new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int i, Headers headers, JSON json) {
                try {
                    JSONArray results = json.jsonObject.getJSONArray("results");
                    if(results.length()==0){
                        return;
                    }
                    String youtubekey = results.getJSONObject(0).getString("key");
                    Log.d("DetailActivity", youtubekey);
                    initializeyoutube(youtubekey, rating);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int i, Headers headers, String s, Throwable throwable) {

            }
        });

    }

    private void initializeyoutube(String youtubekey, double rating) {
        youTubePlayerView.initialize(YOTUBE_API_KEY, new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.cueVideo(youtubekey);
                if((rating / 2) > 3.5){
                    youTubePlayer.loadVideo(youtubekey);
                    youTubePlayer.setFullscreen(true);
                }
            }
            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                Log.d("DetailActivity", "onInitializationFailure");
            }
        });
    }
}