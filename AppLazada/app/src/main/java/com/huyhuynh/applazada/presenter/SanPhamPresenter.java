package com.huyhuynh.applazada.presenter;

import android.util.Log;

import com.huyhuynh.applazada.model.SanPham;
import com.huyhuynh.applazada.retrofit.APIUtils;
import com.huyhuynh.applazada.retrofit.SanPhamAPI;
import com.huyhuynh.applazada.view.impl.ViewTimKiemSanPham;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SanPhamPresenter {

    ViewTimKiemSanPham timKiemSanPhamView;

    public SanPhamPresenter(ViewTimKiemSanPham timKiemSanPhamView) {
        this.timKiemSanPhamView = timKiemSanPhamView;
    }

    public void timKiemSanPham(String tentimkiem){
        SanPhamAPI sanPhamAPI = APIUtils.sanPhamAPI();
        sanPhamAPI.timKiemSanPham(tentimkiem).enqueue(new Callback<List<SanPham>>() {
            @Override
            public void onResponse(Call<List<SanPham>> call, Response<List<SanPham>> response) {
                List<SanPham> sanPhams = response.body();
                if (sanPhams!=null){
                    timKiemSanPhamView.timKiemSanPhamThanhCong(sanPhams);
                } else {
                    timKiemSanPhamView.timKiemSanPhamThatBai();
                }
            }

            @Override
            public void onFailure(Call<List<SanPham>> call, Throwable t) {
                Log.d("timKiemSanPham","Lỗi: \n"+t.toString());
            }
        });
    }
}
