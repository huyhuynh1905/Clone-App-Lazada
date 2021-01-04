package com.huyhuynh.applazada.presenter;

import android.util.Log;

import com.huyhuynh.applazada.model.GioHang;
import com.huyhuynh.applazada.retrofit.APIUtils;
import com.huyhuynh.applazada.retrofit.GioHangAPI;
import com.huyhuynh.applazada.view.HomeActivity;
import com.huyhuynh.applazada.view.impl.ChiTietSanPhamActivityView;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GioHangPresenter {
    ChiTietSanPhamActivityView chiTietSanPhamActivityView;

    public GioHangPresenter() {
        getAllGioHang(HomeActivity.dangnhap);
    }

    public GioHangPresenter(ChiTietSanPhamActivityView chiTietSanPhamActivityVieư) {
        this.chiTietSanPhamActivityView = chiTietSanPhamActivityVieư;
    }


    public void themGioHang(GioHang gioHang){
        GioHangAPI gioHangAPI = APIUtils.gioHangAPI();
        gioHangAPI.themGioHang(gioHang).enqueue(new Callback<Map<String, Boolean>>() {
            @Override
            public void onResponse(Call<Map<String, Boolean>> call, Response<Map<String, Boolean>> response) {
                Map<String,Boolean> map = response.body();
                if (map!=null){
                    Log.d("themGioHang","Có data trả về!");
                    boolean kq = map.get("message");
                    chiTietSanPhamActivityView.themGioHang(kq);
                }else {
                    Log.d("themGioHang","Ko có data trả về!");
                }
            }

            @Override
            public void onFailure(Call<Map<String, Boolean>> call, Throwable t) {
                Log.d("themGioHang","Lỗi: \n"+t.toString());
            }
        });
    }

    public void getAllGioHang(int manv){
        GioHangAPI gioHangAPI = APIUtils.gioHangAPI();
        gioHangAPI.getAllGioHang(manv).enqueue(new Callback<List<GioHang>>() {
            @Override
            public void onResponse(Call<List<GioHang>> call, Response<List<GioHang>> response) {
                List<GioHang> gioHangList = response.body();
                if (gioHangList!=null){
                    Log.d("getAllGioHang","Có data trả về!");
                    //
                    chiTietSanPhamActivityView.getAllGioHang(gioHangList);
                } else {
                    Log.d("getAllGioHang","Ko có data trả về!");
                    chiTietSanPhamActivityView.getAllGioHang(null);
                }
            }

            @Override
            public void onFailure(Call<List<GioHang>> call, Throwable t) {
                Log.d("getAllGioHang","Lỗi: \n"+t.toString());
            }
        });
    }
}
