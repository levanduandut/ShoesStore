package com.example.shoesstore.model;

import com.google.gson.annotations.SerializedName;

public class Products_photo {
    @SerializedName("id")
    private int id;
    @SerializedName("name")
    private String name;
    @SerializedName("data")
    private String data;
    @SerializedName("product_id")
    private int product_id;

    public Products_photo(int id, String name, String data, int product_id) {
        this.id = id;
        this.name = name;
        this.data = data;
        this.product_id = product_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return "https://truong45truong.pythonanywhere.com/media/photos/products/" + name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }
}
