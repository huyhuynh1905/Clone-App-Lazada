package com.huyhuynh.applazada.retrofit;

import com.huyhuynh.applazada.model.LoaiSanPham;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface LoaiSanPhamAPI {

    @GET("getbymaloaicha={maloaicha}")
    Call<List<LoaiSanPham>> getLoaiSPByMaLoaiCha(@Path("maloaicha") int maloaicha);

    @GET("getbymaloaisp={maloaisp}")
    Call<List<LoaiSanPham>> getLoaiSPByMaLoaiSp(@Path("maloaisp") int maloaisp);

    @GET("getloaisanpham")
    Call<List<LoaiSanPham>> getAllLoaiSp();
}
