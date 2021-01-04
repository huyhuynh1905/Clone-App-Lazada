package com.huyhuynh.applazada.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.huyhuynh.applazada.fragment.fragmenthome.FragmentDienTu;
import com.huyhuynh.applazada.fragment.fragmenthome.FragmentKhuyenMai;
import com.huyhuynh.applazada.fragment.fragmenthome.FragmentLamDep;
import com.huyhuynh.applazada.fragment.fragmenthome.FragmentMeVaBe;
import com.huyhuynh.applazada.fragment.fragmenthome.FragmentNhaCuaDoiSong;
import com.huyhuynh.applazada.fragment.fragmenthome.FragmentNoiBat;
import com.huyhuynh.applazada.fragment.fragmenthome.FragmentTheThao;
import com.huyhuynh.applazada.fragment.fragmenthome.FragmentThoiTrang;
import com.huyhuynh.applazada.fragment.fragmenthome.FragmentThuongHieu;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    List<Fragment> fragments = new ArrayList<>();
    List<String> titleList = new ArrayList<>();

    public ViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
        fragments.add(new FragmentNoiBat());
        fragments.add(new FragmentKhuyenMai());
        fragments.add(new FragmentDienTu());
        fragments.add(new FragmentNhaCuaDoiSong());
        fragments.add(new FragmentMeVaBe());
        fragments.add(new FragmentLamDep());
        fragments.add(new FragmentThoiTrang());
        fragments.add(new FragmentTheThao());
        fragments.add(new FragmentThuongHieu());

        titleList.add("Nổi bật");
        titleList.add("Chương trình khuyến mãi");
        titleList.add("Điện tử");
        titleList.add("Nhà cửa và đời sống");
        titleList.add("Mẹ và bé");
        titleList.add("Làm đẹp");
        titleList.add("Thời trang");
        titleList.add("Thể thao");
        titleList.add("Thương hiệu");

    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titleList.get(position);
    }
}
