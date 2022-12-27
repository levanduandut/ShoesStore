package com.example.shoesstore.retrofit;

import com.example.shoesstore.model.Products;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiNewProduct {
    Gson gson = new GsonBuilder()
            .setDateFormat("yyyy-MM-dd HH:mm:ss")
            .create();
    ApiNewProduct apiNewProduct = new Retrofit.Builder()
            .baseUrl("https://truong45truong.pythonanywhere.com/api/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(ApiNewProduct.class);
    @GET("product")
    Call<List<Products>> getListProduct (@Query("") String key);
}
