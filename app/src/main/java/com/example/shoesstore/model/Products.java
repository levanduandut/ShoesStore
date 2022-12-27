package com.example.shoesstore.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Products {
    @SerializedName("slug")
    private String slug;
    @SerializedName("name")
    private String name;
    @SerializedName("sex")
    private int sex;
    @SerializedName("description")
    private String description;
    @SerializedName("store_id")
    private int store_id;
    @SerializedName("category_id")
    private int category_id;
    @SerializedName("prices")
    private List<Products_prices> prices;
    @SerializedName("sizes")
    private List<Products_sizes> sizes;
    @SerializedName("photo_products")
    private List<Products_photo> photo_products;


    public Products(String slug, String name, int sex, String description, int store_id, int category_id, List<Products_prices> prices, List<Products_sizes> sizes, List<Products_photo> photo_products) {
        this.slug = slug;
        this.name = name;
        this.sex = sex;
        this.description = description;
        this.store_id = store_id;
        this.category_id = category_id;
        this.prices = prices;
        this.sizes = sizes;
        this.photo_products = photo_products;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStore_id() {
        return store_id;
    }

    public void setStore_id(int store_id) {
        this.store_id = store_id;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public List<Products_prices> getPrices() {
        return prices;
    }

    public void setPrices(List<Products_prices> prices) {
        this.prices = prices;
    }

    public List<Products_sizes> getSizes() {
        return sizes;
    }

    public void setSizes(List<Products_sizes> sizes) {
        this.sizes = sizes;
    }

    public List<Products_photo> getPhoto_products() {
        return photo_products;
    }

    public void setPhoto_products(List<Products_photo> photo_products) {
        this.photo_products = photo_products;
    }
}
