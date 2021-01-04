package com.huyhuynh.applazada.retrofit;

import com.huyhuynh.applazada.model.DanhGia;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface DanhGiaAPI {
    @POST("themdanhgia")
    Call<Map<String,String>> themDanhGia(@Body DanhGia danhGia);
    @GET("laydanhgia")
    Call<List<DanhGia>> getDanhGia(@Query("masp") int masp);
}
