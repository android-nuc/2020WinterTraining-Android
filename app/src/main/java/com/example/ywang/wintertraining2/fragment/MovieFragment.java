package com.example.ywang.wintertraining2.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.ywang.wintertraining2.R;
import com.example.ywang.wintertraining2.adapter.MovieListAdapter;
import com.example.ywang.wintertraining2.base.Movie;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MovieFragment extends Fragment {

    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private TextView messageText;
    private List<Movie> movieList = new ArrayList<>();

    private String path = "http://api.douban.com/v2/movie/top250?" +
            "apikey=0df993c66c0c636e29ecbb5344252a4a" +
            "&start=0&count=250";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movie,container,false);
        recyclerView = view.findViewById(R.id.movie_fragment_recycler);
        progressBar = view.findViewById(R.id.fragment_progress);
        messageText = view.findViewById(R.id.fragment_message);
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(manager);
        requestData();
        return view;
    }

    //数据请求
    private void requestData(){
        progressBar.setVisibility(View.VISIBLE);
        messageText.setVisibility(View.VISIBLE);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    OkHttpClient client = new OkHttpClient();
                    //请求链接
                    Request request = new Request.Builder().url(path).build();
                    //获取相应
                    Response response = client.newCall(request).execute();
                    //通过响应获取json数据
                    String responseData = response.body().string();
                    //解析数据
                    parseJson(responseData);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    //解析Json数据
    private void parseJson(final String responseData){
        try {
            JSONObject jsonObject = new JSONObject(responseData);
            JSONArray jsonArray = jsonObject.getJSONArray("subjects");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject_i = jsonArray.getJSONObject(i);
                String title = jsonObject_i.get("title").toString();
                JSONArray genresArray = jsonObject_i.getJSONArray("genres");
                String genres = "";
                for (int j = 0; j < genresArray.length(); j++) {
                    genres = genres + " " + genresArray.get(j).toString();
                }
                String imageUrl = jsonObject_i.getJSONObject("images").getString("medium");
                String time = jsonObject_i.getJSONArray("durations").getString(0);
                String average = jsonObject_i.getJSONObject("rating").getString("average");
                Log.e("movie",title + genres + time + average + imageUrl);
                Movie movie = new Movie(title,imageUrl,time,average,genres);
                movieList.add(movie);
            }
            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    progressBar.setVisibility(View.GONE);
                    messageText.setVisibility(View.GONE);
                    MovieListAdapter adapter = new MovieListAdapter(movieList);
                    recyclerView.setAdapter(adapter);
                }
            });
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
