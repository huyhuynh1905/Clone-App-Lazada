package com.huyhuynh.applazada.retrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static Retrofit retrofit = null;
    public static Retrofit getRetrofit(String baseUrrl){
        Gson gsonn = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd HH:mm:ss")
                .create();
        retrofit = new Retrofit.Builder()
                .baseUrl(baseUrrl)
                .addConverterFactory(GsonConverterFactory.create(gsonn))
                .build();
        return retrofit;
    }
}
