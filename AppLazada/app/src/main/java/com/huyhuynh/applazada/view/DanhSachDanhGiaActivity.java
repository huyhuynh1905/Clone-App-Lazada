package com.huyhuynh.applazada.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.huyhuynh.applazada.R;
import com.huyhuynh.applazada.adapter.DanhGiaAdapter;
import com.huyhuynh.applazada.model.DanhGia;

import java.util.List;

public class DanhSachDanhGiaActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    DanhGiaAdapter danhGiaAdapter;
    List<DanhGia> danhGiaList;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danh_sach_danh_gia);
        init();
    }

    private void init() {
        recyclerView = findViewById(R.id.recyclerDanhSachDanhGia);
        toolbar = findViewById(R.id.toolBar_danhsachdanhgia);
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("bundleDanhGia");
        danhGiaList = (List<DanhGia>) bundle.getSerializable("danhGiaList");
        if (danhGiaList!=null){
            danhGiaAdapter = new DanhGiaAdapter(this,danhGiaList);
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(danhGiaAdapter);
            danhGiaAdapter.notifyDataSetChanged();
        } else {
            Toast.makeText(this,"Không có bình luận nào cho sản phẩm này!",Toast.LENGTH_SHORT).show();
        }

    }
}