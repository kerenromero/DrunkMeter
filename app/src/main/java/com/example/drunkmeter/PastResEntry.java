package com.example.drunkmeter;

public class PastResEntry {

    //private image
    private String date;
    private String time;
    private String rating;

    PastResEntry(String date, String time, String rating){
        this.date = date;
        this.time = time;
        this.rating = rating;
    }

    PastResEntry(){

    }

    public void setDate (String dateInstance){
        this.date = dateInstance;
    }

    public void setTime(String timeInstance){
        this.time = timeInstance;
    }

    public void setRating(String ratingInstance){
        this.rating = ratingInstance;
    }

    public String getDateAndTime(){
        return this.date + " " + this.time;
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
