package com.huyhuynh.applazada.view;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.huyhuynh.applazada.R;
import com.huyhuynh.applazada.model.DanhGia;
import com.huyhuynh.applazada.presenter.DanhGiaPresenter;
import com.huyhuynh.applazada.view.impl.ViewDanhGiaActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DanhGiaActivity extends AppCompatActivity implements ViewDanhGiaActivity {

    Button btnDanhGia;
    TextInputLayout inputTieuDe, inputNoiDung;
    EditText edtTieuDe, edtNoiDung;
    RatingBar ratingBar;
    int masp = 0;
    int sosao = 0;
    DanhGiaPresenter danhGiaPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danh_gia);

        init();
    }

    private void init() {
        btnDanhGia = findViewById(R.id.btnDongYDanhGia_atv);
        edtTieuDe = findViewById(R.id.edTieuDe_atv);
        edtNoiDung = findViewById(R.id.edNoiDung_atv);
        inputNoiDung = findViewById(R.id.input_edNoiDungDanhGia_atv);
        inputTieuDe = findViewById(R.id.input_edTieuDeDanhGia_atv);
        ratingBar = findViewById(R.id.rbDanhGia_atv);

        danhGiaPresenter = new DanhGiaPresenter(this);
        masp = getIntent().getIntExtra("masp", 0);


        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                sosao = (int) rating;
            }
        });

        btnDanhGia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickThemDanhGia();
            }
        });
    }

    private void clickThemDanhGia() {
        String tieuDe = edtTieuDe.getText().toString().trim();
        String noiDung = edtNoiDung.getText().toString().trim();
        if (tieuDe.length()>0&&noiDung.length()>0&&sosao>0){
            String tenthietbi = Build.MODEL;
            String madg = tenthietbi+masp;
            //String madg, String tenthietbi, String tieude, String noidung, String ngaydanhgia, int sosao, int masp
            Calendar cal = Calendar.getInstance();
            Date date = cal.getTime();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            String ngaydanhgia = sdf.format(date);
            DanhGia danhGia = new DanhGia(madg,tenthietbi,tieuDe,noiDung,ngaydanhgia,sosao,masp);
            danhGiaPresenter.themDanhGia(danhGia);
        } else {
            Toast.makeText(DanhGiaActivity.this,"Vui lòng nhập đầy đủ nội dung!",Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void ketQuaThemDanhGia(boolean ketqua) {
        if (true){
            Toast.makeText(DanhGiaActivity.this,"Thêm thành công!!"
                    ,Toast.LENGTH_SHORT).show();
            finish();
        } else {
            Toast.makeText(DanhGiaActivity.this,"Bạn đã đánh giá sản phẩm này rồi :((!"
                    ,Toast.LENGTH_SHORT).show();
        }
    }
}