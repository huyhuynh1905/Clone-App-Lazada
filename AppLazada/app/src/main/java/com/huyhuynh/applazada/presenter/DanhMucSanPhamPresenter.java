package com.huyhuynh.applazada.presenter;

import android.util.Log;

import com.huyhuynh.applazada.model.SanPham;
import com.huyhuynh.applazada.retrofit.APIUtils;
import com.huyhuynh.applazada.retrofit.FragmentDienTuAPI;
import com.huyhuynh.applazada.retrofit.LoaiSanPhamAPI;
import com.huyhuynh.applazada.view.impl.DanhMucSanPhamView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DanhMucSanPhamPresenter {
    DanhMucSanPhamView sanPhamView;
    List<SanPham> sanPhamList;

    public DanhMucSanPhamPresenter(DanhMucSanPhamView sanPhamView) {
        this.sanPhamView = sanPhamView;
    }

    public void loadDanhSachSanPhamTheoThuongHieu(int math){ //thực tế sẽ xài đến math, nhưng do database ko có nhiều sp
        FragmentDienTuAPI dienTuAPI = APIUtils.dienTuAPI();
        dienTuAPI.getAllSanPham().enqueue(new Callback<List<SanPham>>() {
            @Override
            public void onResponse(Call<List<SanPham>> call, Response<List<SanPham>> response) {
                sanPhamList = response.body();
                if (sanPhamList!=null){
                    sanPhamView.LayDanhSachSanPham(sanPhamList);
                } else {
                    Log.d("loadDanhSachSanPhamTheoThuongHieu","Null List Rồi");
                }
            }

            @Override
            public void onFailure(Call<List<SanPham>> call, Throwable t) {

            }
        });
    }
}
