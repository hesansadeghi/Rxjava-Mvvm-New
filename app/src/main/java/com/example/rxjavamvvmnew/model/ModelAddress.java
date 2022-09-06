package com.example.rxjavamvvmnew.model;

import com.google.gson.annotations.SerializedName;

public class ModelAddress {

    @SerializedName("id")
    private String id;
    @SerializedName("iduser")
    private String iduser;
    @SerializedName("city")
    private String city;
    @SerializedName("meli")
    private String meli;
    @SerializedName("code")
    private String code;
    @SerializedName("address")
    private String address;
    @SerializedName("phone")
    private String phone;
    @SerializedName("tell")
    private String tell;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIduser() {
        return iduser;
    }

    public void setIduser(String iduser) {
        this.iduser = iduser;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getMeli() {
        return meli;
    }

    public void setMeli(String meli) {
        this.meli = meli;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTell() {
        return tell;
    }

    public void setTell(String tell) {
        this.tell = tell;
    }

    @Override
    public String toString() {
        return "ModelAddress{" +
                "id='" + id + '\'' +
                ", iduser='" + iduser + '\'' +
                ", city='" + city + '\'' +
                ", meli='" + meli + '\'' +
                ", code='" + code + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", tell='" + tell + '\'' +
                '}';
    }
}
