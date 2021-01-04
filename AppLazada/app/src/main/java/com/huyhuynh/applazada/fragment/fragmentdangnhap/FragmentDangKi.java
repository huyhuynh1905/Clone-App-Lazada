package com.huyhuynh.applazada.fragment.fragmentdangnhap;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SwitchCompat;
import androidx.fragment.app.Fragment;

import com.huyhuynh.applazada.R;
import com.huyhuynh.applazada.presenter.NhanVienPresenter;
import com.huyhuynh.applazada.retrofit.APIUtils;
import com.huyhuynh.applazada.retrofit.NhanVienAPI;

import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentDangKi extends Fragment implements View.OnClickListener {

    EditText edtTennv, edtEmail, edtMatkhau, edtNhapLaiMatkhau;
    Button btnDangKi;
    SwitchCompat switchThongBao;
    NhanVienPresenter nhanVienPresenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dangki,container,false);
        init(view);
        btnDangKi.setOnClickListener(this);
        return view;
    }

    private void init(View view) {
        edtTennv = view.findViewById(R.id.edtHoTenDk);
        edtEmail = view.findViewById(R.id.edtEmailDk);
        edtMatkhau = view.findViewById(R.id.edtPassDk);
        edtNhapLaiMatkhau = view.findViewById(R.id.edtNhapLaiPassDk);
        btnDangKi = view.findViewById(R.id.btnDangKi);
        switchThongBao = view.findViewById(R.id.switchThongBao);
        nhanVienPresenter = new NhanVienPresenter();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnDangKi:
                Log.d("dangKi","Đã nhấn button Đăng kí!");
                xuLiDangKi();
                break;
            default:
                break;
        }
    }


    private void xuLiDangKi() {
        String tennv = edtTennv.getText().toString().trim();
        String email = edtEmail.getText().toString().trim();
        String matkhau = edtMatkhau.getText().toString().trim();
        String matkhaunhaplai = edtNhapLaiMatkhau.getText().toString().trim();
        boolean nhanemail = false;
        if (switchThongBao.isChecked()){
            Log.d("dangKi","Switch thông báo: Nhận Thông Báo!");
            nhanemail = true;
        }

        if (tennv.isEmpty()||email.isEmpty()||matkhau.isEmpty()||matkhaunhaplai.isEmpty()){
            Toast.makeText(getActivity(),"Vui lòng điền đầy đủ thông tin và không bỏ trống trường nào!",Toast.LENGTH_LONG).show();
            Log.d("dangKi","Lỗi điền");
        } else if (!matkhau.equals(matkhaunhaplai)){
            Toast.makeText(getActivity(),"Mật khẩu nhập lại không giống!",Toast.LENGTH_LONG).show();
        } else {
            NhanVienAPI nhanVienAPI = APIUtils.nhanVienAPI();
            nhanVienAPI.dangKi(tennv,email,matkhau,nhanemail).enqueue(new Callback<Map<String, String>>() {
                @Override
                public void onResponse(Call<Map<String, String>> call, Response<Map<String, String>> response) {
                    Map<String, String> ketqua = response.body();
                    Toast.makeText(getActivity(),ketqua.get("Message"),Toast.LENGTH_LONG).show();
                    Log.d("dangKi","Kết quả: "+ketqua);
                }

                @Override
                public void onFailure(Call<Map<String, String>> call, Throwable t) {
                    Toast.makeText(getActivity(),"Lỗi: \n"+t.toString(),Toast.LENGTH_LONG).show();
                }
            });

        }
    }
}
