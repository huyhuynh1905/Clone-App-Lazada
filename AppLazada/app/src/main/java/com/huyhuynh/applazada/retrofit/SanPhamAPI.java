package com.huyhuynh.applazada.retrofit;

import com.huyhuynh.applazada.model.SanPham;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface SanPhamAPI {

    @GET("timkiemsanpham")
    Call<List<SanPham>> timKiemSanPham(@Query("tentimkiem") String tentimkiem);
}
