package com.example.ywang.wintertraining2.base;

public class Movie {
    private String title; //电影标题
    private String imageUrl; //电影海报
    private String time; //影片时长
    private String average; //电影评分
    private String genres; //电影类型

    public Movie(String title, String imageUrl, String time, String average, String genres) {
        this.title = title;
        this.imageUrl = imageUrl;
        this.time = time;
        this.average = average;
        this.genres = genres;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getAverage() {
        return average;
    }

    public void setAverage(String average) {
        this.average = average;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }
}
