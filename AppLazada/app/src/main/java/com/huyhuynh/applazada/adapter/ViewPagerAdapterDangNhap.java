package com.huyhuynh.applazada.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.huyhuynh.applazada.fragment.fragmentdangnhap.FragmentDangKi;
import com.huyhuynh.applazada.fragment.fragmentdangnhap.FragmentDangNhap;

public class ViewPagerAdapterDangNhap extends FragmentPagerAdapter {


    public ViewPagerAdapterDangNhap(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                FragmentDangNhap fragmetnDangNhap = new FragmentDangNhap();
                return fragmetnDangNhap;
            case 1:
                FragmentDangKi fragmentDangKi = new FragmentDangKi();
                return fragmentDangKi;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "Đăng Nhập";
            case 1:

                return "Đăng Kí";
            default:
                return null;
        }
    }
}
