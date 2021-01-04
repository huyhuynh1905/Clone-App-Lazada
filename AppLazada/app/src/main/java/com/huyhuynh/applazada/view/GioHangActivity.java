package com.huyhuynh.applazada.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.huyhuynh.applazada.R;
import com.huyhuynh.applazada.adapter.GioHangAdapter;
import com.huyhuynh.applazada.model.GioHang;
import com.huyhuynh.applazada.retrofit.APIUtils;
import com.huyhuynh.applazada.retrofit.GioHangAPI;
import com.huyhuynh.applazada.view.impl.GioHangView;

import java.io.Serializable;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GioHangActivity extends AppCompatActivity implements GioHangView {

    RecyclerView recyclerView;
    Toolbar toolbar;
    Button btnMuaNgay;
    List<GioHang> gioHangList;
    GioHangAdapter gioHangAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gio_hang);

        init();
    }

    private void init() {
        btnMuaNgay = findViewById(R.id.btnMuaNgay_gh);
        recyclerView = findViewById(R.id.recyclerGioHang_gh);
        toolbar = findViewById(R.id.toolbar_gh);

        final Intent intent = getIntent();
        final Bundle bundle = intent.getBundleExtra("bundle");
        if (bundle!=null){
            gioHangList = (List<GioHang>) bundle.get("listGioHang");
            gioHangAdapter = new GioHangAdapter(this,gioHangList);
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(gioHangAdapter);
            gioHangAdapter.notifyDataSetChanged();
        } else {
            layDanhSachGioHang();
        }

        btnMuaNgay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (gioHangList.size()>0) {
                    Intent intentThanhToan = new Intent(GioHangActivity.this, ThanhToanActivity.class);
                    Bundle bundleHoaDon = new Bundle();
                    bundleHoaDon.putSerializable("listSanPham", (Serializable) gioHangList);
                    intentThanhToan.putExtra("bundle", bundleHoaDon);
                    startActivity(intentThanhToan);
                } else {
                    Toast.makeText(GioHangActivity.this,"Giỏ Hàng Trống!",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void hienThiDanhSachGioHang(List<GioHang> gioHangList) {
        gioHangAdapter = new GioHangAdapter(this,gioHangList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(gioHangAdapter);
        gioHangAdapter.notifyDataSetChanged();
    }


    public void layDanhSachGioHang(){
        GioHangAPI gioHangAPI = APIUtils.gioHangAPI();
        gioHangAPI.getAllGioHang(HomeActivity.dangnhap).enqueue(new Callback<List<GioHang>>() {
            @Override
            public void onResponse(Call<List<GioHang>> call, Response<List<GioHang>> response) {
                gioHangList = response.body();
                if (gioHangList!=null){
                    Log.d("layDanhSachGioHang","Có data trả về!");
                    //
                    hienThiDanhSachGioHang(gioHangList);
                } else {
                    Log.d("layDanhSachGioHang","Ko có data trả về!");
                }
            }

            @Override
            public void onFailure(Call<List<GioHang>> call, Throwable t) {
                Log.d("layDanhSachGioHang","Lỗi: \n"+t.toString());
            }
        });
    }

}