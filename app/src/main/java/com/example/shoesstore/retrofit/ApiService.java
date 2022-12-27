package com.example.shoesstore.retrofit;

import com.example.shoesstore.model.Cart;
import com.example.shoesstore.model.Register;
import com.example.shoesstore.model.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiService {
    Gson gson = new GsonBuilder()
            .setDateFormat("yyyy-MM-dd HH:mm:ss")
            .create();
    ApiService apiService = new Retrofit.Builder()
            .baseUrl("https://truong45truong.pythonanywhere.com/api/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(ApiService.class);
    @GET("user/")
    Call<List<User>> getListUsers (@Query("username") String key,
                                   @Query("password") String keypass);

    @POST("user/")
    Call<Register> sendRegister(@Body Register register);

    @GET("detail-order/")
    Call<List<Cart>> getListCart (@Query("slug") String keySlug);

}
