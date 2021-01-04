package com.huyhuynh.applazada.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.huyhuynh.applazada.R;
import com.huyhuynh.applazada.model.ChiTietHoaDon;
import com.huyhuynh.applazada.model.GioHang;
import com.huyhuynh.applazada.model.HoaDon;
import com.huyhuynh.applazada.presenter.HoaDonPresenter;
import com.huyhuynh.applazada.retrofit.HoaDonPayload;
import com.huyhuynh.applazada.view.impl.ViewThanhToanActivity;

import java.util.ArrayList;
import java.util.List;

public class ThanhToanActivity extends AppCompatActivity implements ViewThanhToanActivity {
    EditText edtTenNguoiNhan, edtDiaChi, edtSoDT;
    ImageView imgChuyenKhoan, imgGiaoHangNhanTien;
    Button btnThanhToan;
    CheckBox checkBox;
    Toolbar toolbar;
    LinearLayout layoutThanhToanNhanHang,layoutThanhToanChuyenKhoan;
    boolean checkLoaiThanhToan=true;
    List<GioHang> gioHangList;
    HoaDonPresenter hoaDonPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thanh_toan);

        init();
        control();
    }

    private void control() {
        imgGiaoHangNhanTien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkLoaiThanhToan = true;
                layoutThanhToanNhanHang.setBackgroundColor(Color.argb(100,173,220,185));
                layoutThanhToanChuyenKhoan.setBackgroundColor(Color.argb(100,255,255,255));
            }
        });
        imgChuyenKhoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkLoaiThanhToan = false;
                layoutThanhToanChuyenKhoan.setBackgroundColor(Color.argb(100,173,220,185));
                layoutThanhToanNhanHang.setBackgroundColor(Color.argb(100,255,255,255));
            }
        });
    }

    private void init() {
        edtTenNguoiNhan = findViewById(R.id.edtTenNguoiNhan);
        edtDiaChi = findViewById(R.id.edtDiaChiThanhToan);
        edtSoDT = findViewById(R.id.edtSoDTThanhToan);
        imgChuyenKhoan = findViewById(R.id.imgChuyenKhoan);
        imgGiaoHangNhanTien = findViewById(R.id.imgNhanTienKhiGiaoHang);
        btnThanhToan = findViewById(R.id.btnThanhToan);
        toolbar = findViewById(R.id.toolbarthanhtoan);
        layoutThanhToanNhanHang = findViewById(R.id.layoutThanhToanNhanHang);
        layoutThanhToanChuyenKhoan = findViewById(R.id.layoutThanhToanChuyenKhoan);
        checkBox = findViewById(R.id.cbThoaThuan);

        setSupportActionBar(toolbar);
        hoaDonPresenter = new HoaDonPresenter(this);

        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("bundle");
        if (bundle!=null){
            gioHangList = (List<GioHang>) bundle.get("listSanPham");
        }

        btnThanhToan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                suKienThanhToan();
            }
        });

    }

    private void suKienThanhToan() {
        if (checkDienThongTin()) {
            List<ChiTietHoaDon> chiTietHoaDonList = new ArrayList<>();
            for (GioHang gioHang : gioHangList) {
                ChiTietHoaDon chiTietHoaDon = new ChiTietHoaDon();
                chiTietHoaDon.setMahd(HomeActivity.dangnhap);
                chiTietHoaDon.setMasp(gioHang.getMasp());
                chiTietHoaDon.setSoluong(gioHang.getSoluong());
                chiTietHoaDonList.add(chiTietHoaDon);
            }
            HoaDon hoaDon = new HoaDon();
            String tennguoinhan = edtTenNguoiNhan.getText().toString().trim();
            String diachi = edtDiaChi.getText().toString().trim();
            String sodt = edtSoDT.getText().toString().trim();
            int chuyenkhoan = 0;
            if (!checkLoaiThanhToan) {
                chuyenkhoan = 1;
            }
            hoaDon.setDiachi(diachi);
            hoaDon.setSodt(sodt);
            hoaDon.setTennguoinhan(tennguoinhan);
            hoaDon.setChuyenkhoan(chuyenkhoan);
            hoaDonPresenter.thanhToanHoaDon(hoaDon, chiTietHoaDonList);
        }
    }

    private boolean checkDienThongTin(){
        String tennguoinhan = edtTenNguoiNhan.getText().toString().trim();
        String diachi = edtDiaChi.getText().toString().trim();
        String sodt = edtSoDT.getText().toString().trim();
        if (tennguoinhan.length()<1||diachi.length()<1||sodt.length()<9){
            Toast.makeText(this,"Vui lòng điền đầy đủ thông tin!",Toast.LENGTH_SHORT).show();
            return false;
        } else if (!checkBox.isChecked()){
            Toast.makeText(this,"Vui lòng cam kết thông tin bạn điền là đúng!",Toast.LENGTH_SHORT).show();
        }
        return true;
    }
    @Override
    public void thanhToanHoaDon(boolean kq) {
        if (kq){
            Toast.makeText(this,"Thanh toán hoá đơn thành công!",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(ThanhToanActivity.this,HomeActivity.class);
            startActivity(intent);
            finish();
        } else {
            Toast.makeText(this,"Thanh toán hoá đơn thất bại!",Toast.LENGTH_SHORT).show();
        }
    }
}