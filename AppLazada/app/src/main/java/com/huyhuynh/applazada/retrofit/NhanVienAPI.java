package com.huyhuynh.applazada.retrofit;

import com.huyhuynh.applazada.model.NhanVien;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface NhanVienAPI {

    @POST("dangnhap")
    Call<NhanVien> dangNhap(@Query("email") String email , @Query("matkhau") String matkhau);

    @POST("dangki")
    Call<Map<String,String>> dangKi(@Query("tennv") String tennv, @Query("email") String email, @Query("matkhau") String matkhau, @Query("nhanemail") boolean nhanemail);

    @GET("laytennhanvien")
    Call<Map<String,String>> laytenNhanVien(@Query("manv") int manv);

}
