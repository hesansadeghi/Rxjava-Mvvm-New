package com.example.rxjavamvvmnew.model;

import com.google.gson.annotations.SerializedName;

public class ModelAllPrice {

    @SerializedName("price")
    private String price;

    public String getPrice() {
        return price+" تومان ";
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ModelAllPrice{" +
                "price='" + price + '\'' +
                '}';
    }
}
