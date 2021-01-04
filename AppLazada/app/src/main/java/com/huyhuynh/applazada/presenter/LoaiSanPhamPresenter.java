package com.huyhuynh.applazada.presenter;

import android.os.Bundle;
import android.util.Log;

import com.facebook.AccessToken;
import com.huyhuynh.applazada.model.LoaiSanPham;
import com.huyhuynh.applazada.model.ModelDangNhap;
import com.huyhuynh.applazada.presenter.impl.ILoaiSanPhamPresenter;
import com.huyhuynh.applazada.retrofit.APIUtils;
import com.huyhuynh.applazada.retrofit.LoaiSanPhamAPI;
import com.huyhuynh.applazada.view.impl.HomeActivityView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoaiSanPhamPresenter implements ILoaiSanPhamPresenter {

    public HomeActivityView homeActivityView;

    public LoaiSanPhamPresenter(HomeActivityView homeActivityView) {
        this.homeActivityView = homeActivityView;
    }

    @Override
    public void layDanhSachMenu(int maloaicha) {
        LoaiSanPhamAPI loaiSanPhamAPI = APIUtils.getDataLoaiSanPham();
        loaiSanPhamAPI.getLoaiSPByMaLoaiCha(maloaicha).enqueue(new Callback<List<LoaiSanPham>>() {
            @Override
            public void onResponse(Call<List<LoaiSanPham>> call, Response<List<LoaiSanPham>> response) {
                List<LoaiSanPham> loaiSanPhams = response.body();
                homeActivityView.hienThiDanhSachMenu(loaiSanPhams);
            }
            @Override
            public void onFailure(Call<List<LoaiSanPham>> call, Throwable t) {
                Log.d("layDanhSachMenu","Lỗi"+t.toString());
            }
        });
    }

    @Override
    public AccessToken layTenNguoiDungFacebook() {
        ModelDangNhap modelDangNhap = new ModelDangNhap();
        AccessToken accessToken = modelDangNhap.layTokenFacebook();

        return accessToken;
    }

}
