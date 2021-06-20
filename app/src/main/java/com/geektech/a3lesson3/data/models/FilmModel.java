package com.geektech.a3lesson3.data.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class FilmModel implements Serializable {

    @SerializedName("id")
    private int filmId;

    @SerializedName("title")
    private String title;

    @SerializedName("content")
    private String content;

    @SerializedName("user")
    private int user;

    @SerializedName("group")
    private int group;

    public FilmModel() {
    }

    public FilmModel( String title, String content,int user,  int group) {
        this.title = title;
        this.content = content;
        this.user = user;
        this.group = group;
    }

    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }


}
