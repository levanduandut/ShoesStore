package com.example.shoesstore.model;

import com.google.gson.annotations.SerializedName;

public class Products_prices {
    @SerializedName("price")
    private float price;
    @SerializedName("sale")
    private float sale;
    @SerializedName("datetime_create")
    private String datetime_create;

    public Products_prices(float price, float sale, String datetime_create) {
        this.price = price;
        this.sale = sale;
        this.datetime_create = datetime_create;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getSale() {
        return sale;
    }

    public void setSale(float sale) {
        this.sale = sale;
    }

    public String getDatetime_create() {
        return datetime_create;
    }

    public void setDatetime_create(String datetime_create) {
        this.datetime_create = datetime_create;
    }
}
