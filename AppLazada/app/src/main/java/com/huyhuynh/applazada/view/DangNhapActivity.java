package com.huyhuynh.applazada.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.huyhuynh.applazada.R;
import com.huyhuynh.applazada.adapter.ViewPagerAdapterDangNhap;

public class DangNhapActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;
    Toolbar toolbar;
    ViewPagerAdapterDangNhap viewAdapterDangNhap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_nhap);

        init();
    }

    private void init() {
        tabLayout = findViewById(R.id.tablayoutDangNhap);
        viewPager = findViewById(R.id.viewPagerDangNhap);
        toolbar = findViewById(R.id.toolBar_Dangnhap);

        toolbar.setTitle("Đăng Nhập/Đăng kí");
        setSupportActionBar(toolbar);

        viewAdapterDangNhap = new ViewPagerAdapterDangNhap(getSupportFragmentManager());
        viewPager.setAdapter(viewAdapterDangNhap);
        viewAdapterDangNhap.notifyDataSetChanged();

        tabLayout.setupWithViewPager(viewPager);

    }
}