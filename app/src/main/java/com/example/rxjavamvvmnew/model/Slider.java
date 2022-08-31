package com.example.rxjavamvvmnew.model;

import com.google.gson.annotations.SerializedName;

public class Slider {

    @SerializedName("image")
    String image;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Slider{" +
                "image='" + image + '\'' +
                '}';
    }
}
