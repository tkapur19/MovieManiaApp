package com.example.tarunkapur.vollymovie;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class MovieDescription extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ImageView poster=(ImageView) findViewById(R.id.poster);
        TextView releaseDate=(TextView) findViewById(R.id.release_date);
        TextView rating=(TextView) findViewById(R.id.rating);
        TextView overViewContent=(TextView) findViewById(R.id.content);
        TextView movieTitle=(TextView) findViewById(R.id.movie_title);




        Bundle bundle=getIntent().getExtras();
        String posterUrl=bundle.getString("posterPath");
        Picasso.with(this).load(posterUrl).into(poster);

        String release=bundle.getString("releaseDate");
        String movieRating= bundle.get("rating").toString();
        String movieContent=bundle.getString("overView");
        String title=bundle.getString("title");

        releaseDate.setText("release date: "+release);
        rating.setText("rating: "+movieRating);
        overViewContent.setText(movieContent);
        movieTitle.setText("title: "+title);


    }

}
