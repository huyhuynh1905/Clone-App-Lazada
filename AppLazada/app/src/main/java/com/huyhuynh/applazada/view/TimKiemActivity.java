package com.huyhuynh.applazada.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.MenuItemCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import com.huyhuynh.applazada.R;
import com.huyhuynh.applazada.adapter.DanhMucSanPhamAdapter;
import com.huyhuynh.applazada.adapter.SanPhamTopAdapter;
import com.huyhuynh.applazada.model.SanPham;
import com.huyhuynh.applazada.presenter.SanPhamPresenter;
import com.huyhuynh.applazada.view.impl.ViewTimKiemSanPham;

import java.util.List;

public class TimKiemActivity extends AppCompatActivity implements ViewTimKiemSanPham {
    Toolbar toolbarTk;
    RecyclerView rcvTimKiem;
    List<SanPham> sanPhamList;
    SanPhamPresenter sanPhamPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tim_kiem);
        init();
    }

    private void init() {
        toolbarTk = findViewById(R.id.toolbarTk);
        rcvTimKiem = findViewById(R.id.recyclerTimKiem);
        sanPhamPresenter = new SanPhamPresenter(this);

        setSupportActionBar(toolbarTk);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_timkiem,menu);

        MenuItem itSearch = menu.findItem(R.id.itSearch);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(itSearch);
        searchView.setIconified(false);//android.support.v7.appcompat.R.id.search_src_text | androidx.appcompat.widget.SearchView
        EditText searchEditText = searchView.findViewById(androidx.appcompat.R.id.search_src_text);
        searchEditText.setTextColor(getResources().getColor(R.color.colorWhite));
        searchEditText.setHintTextColor(getResources().getColor(R.color.colorWhite));
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                sanPhamPresenter.timKiemSanPham(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        return true;
    }

    @Override
    public void timKiemSanPhamThanhCong(List<SanPham> sanPhamList) {
        this.sanPhamList = sanPhamList;
        DanhMucSanPhamAdapter topAdapter = new DanhMucSanPhamAdapter(this,sanPhamList,true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        rcvTimKiem.setLayoutManager(layoutManager);
        rcvTimKiem.setAdapter(topAdapter);
        topAdapter.notifyDataSetChanged();
    }

    @Override
    public void timKiemSanPhamThatBai() {

    }
}