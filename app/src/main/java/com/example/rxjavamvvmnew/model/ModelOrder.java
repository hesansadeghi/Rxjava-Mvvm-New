package com.example.rxjavamvvmnew.model;

import com.google.gson.annotations.SerializedName;

public class ModelOrder {

    @SerializedName("id")
    private String id;
    @SerializedName("iduser")
    private String iduser;
    @SerializedName("idaddress")
    private String idaddress;
    @SerializedName("price")
    private String price;
    @SerializedName("status")
    private Integer status;
    @SerializedName("code_pardakht")
    private String code_pardakht;
    @SerializedName("Authority")
    private String Authority;

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

    public String getIdaddress() {
        return idaddress;
    }

    public void setIdaddress(String idaddress) {
        this.idaddress = idaddress;
    }

    public String getPrice() {
        return price+" تومان ";
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCode_pardakht() {
        return code_pardakht;
    }

    public void setCode_pardakht(String code_pardakht) {
        this.code_pardakht = code_pardakht;
    }

    public String getAuthority() {
        return Authority;
    }

    public void setAuthority(String authority) {
        Authority = authority;
    }

    @Override
    public String toString() {
        return "ModelOrder{" +
                "id='" + id + '\'' +
                ", iduser='" + iduser + '\'' +
                ", idaddress='" + idaddress + '\'' +
                ", price='" + price + '\'' +
                ", status='" + status + '\'' +
                ", code_pardakht='" + code_pardakht + '\'' +
                ", Authority='" + Authority + '\'' +
                '}';
    }
}
