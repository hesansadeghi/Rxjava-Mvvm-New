 package com.example.rxjavamvvmnew.model;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.SerializedName;


public class ModelMinAdd {

    @SerializedName("count")
    private Integer count;
    @SerializedName("status")
    private String status;
    @SerializedName("price")
    private List<ModelAllPrice> price = new ArrayList<>();
    @SerializedName("price_post")
    private Integer pricePost;

    public String getCount() {
        return " تعداد : "+String.valueOf(count);
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ModelAllPrice> getPrice() {
        return price;
    }

    public void setPrice(List<ModelAllPrice> price) {
        this.price = price;
    }

    public Integer getPricePost() {
        return pricePost;
    }

    public void setPricePost(Integer pricePost) {
        this.pricePost = pricePost;
    }

}
