package com.example.shoesstore.model;

import com.google.gson.annotations.SerializedName;

public class Products_sizes {
    @SerializedName("id")
    private int id;
    @SerializedName("size")
    private int size;
    @SerializedName("Quantity")
    private int quantity;
    @SerializedName("product_id")
    private int product_id;

    public Products_sizes(int id, int size, int quantity, int product_id) {
        this.id = id;
        this.size = size;
        this.quantity = quantity;
        this.product_id = product_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }
}
