package com.example.coursework;

import android.widget.ImageView;
import android.widget.TextView;

public class FilmCardFill {
    String title;
    Float vote;
    String poster;
    String year;
    String genre;
    Integer id;

    public FilmCardFill(Integer id, String title, Float vote, String poster, String year, String genre) {
        this.id = id;
        this.title = title;
        this.vote = vote;
        this.poster = poster;
        this.year = year;
        this.genre = genre;
    }

    public FilmCardFill() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Float getVote() {
        return vote;
    }

    public void setVote(Float vote) {
        this.vote = vote;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

}
