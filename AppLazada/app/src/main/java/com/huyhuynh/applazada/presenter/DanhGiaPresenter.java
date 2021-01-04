package com.huyhuynh.applazada.presenter;

import android.util.Log;

import com.huyhuynh.applazada.model.DanhGia;
import com.huyhuynh.applazada.retrofit.APIUtils;
import com.huyhuynh.applazada.retrofit.DanhGiaAPI;
import com.huyhuynh.applazada.view.impl.ViewDanhGiaActivity;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DanhGiaPresenter {

    ViewDanhGiaActivity viewDanhGiaActivity;

    public DanhGiaPresenter(ViewDanhGiaActivity viewDanhGiaActivity) {
        this.viewDanhGiaActivity = viewDanhGiaActivity;
    }


    public void themDanhGia(DanhGia danhGia){
        DanhGiaAPI danhGiaAPI = APIUtils.danhGiaAPI();
        danhGiaAPI.themDanhGia(danhGia).enqueue(new Callback<Map<String, String>>() {
            @Override
            public void onResponse(Call<Map<String, String>> call, Response<Map<String, String>> response) {
                Map<String,String> map = response.body();
                if (map!=null){
                    String message = map.get("message");
                    if (message.equals("true")) {
                        viewDanhGiaActivity.ketQuaThemDanhGia(true);
                    } else {
                        viewDanhGiaActivity.ketQuaThemDanhGia(false);
                    }
                }
            }

            @Override
            public void onFailure(Call<Map<String, String>> call, Throwable t) {
                Log.d("themDanhGia", "Lỗi: \n"+t.toString());
            }
        });
    }
}
