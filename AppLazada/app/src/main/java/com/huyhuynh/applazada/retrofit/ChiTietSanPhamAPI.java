package com.huyhuynh.applazada.retrofit;


import com.huyhuynh.applazada.model.ChiTietSanPham;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ChiTietSanPhamAPI {

    @GET("getchitietspbyid={masp}")
    Call<List<ChiTietSanPham>> getChiTietSanPhamByMasp(@Path("masp") int masp);
}
