package com.example.drunkmeter;

public class PastResEntry {

    //private image
    private String date;
    private String time;
    private String rating;

    public void setDate (String dateInstance){
        this.date = dateInstance;
    }

    public void setTime(String timeInstance){
        this.time = timeInstance;
    }

    public void setRating(String ratingInstance){
        this.rating = ratingInstance;
    }

    public String getDate() {
        return this.date;
    }

    public String getTime() {
        return this.time;
    }

    public String getRating() {
        return this.rating;
    }

    public void print(){
        System.out.println(date + " " + time);
        System.out.println(rating);
    }



}
