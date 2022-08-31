package com.example.rxjavamvvmnew.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ModelDetails {

    @SerializedName("slider")
    public List<Slider> sliderList;
    @SerializedName("post")
    public List<Model_Posts> modeLposts;

    @Override
    public String toString() {
        return "ModelDetails{" +
                "sliderList=" + sliderList +
                ", modeLposts=" + modeLposts +
                '}';
    }
}
