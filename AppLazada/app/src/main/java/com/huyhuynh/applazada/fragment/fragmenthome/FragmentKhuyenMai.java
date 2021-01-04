package com.huyhuynh.applazada.fragment.fragmenthome;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.huyhuynh.applazada.R;
import com.huyhuynh.applazada.adapter.FragmentDienTuAdapter;
import com.huyhuynh.applazada.fragment.fragmenthome.viewinterface.FragmenDienTuView;
import com.huyhuynh.applazada.model.DienTu;
import com.huyhuynh.applazada.model.SanPham;
import com.huyhuynh.applazada.model.ThuongHieu;
import com.huyhuynh.applazada.presenter.FragmentDienTuPresenter;

import java.util.ArrayList;
import java.util.List;

public class FragmentKhuyenMai extends Fragment implements FragmenDienTuView {

    RecyclerView recyclerView;
    List<DienTu> dienTuList;
    FragmentDienTuPresenter presenterDienTu;
    DienTu dienTu;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_khuyenmai,container,false);
        init(view);
        dienTuList = new ArrayList<>();
        presenterDienTu = new FragmentDienTuPresenter(getContext(),this);
        presenterDienTu.getAllDienTu();
        return view;
    }

    private void init(View view) {
        recyclerView = view.findViewById(R.id.recycle_DienTuFragment);

        dienTu = new DienTu();
    }

    @Override
    public void hienThiDanhSachThuongHieu(List<ThuongHieu> listThuongHieus) {
        dienTu.setThuongHieuList(listThuongHieus);
        loadList();
    }

    @Override
    public void hienThiDanhSachSanPham(List<SanPham> sanPhamList) {
        dienTu.setSanPhamList(sanPhamList);
        loadList();
    }


    public void loadList(){
        if (dienTu.getSanPhamList()!=null&&dienTu.getThuongHieuList()!=null){
            dienTuList.add(dienTu);
            dienTuList.add(dienTu);
            dienTuList.add(dienTu);
            FragmentDienTuAdapter dienTuAdapter = new FragmentDienTuAdapter(getContext(),dienTuList);
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(dienTuAdapter);
            dienTuAdapter.notifyDataSetChanged();
        }
    }
}
