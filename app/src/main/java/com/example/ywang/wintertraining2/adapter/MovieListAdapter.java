package com.example.ywang.wintertraining2.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.ywang.wintertraining2.R;
import com.example.ywang.wintertraining2.base.Movie;

import java.util.List;

public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.ViewHolder>{

    private List<Movie> movieList;
    private Context context;

    public MovieListAdapter(List<Movie> movies){
        movieList = movies;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.movie_item,viewGroup,false);
        context = viewGroup.getContext();
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Movie movie = movieList.get(i);
        viewHolder.movieTitle.setText(movie.getTitle());
        viewHolder.movieGenres.setText(movie.getGenres());
        viewHolder.movieAverage.setText(movie.getAverage());
        viewHolder.movieTime.setText(movie.getTime());
        //加载网络图片
        Glide.with(context).load(movie.getImageUrl()).into(viewHolder.imageView);
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView movieTitle,movieGenres,movieAverage,movieTime;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.movie_image);
            movieTitle = itemView.findViewById(R.id.movie_title);
            movieGenres = itemView.findViewById(R.id.movie_genres);
            movieAverage = itemView.findViewById(R.id.movie_average);
            movieTime = itemView.findViewById(R.id.movie_time);
        }
    }
}
