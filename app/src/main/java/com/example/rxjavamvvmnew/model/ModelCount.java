package com.example.rxjavamvvmnew.model;

import com.google.gson.annotations.SerializedName;

public class ModelCount {

    @SerializedName("count")
   private Integer count;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
