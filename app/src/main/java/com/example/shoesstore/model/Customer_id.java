package com.example.shoesstore.model;

import com.google.gson.annotations.SerializedName;

public class Customer_id {
    @SerializedName("birthday")
    private String birthday;
    @SerializedName("address")
    private String address;
    @SerializedName("slug")
    private String slug;

    public Customer_id(String birthday, String address, String slug) {
        this.birthday = birthday;
        this.address = address;
        this.slug = slug;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }
}
