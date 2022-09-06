 package com.example.rxjavamvvmnew.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class ModelRecord {

    @SerializedName("id")
    private Integer id;
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
    @SerializedName("iduser")
    private Integer iduser;
    @SerializedName("idproduct")
    private Integer idproduct;
    @SerializedName("count")
    private Integer count;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
        return String.valueOf(price)+"  تومان  ";
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getIduser() {
        return iduser;
    }

    public void setIduser(Integer iduser) {
        this.iduser = iduser;
    }

    public Integer getIdproduct() {
        return idproduct;
    }

    public void setIdproduct(Integer idproduct) {
        this.idproduct = idproduct;
    }

    public String getCount() {
        return " تعداد : "+String.valueOf(count);
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "ModelRecord{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", imageurl='" + imageurl + '\'' +
                ", date='" + date + '\'' +
                ", view='" + view + '\'' +
                ", des='" + des + '\'' +
                ", price=" + price +
                ", iduser=" + iduser +
                ", idproduct=" + idproduct +
                ", count=" + count +
                '}';
    }
}