package com.example.foodhub.model;

public class ScreenItem {

    String Title, Description;
    int ScreenImg;
    int point;

    public ScreenItem(String title, String description, int screenImg, int point) {
        Title = title;
        Description = description;
        ScreenImg = screenImg;
        this.point = point;
    }

    public String getTitle() {
        return Title;
    }


    public String getDescription() {
        return Description;
    }


    public int getScreenImg() {
        return ScreenImg;
    }

    public int getPoint() {
        return point;
    }

}
