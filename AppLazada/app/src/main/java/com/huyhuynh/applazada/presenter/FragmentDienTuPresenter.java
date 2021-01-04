package com.huyhuynh.applazada.presenter;

import android.content.Context;
import android.util.Log;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.huyhuynh.applazada.fragment.fragmenthome.FragmentDienTu;
import com.huyhuynh.applazada.fragment.fragmenthome.viewinterface.FragmenDienTuView;
import com.huyhuynh.applazada.model.SanPham;
import com.huyhuynh.applazada.model.ThuongHieu;
import com.huyhuynh.applazada.retrofit.APIUtils;
import com.huyhuynh.applazada.retrofit.FragmentDienTuAPI;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentDienTuPresenter {
    Context context;
    RecyclerView.LayoutManager layoutManager;
    static List<ThuongHieu> listThuongHieus;
    static List<SanPham> sanPhamList;
    FragmenDienTuView dienTuFragmentView;

    public FragmentDienTuPresenter(Context context, FragmenDienTuView dienTuFragmentView) {
        this.context = context;
        this.dienTuFragmentView = dienTuFragmentView;

    }

    public void getAllDienTu(){
        FragmentDienTuAPI dienTuAPI = APIUtils.dienTuAPI();
        dienTuAPI.getAllThuongHieu().enqueue(new Callback<List<ThuongHieu>>() {
            @Override
            public void onResponse(Call<List<ThuongHieu>> call, Response<List<ThuongHieu>> response) {
                listThuongHieus = response.body();
                if (listThuongHieus!=null) {
                    dienTuFragmentView.hienThiDanhSachThuongHieu(listThuongHieus);
                    Log.d("getAllDienTu", "List Thương Hiệu Có Data");
                } else {
                    Log.d("getAllDienTu", "List Thương Hiệu Không Có Data");
                }
            }

            @Override
            public void onFailure(Call<List<ThuongHieu>> call, Throwable t) {
                Log.d("getAllDienTu", "Lỗi: \n"+t.toString());
            }
        });
        dienTuAPI.getAllSanPham().enqueue(new Callback<List<SanPham>>() {
            @Override
            public void onResponse(Call<List<SanPham>> call, Response<List<SanPham>> response) {
                sanPhamList = response.body();
                if (sanPhamList!=null){
                    dienTuFragmentView.hienThiDanhSachSanPham(sanPhamList);
                    Log.d("getAllDienTu", "List Sản Phẩm Có Data");
                } else {
                    Log.d("getAllDienTu","Sản Phẩm Null");
                }
            }

            @Override
            public void onFailure(Call<List<SanPham>> call, Throwable t) {
                Log.d("getAllDienTu","Lỗi: \n"+t.toString());
            }
        });
        if (listThuongHieus==null) {
            Log.d("getAllDienTu", "Null rồi");
        }
    }

}
