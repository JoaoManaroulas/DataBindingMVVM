package com.jgsmanaroulas.mvvmtest.mvvmtest.model;

/**
 * Created by jgsmanaroulas on 07/03/16.
 */
public class Book {


    int id;
    String name;
    String version;
    int likes = 0;
    int percentage = 0;


    public Book(int id, String name, String version){
        this.id = id;
        this.name = name;
        this.version = version;
    }

    public int getPercentage() {
        return percentage;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
