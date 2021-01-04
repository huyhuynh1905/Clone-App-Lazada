package com.huyhuynh.applazada.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.huyhuynh.applazada.R;
import com.huyhuynh.applazada.adapter.DanhMucSanPhamAdapter;
import com.huyhuynh.applazada.model.SanPham;
import com.huyhuynh.applazada.presenter.DanhMucSanPhamPresenter;
import com.huyhuynh.applazada.view.impl.DanhMucSanPhamView;

import java.util.List;

public class DanhMucSanPhamActivity extends AppCompatActivity implements DanhMucSanPhamView {

    RecyclerView rcvDanhMuc;
    Button btnLoc, btnSapxep, btnDoiKieuHienThiRcv;
    Toolbar toolbar;
    int math;
    String tenth;
    DanhMucSanPhamPresenter danhMucSanPhamPresenter;
    DanhMucSanPhamAdapter danhMucSanPhamAdapter;
    RecyclerView.LayoutManager layoutManager;
    boolean changrcv = false;
    List<SanPham> sanPhamList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danh_muc_san_pham);
        init();
        danhMucSanPhamPresenter = new DanhMucSanPhamPresenter(this);
        danhMucSanPhamPresenter.loadDanhSachSanPhamTheoThuongHieu(0);
    }

    private void init() {
        rcvDanhMuc = findViewById(R.id.rcvHienThiDanhMucSp);
        btnLoc = findViewById(R.id.btnLocDanhMuc);
        btnSapxep = findViewById(R.id.btnSapXepDanhMuc);
        btnDoiKieuHienThiRcv = findViewById(R.id.btnThayDoiTrangThaiRecycler);
        toolbar = findViewById(R.id.toolbarHienThiDanhMucSp);

        //lấy giá trị
        Intent intent = getIntent();
        if (intent!=null){
            math = intent.getIntExtra("math",-1);
            tenth = intent.getStringExtra("tenth");
            Log.d("getIntent","Mã th: "+math);
            toolbar.setTitle(tenth);
        }


        setSupportActionBar(toolbar);
        btnDoiKieuHienThiRcv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!changrcv){
                    changrcv=true;
                    danhMucSanPhamAdapter = new DanhMucSanPhamAdapter(DanhMucSanPhamActivity.this,sanPhamList,changrcv);
                    danhMucSanPhamAdapter.notifyDataSetChanged();
                    layoutManager = new GridLayoutManager(DanhMucSanPhamActivity.this,1);
                    rcvDanhMuc.setAdapter(danhMucSanPhamAdapter);
                    rcvDanhMuc.setLayoutManager(layoutManager);
                } else {
                    changrcv=false;
                    danhMucSanPhamAdapter = new DanhMucSanPhamAdapter(DanhMucSanPhamActivity.this,sanPhamList,changrcv);
                    danhMucSanPhamAdapter.notifyDataSetChanged();
                    layoutManager = new GridLayoutManager(DanhMucSanPhamActivity.this,2);
                    rcvDanhMuc.setAdapter(danhMucSanPhamAdapter);
                    rcvDanhMuc.setLayoutManager(layoutManager);
                }
            }
        });
    }

    @Override
    public void LayDanhSachSanPham(List<SanPham> sanPhamList) {
        this.sanPhamList = sanPhamList;
        danhMucSanPhamAdapter = new DanhMucSanPhamAdapter(this,sanPhamList,changrcv);
        danhMucSanPhamAdapter.notifyDataSetChanged();
        layoutManager = new GridLayoutManager(this,2);
        rcvDanhMuc.setAdapter(danhMucSanPhamAdapter);
        rcvDanhMuc.setLayoutManager(layoutManager);
    }
}