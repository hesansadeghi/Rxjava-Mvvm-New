 package com.example.rxjavamvvmnew.model;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Model_Posts {

    @SerializedName("id")
    private String id;
    @SerializedName("title")
    private String title;
    @SerializedName("imageurl")
    private String imageurl;
    @SerializedName("date")
    private String date;
    @SerializedName("view")
    private String view;
    @SerializedName("des")
    private String des;
    @SerializedName("price")
    private Integer price;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getPrice() {
        return String.valueOf(price)+" تومان ";
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @BindingAdapter("imageurl")
    public static void loadImage(ImageView imageView,String url)
    {
        Glide.with(imageView).load(url).into(imageView);
    }




    @Override
    public String toString() {
        return "Model_Posts{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", imageurl='" + imageurl + '\'' +
                ", date='" + date + '\'' +
                ", view='" + view + '\'' +
                ", des='" + des + '\'' +
                ", price=" + price +
                '}';
    }
}