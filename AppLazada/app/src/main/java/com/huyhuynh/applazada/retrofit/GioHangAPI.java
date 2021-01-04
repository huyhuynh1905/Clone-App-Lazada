package com.huyhuynh.applazada.retrofit;

import com.huyhuynh.applazada.model.GioHang;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface GioHangAPI {

    @GET(value = "getgiohang")
    Call<List<GioHang>> getAllGioHang(@Query("manv") int manv);

    @POST(value = "themgiohang")
    Call<Map<String,Boolean>> themGioHang(@Body GioHang gioHang);

    @POST(value = "giamsoluonggiohang")
    Call<Map<String,Boolean>> giamSoLuongGioHang(@Body GioHang gioHang);

    //@DELETE(value = "xoagiohang")
    @HTTP(method = "DELETE", path = "xoagiohang", hasBody = true)
    Call<Map<String,Boolean>> xoaGioHang(@Body GioHang gioHang);
}
