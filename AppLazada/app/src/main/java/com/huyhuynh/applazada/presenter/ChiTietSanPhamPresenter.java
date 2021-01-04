package com.huyhuynh.applazada.presenter;

import android.util.Log;

import com.huyhuynh.applazada.model.ChiTietSanPham;
import com.huyhuynh.applazada.model.DanhGia;
import com.huyhuynh.applazada.retrofit.APIUtils;
import com.huyhuynh.applazada.retrofit.ChiTietSanPhamAPI;
import com.huyhuynh.applazada.retrofit.DanhGiaAPI;
import com.huyhuynh.applazada.view.impl.ChiTietSanPhamActivityView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChiTietSanPhamPresenter {
    ChiTietSanPhamActivityView chiTietSanPhamActivityView;
    List<ChiTietSanPham> chiTietSanPhamList;

    public ChiTietSanPhamPresenter(ChiTietSanPhamActivityView chiTietSanPhamActivityView ){
        this.chiTietSanPhamActivityView = chiTietSanPhamActivityView;
    }
    public void layDanhSachDanhGia(final int masp){
        DanhGiaAPI danhGiaAPI = APIUtils.danhGiaAPI();
        danhGiaAPI.getDanhGia(masp).enqueue(new Callback<List<DanhGia>>() {
            @Override
            public void onResponse(Call<List<DanhGia>> call, Response<List<DanhGia>> response) {
                List<DanhGia> danhGiaList = response.body();
                if (danhGiaList!=null){
                    chiTietSanPhamActivityView.getAllDanhGia(danhGiaList);
                    Log.d("layDanhSachDanhGia","Có data!");
                } else {
                    Log.d("layDanhSachDanhGia","Ko có data! "+masp);
                }
            }

            @Override
            public void onFailure(Call<List<DanhGia>> call, Throwable t) {
                Log.d("layDanhSachDanhGia","Lỗi: \n"+t.toString());
            }
        });
    }
    public void getChiTietSanPhamByMasp(int masp){
        ChiTietSanPhamAPI chiTietSanPhamAPI = APIUtils.chiTietSanPhamAPI();
        chiTietSanPhamAPI.getChiTietSanPhamByMasp(1).enqueue(new Callback<List<ChiTietSanPham>>() {
            @Override
            public void onResponse(Call<List<ChiTietSanPham>> call, Response<List<ChiTietSanPham>> response) {
                chiTietSanPhamList = response.body();
                if (chiTietSanPhamList!=null){
                    Log.d("getChiTietSanPhamByMasp","Có data");
                    chiTietSanPhamActivityView.loadThongTinSanPham(chiTietSanPhamList);
                } else {
                    Log.d("getChiTietSanPhamByMasp","Có data");
                }
            }

            @Override
            public void onFailure(Call<List<ChiTietSanPham>> call, Throwable t) {
                Log.d("getChiTietSanPhamByMasp","Lỗi: \n"+t.toString());
            }
        });
    }
}
