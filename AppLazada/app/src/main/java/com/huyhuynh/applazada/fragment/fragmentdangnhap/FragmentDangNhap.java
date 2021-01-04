package com.huyhuynh.applazada.fragment.fragmentdangnhap;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import com.huyhuynh.applazada.R;
import com.huyhuynh.applazada.model.ModelDangNhap;
import com.huyhuynh.applazada.model.NhanVien;
import com.huyhuynh.applazada.presenter.NhanVienPresenter;
import com.huyhuynh.applazada.retrofit.APIUtils;
import com.huyhuynh.applazada.retrofit.NhanVienAPI;
import com.huyhuynh.applazada.view.HomeActivity;
import com.huyhuynh.applazada.view.impl.HomeActivityView;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentDangNhap extends Fragment {

    TextView tvQuenMatKhau;
    EditText edtEmail, edtPassword;
    Button btnLogin, btnLoginWFacebook, btnLoginWGoogle;
    CallbackManager callbackManager;
    GoogleSignInClient googleSignInClient;
    public static final int RC_SIGN_IN = 8844; //request code google

    NhanVienPresenter nhanVienPresenter = new NhanVienPresenter();
    NhanVien nhanVien;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //đăng nhập bằng google
        ModelDangNhap modelDangNhap = new ModelDangNhap();
        googleSignInClient = modelDangNhap.xuLiDangNhapBangGoogle(getActivity());
        //đăng nhập bằng facebook
        useTheRightKeyHashFacebook();
        xuLiDangNhapBangFaceBook();
        View view = inflater.inflate(R.layout.fragment_dangnhap,container,false);
        //Khai báo đăng nhập bằng facebook (khởi troạ trước)
        //Ánh xạ
        init(view);
        btnLoginWFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dangNhapBangFaceBook();
            }
        });
        btnLoginWGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dangNhapBangGoogle();
            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuLiDangNhapServer();
            }
        });

        return view;
    }

    private void xuLiDangNhapServer() {
        String email = edtEmail.getText().toString().trim();
        String matkhau = edtPassword.getText().toString().trim();
        if (email.isEmpty()||matkhau.isEmpty()){
            Toast.makeText(getActivity(),"Vui lòng điền đầy đủ thông tin!",Toast.LENGTH_LONG).show();
        } else {
            NhanVienAPI nhanVienAPI = APIUtils.nhanVienAPI();
            nhanVienAPI.dangNhap(email,matkhau).enqueue(new Callback<NhanVien>() {
                @Override
                public void onResponse(Call<NhanVien> call, Response<NhanVien> response) {
                    nhanVien = response.body();
                    if (nhanVien!=null) {
                        Log.d("dangNhapServer", "Đăng nhập thành công!");
                        HomeActivity.nhanVien = nhanVien;
                        HomeActivity.dangnhap = nhanVien.getManv();
                        Intent intent = new Intent(getActivity(), HomeActivity.class);
                        startActivity(intent);
                    } else if (nhanVien==null){
                        Log.d("dangNhapServer", "Đăng nhập thất bại!");
                        Toast.makeText(getActivity(),"Đăng nhập thất bại!",Toast.LENGTH_LONG).show();
                    }
                }
                @Override
                public void onFailure(Call<NhanVien> call, Throwable t) {
                    Log.d("dangNhapServer","Lỗi1: \n"+t.toString());
                    Toast.makeText(getActivity(),"Đăng nhập thất bại!",Toast.LENGTH_LONG).show();
                }
            });

        }
    }

    private void dangNhapBangGoogle() {
        Intent signInIntent = googleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }


    private void dangNhapBangFaceBook() {
        LoginManager.getInstance().logInWithReadPermissions(FragmentDangNhap.this,
                Arrays.asList("email", "public_profile", "user_friends","basic_info"));
        Log.d("LoginFacebook:", "Button");
    }

    private void xuLiDangNhapBangFaceBook() {
        callbackManager = CallbackManager.Factory.create();
        LoginManager.getInstance().registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Log.d("LoginFacebook:", "Thành Công");
                Intent intent = new Intent(getActivity(), HomeActivity.class);
                startActivity(intent);
            }

            @Override
            public void onCancel() {
                Log.d("LoginFacebook:", "Thoát");
            }

            @Override
            public void onError(FacebookException error) {
                Log.d("LoginFacebook:", "Lỗi\n"+error.toString());
            }
        });
    }

    private void init(View view) {
        tvQuenMatKhau = view.findViewById(R.id.tvQuenMatKhau);
        edtEmail = view.findViewById(R.id.edtEmailDangNhap);
        edtPassword = view.findViewById(R.id.edtMatKhauDangNhap);
        btnLogin = view.findViewById(R.id.btnLogin);
        btnLoginWFacebook = view.findViewById(R.id.btnLoginWithFacebook);
        btnLoginWGoogle = view.findViewById(R.id.btnLoginWithGoogle);
    }


    //Phương thức này chỉ chạy mục đích lấy key cho project trên facebook
    private void useTheRightKeyHashFacebook(){
        // Add code to print out the key hash
        //PackageName: package of my project: com.huyhuynh.applazada
        try {
            PackageInfo info = getActivity().getPackageManager().getPackageInfo(
                    "com.huyhuynh.applazada",
                    PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.d("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            }
        } catch (PackageManager.NameNotFoundException e) {

        } catch (NoSuchAlgorithmException e) {

        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        callbackManager.onActivityResult(requestCode,resultCode,data);
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_SIGN_IN) {
            // The Task returned from this call is always completed, no need to attach
            // a listener.
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
        }
    }

    private void handleSignInResult(Task<GoogleSignInAccount> task) {
        try {
            GoogleSignInAccount account = task.getResult(ApiException.class);
            Intent intent = new Intent(getActivity(),HomeActivity.class);
            startActivity(intent);
            Log.d("GoogleHandle", "handleSignInResult: Thành công!" +account);
        } catch (ApiException e) {
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.
            Log.d("GoogleHandle", "signInResult:failed code=" + e.getStatusCode());
            //updateUI(null);
        }
    }
}
