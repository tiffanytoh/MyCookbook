package com.example.tiffany.myapplication;

/**
 * Created by Tiffany on 03-Mar-17.
 */

public class Recipe {

    private int id;
    private String title;
    private String details;

    public Recipe(int id, String title, String details) {
        this.id = id;
        this.title = title;
        this.details = details;

    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }


}
