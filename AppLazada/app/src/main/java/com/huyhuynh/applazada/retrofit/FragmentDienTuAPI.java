package com.huyhuynh.applazada.retrofit;

import com.huyhuynh.applazada.model.SanPham;
import com.huyhuynh.applazada.model.ThuongHieu;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface FragmentDienTuAPI {

    @GET("getallthuonghieu")
    Call<List<ThuongHieu>> getAllThuongHieu();

    @GET("getallsanpham")
    Call<List<SanPham>> getAllSanPham();
}
