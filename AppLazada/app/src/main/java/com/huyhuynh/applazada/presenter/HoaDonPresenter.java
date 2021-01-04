package com.huyhuynh.applazada.presenter;

import android.util.Log;

import com.google.gson.Gson;
import com.huyhuynh.applazada.model.ChiTietHoaDon;
import com.huyhuynh.applazada.model.HoaDon;
import com.huyhuynh.applazada.retrofit.APIUtils;
import com.huyhuynh.applazada.retrofit.HoaDonAPI;
import com.huyhuynh.applazada.retrofit.HoaDonPayload;
import com.huyhuynh.applazada.view.impl.ViewThanhToanActivity;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HoaDonPresenter {

    ViewThanhToanActivity thanhToanView;

    public HoaDonPresenter(ViewThanhToanActivity thanhToanView) {
        this.thanhToanView = thanhToanView;
    }

    public void thanhToanHoaDon(HoaDon hoaDon, List<ChiTietHoaDon> chiTietHoaDonList){
        HoaDonPayload hoaDonPayload = new HoaDonPayload(hoaDon,chiTietHoaDonList);
        HoaDonAPI hoaDonAPI = APIUtils.hoaDonAPI();
        hoaDonAPI.themHoaDon(hoaDonPayload).enqueue(new Callback<Map<String, Boolean>>() {
            @Override
            public void onResponse(Call<Map<String, Boolean>> call, Response<Map<String, Boolean>> response) {
                Map<String,Boolean> map = response.body();
                if (map!=null){
                    Log.d("thanhToanHoaDon","Có data trả về!");
                    boolean kq = map.get("message");
                    thanhToanView.thanhToanHoaDon(kq);
                }else {
                    Log.d("thanhToanHoaDon","Ko có data trả về!");
                }
            }

            @Override
            public void onFailure(Call<Map<String, Boolean>> call, Throwable t) {
                Log.d("thanhToanHoaDon","Lỗi: \n"+t.toString());
            }
        });

    }
}
