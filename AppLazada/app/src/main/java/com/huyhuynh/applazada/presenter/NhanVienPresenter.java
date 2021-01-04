package com.huyhuynh.applazada.presenter;

import android.util.Log;

import com.huyhuynh.applazada.model.NhanVien;
import com.huyhuynh.applazada.presenter.impl.INhanVienPresenter;
import com.huyhuynh.applazada.retrofit.APIUtils;
import com.huyhuynh.applazada.retrofit.NhanVienAPI;
import com.huyhuynh.applazada.view.ChiTietSanPhamActivity;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NhanVienPresenter implements INhanVienPresenter {

    //private Map<String,String> ketquadangki=new HashMap<>();
    /*
    @Override
    public NhanVien dangNhap(String email, String matkhau) {
        NhanVienAPI nhanVienAPI = APIUtils.nhanVienAPI();
        nhanVienAPI.dangNhap(email,matkhau).enqueue(new Callback<NhanVien>() {
            @Override
            public void onResponse(Call<NhanVien> call, Response<NhanVien> response) {
                nhanVien = response.body();
                if (nhanVien!=null) {
                    Log.d("dangNhapServer", nhanVien.toString());
                } else {
                    Log.d("dangNhapServer", "Lỗi null nhân viên trả về");
                }
            }

            @Override
            public void onFailure(Call<NhanVien> call, Throwable t) {
                Log.d("dangNhapServer","Lỗi: \n"+t.toString());
            }
        });
        return nhanVien;
    }
    */
    /*
    @Override
    public Map<String, String> dangKi(String tennv, String email, String matkhau, boolean nhanemail) {
        NhanVienAPI nhanVienAPI = APIUtils.nhanVienAPI();
        nhanVienAPI.dangKi(tennv, email, matkhau, nhanemail).enqueue(new Callback<Map<String, String>>() {
            @Override
            public void onResponse(Call<Map<String,String>> call, Response<Map<String,String>> response) {
                ketquadangki = response.body();
                String ketqua = ketquadangki.get("Message");
                Log.d("dangKi","Kết quả: "+ketqua);
            }

            @Override
            public void onFailure(Call<Map<String,String>> call, Throwable t) {
                Log.d("dangKi","Lỗi: \n"+t.toString());
            }
        });
        return ketquadangki;
    }
     */
}
