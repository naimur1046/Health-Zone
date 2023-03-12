package com.example.myapplication;

import android.widget.ImageView;

public class DataFormateForRecyclerview
{
    ImageView imageView;
    String name;
    String details;

    public DataFormateForRecyclerview(ImageView imageView, String name, String details) {
        this.imageView = imageView;
        this.name = name;
        this.details = details;
    }


    public ImageView getImageView() {
        return imageView;
    }

    public String getName() {
        return name;
    }

    public String getDetails() {
        return details;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
