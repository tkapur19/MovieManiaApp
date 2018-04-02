package com.example.tarunkapur.vollymovie;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by tarunkapur on 17/02/18.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.viewHolder>{

    private List<ModalClass> movies;
    private Context context;

    public MyAdapter(List<ModalClass> movies, Context context) {
        Log.i("myMessage", "MyAdapter: ");
        this.movies = movies;
        this.context = context;
    }

    @Override
    public MyAdapter.viewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view,parent,false);
        return new viewHolder(v);

    }

    @Override
    public void onBindViewHolder(MyAdapter.viewHolder holder, int position) {
        final ModalClass modalClass=movies.get(position);
        holder.movieHead.setText(modalClass.getMovieTitle());
        holder.releaseDate.setText(modalClass.getReleaseDate());
        Picasso.with(context).load("https://image.tmdb.org/t/p/w500"+modalClass.getPosterPath()).into( holder.poster);
        holder.poster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,MovieDescription.class);
                intent.putExtra("posterPath","https://image.tmdb.org/t/p/w500"+modalClass.getPosterPath());
                intent.putExtra("releaseDate",modalClass.getReleaseDate());
                intent.putExtra("overView",modalClass.getOverView());
                intent.putExtra("rating",modalClass.getRating());
                intent.putExtra("title",modalClass.getMovieTitle());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });

        Log.i("myMessage", "onBindViewHolder: ");


    }

    @Override
    public int getItemCount() {
        return movies.size();
    }
    public class viewHolder extends RecyclerView.ViewHolder{

        private TextView movieHead;
        private TextView releaseDate;
        private ImageView poster;

        public viewHolder(View itemView) {
            super(itemView);
            movieHead=(TextView) itemView.findViewById(R.id.tx1);
            releaseDate=(TextView) itemView.findViewById(R.id.tx2);
            poster=(ImageView) itemView.findViewById(R.id.imageView);

        }
    }
}
