package com.example.shoesstore.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Cart implements Serializable {
    @SerializedName("product_id__slug")
    private String product_id__slug;
    @SerializedName("product_id__name")
    private String product_id__name;
    @SerializedName("quantity")
    private int quantity;
    @SerializedName("size")
    private int size;
    @SerializedName("product_id__photo_products__name")
    private String product_id__photo_products__name;
    @SerializedName("product_id__prices__price")
    private float product_id__prices__price;
    @SerializedName("product_id__prices__sale")
    private int product_id__prices__sale;
    @SerializedName("product_id__prices__price_total")
    private double product_id__prices__price_total;


    public Cart(String product_id__slug, String product_id__name, int quantity, int size, String product_id__photo_products__name, float product_id__prices__price, int product_id__prices__sale, double product_id__prices__price_total) {
        this.product_id__slug = product_id__slug;
        this.product_id__name = product_id__name;
        this.quantity = quantity;
        this.size = size;
        this.product_id__photo_products__name = product_id__photo_products__name;
        this.product_id__prices__price = product_id__prices__price;
        this.product_id__prices__sale = product_id__prices__sale;
        this.product_id__prices__price_total = product_id__prices__price_total;
    }

    public String getProduct_id__slug() {
        return product_id__slug;
    }

    public void setProduct_id__slug(String product_id__slug) {
        this.product_id__slug = product_id__slug;
    }

    public float getProduct_id__prices__price() {
        return product_id__prices__price;
    }

    public void setProduct_id__prices__price(float product_id__prices__price) {
        this.product_id__prices__price = product_id__prices__price;
    }

    public int getProduct_id__prices__sale() {
        return product_id__prices__sale;
    }

    public void setProduct_id__prices__sale(int product_id__prices__sale) {
        this.product_id__prices__sale = product_id__prices__sale;
    }

    public double getProduct_id__prices__price_total() {
        return product_id__prices__price_total;
    }

    public void setProduct_id__prices__price_total(double product_id__prices__price_total) {
        this.product_id__prices__price_total = product_id__prices__price_total;
    }

    public String getProduct_id__name() {
        return product_id__name;
    }

    public void setProduct_id__name(String product_id__name) {
        this.product_id__name = product_id__name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getProduct_id__photo_products__name() {
        return "https://truong45truong.pythonanywhere.com/media/photos/products/" +product_id__photo_products__name;
    }

    public void setProduct_id__photo_products__name(String product_id__photo_products__name) {
        this.product_id__photo_products__name = product_id__photo_products__name;
    }
}
