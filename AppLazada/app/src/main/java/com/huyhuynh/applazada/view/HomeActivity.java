package com.huyhuynh.applazada.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.MenuItemCompat;
import androidx.core.view.ViewCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginManager;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.tabs.TabLayout;
import com.huyhuynh.applazada.R;
import com.huyhuynh.applazada.adapter.ExpandMenuAdapter;
import com.huyhuynh.applazada.adapter.ViewPagerAdapter;
import com.huyhuynh.applazada.model.GioHang;
import com.huyhuynh.applazada.model.LoaiSanPham;
import com.huyhuynh.applazada.model.ModelDangNhap;
import com.huyhuynh.applazada.model.NhanVien;
import com.huyhuynh.applazada.presenter.LoaiSanPhamPresenter;
import com.huyhuynh.applazada.retrofit.APIUtils;
import com.huyhuynh.applazada.retrofit.GioHangAPI;
import com.huyhuynh.applazada.view.impl.HomeActivityView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeActivity extends AppCompatActivity implements HomeActivityView, AppBarLayout.OnOffsetChangedListener {

    Button btnTimKiemHome;
    Toolbar toolbarHome;
    TabLayout tabLayout;
    ViewPager viewPager;
    ViewPagerAdapter pagerAdapter;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle drawerToggle;
    ExpandableListView expandMenu;
    String userFacebook;
    LoaiSanPhamPresenter loaiSanPhamPresenter;
    AccessToken accessToken;
    Menu menu;
    ModelDangNhap modelDangNhap;
    GoogleSignInAccount googleSignInAccount;
    GoogleSignInClient googleSignInClient;
    MenuItem menuItemLogout,menuItemLogin;

    TextView tvGioHang;
    CollapsingToolbarLayout collapsingToolbarLayout;
    AppBarLayout appBarLayout;

    public static NhanVien nhanVien;
    String emailNhanVien = null;
    String tenNhanVien = null;
    SharedPreferences sharedPreferences;
    public static int dangnhap = -1;
    List<GioHang> gioHangList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        init();
        loaiSanPhamPresenter = new LoaiSanPhamPresenter(this);
        loaiSanPhamPresenter.layDanhSachMenu(0);

        googleSignInClient = modelDangNhap.xuLiDangNhapBangGoogle(this);
    }

    private void init() {
        btnTimKiemHome = findViewById(R.id.btnTimKiemHome);
        toolbarHome = findViewById(R.id.toolbar_home);
        tabLayout = findViewById(R.id.tabLayoutHome);
        viewPager = findViewById(R.id.viewPagerHome);
        drawerLayout = findViewById(R.id.drawerLayoutHome);
        expandMenu = findViewById(R.id.epMenu);
        collapsingToolbarLayout = findViewById(R.id.collapsing_toolbar);
        appBarLayout = findViewById(R.id.appBarHome);
        modelDangNhap = new ModelDangNhap();
        sharedPreferences = getSharedPreferences("login", Context.MODE_PRIVATE);
        emailNhanVien = sharedPreferences.getString("emailNhanVien",null); //Lấy emailnhanvien neu co
        tenNhanVien = sharedPreferences.getString("tenNhanVien",null);
        dangnhap = sharedPreferences.getInt("manv",-1);

        toolbarHome.setTitle("");
        setSupportActionBar(toolbarHome);

        pagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(viewPager);


        drawerToggle = new ActionBarDrawerToggle(this,drawerLayout,R.string.openStr,R.string.closeStr);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        appBarLayout.addOnOffsetChangedListener(this);

        btnTimKiemHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentSearch = new Intent(HomeActivity.this,TimKiemActivity.class);
                startActivity(intentSearch);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_home_activity,menu);
        this.menu = menu;
        //Làm cho cart hiển thị số lượng sản phẩm khi thêm
        MenuItem itemGioHang = menu.findItem(R.id.itCart);
        View customGiaoDienGioHang = MenuItemCompat.getActionView(itemGioHang);
        tvGioHang = customGiaoDienGioHang.findViewById(R.id.tvSoLuongSanPhamItemGioHang);
        laySoLuongSanPham();
        customGiaoDienGioHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (dangnhap>-1) {
                    Intent intent = new Intent(HomeActivity.this, GioHangActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("listGioHang", (Serializable) gioHangList);
                    intent.putExtra("bundle", bundle);
                    startActivity(intent);
                } else {
                    Toast.makeText(HomeActivity.this,"Bạn vui lòng đăng nhập!",Toast.LENGTH_SHORT).show();
                }
            }
        });
        

        menuItemLogin = menu.findItem(R.id.itLogin);
        menuItemLogout = menu.findItem(R.id.itLogout);
        googleSignInAccount = modelDangNhap.layTaiKhoanGoogle(this);
        //Lấy ra tên fb để gán vào menu
        if (accessToken!=null) {
            getUserFacebookNameFromToken(menu);
        } else if (googleSignInAccount!=null){
            menuItemLogin.setTitle(googleSignInAccount.getDisplayName());
        } else if (nhanVien!=null){
            menuItemLogin.setTitle(nhanVien.getTennv());
            //Lưu
            emailNhanVien = nhanVien.getEmail();
            tenNhanVien = nhanVien.getTennv();
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.clear();
            editor.apply();
            editor.putString("emailNhanVien",emailNhanVien);
            editor.putString("tenNhanVien",tenNhanVien);
            editor.putInt("manv",nhanVien.getManv());
            editor.apply();
            Log.d("emailNhanVien","Lưu: "+emailNhanVien);
        } else if (tenNhanVien!=null){
            menuItemLogin.setTitle(tenNhanVien);
        }

        if (accessToken!=null||googleSignInAccount!=null||nhanVien!=null||emailNhanVien!=null){
            menuItemLogout.setVisible(true);
        }
        return true;
    }

    private void getUserFacebookNameFromToken(final Menu menu) {
        accessToken = loaiSanPhamPresenter.layTenNguoiDungFacebook();
        if (accessToken!=null) {
            GraphRequest graphRequest = GraphRequest.newMeRequest(accessToken, new GraphRequest.GraphJSONObjectCallback() {
                @Override
                public void onCompleted(JSONObject object, GraphResponse response) {
                    try {
                        userFacebook = object.getString("name");
                        menuItemLogin.setTitle(userFacebook);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    Log.d("Token", "Tên người dùng: " + userFacebook);
                }
            });

            Bundle bundle = new Bundle();
            bundle.putString("feilds", "name");
            graphRequest.setParameters(bundle);
            graphRequest.executeAsync();
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (drawerToggle.onOptionsItemSelected(item)){
            return true;
        }

        switch (item.getItemId()){
            case R.id.itLogin:
                if (accessToken==null && googleSignInAccount==null && nhanVien==null && emailNhanVien==null) {
                    Intent intent = new Intent(HomeActivity.this, DangNhapActivity.class);
                    startActivity(intent);
                }
                break;
            case R.id.itLogout:
                if (accessToken!=null) {
                    LoginManager.getInstance().logOut();
                    this.menu.clear();
                    this.onCreateOptionsMenu(this.menu);
                }
                if (googleSignInAccount!=null){
                    googleSignInClient.signOut().addOnCompleteListener(this, new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            Log.d("googleSignOut","Logout thanh cong!");
                            menu.clear();
                            onCreateOptionsMenu(menu);
                        }
                    });
                }
                if (nhanVien!=null||emailNhanVien!=null){
                    nhanVien=null;
                    emailNhanVien=null;
                    tenNhanVien=null;
                    dangnhap = -1;
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.remove("emailNhanVien");
                    editor.remove("tenNhanVien");
                    editor.remove("manv");
                    editor.apply();
                    this.menu.clear();
                    this.onCreateOptionsMenu(this.menu);
                }
                break;
            case R.id.itSearchHome:
                Intent intentSearch = new Intent(HomeActivity.this,TimKiemActivity.class);
                startActivity(intentSearch);
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void hienThiDanhSachMenu(List<LoaiSanPham> loaiSanPhams) {
        ExpandMenuAdapter expandMenuAdapter = new ExpandMenuAdapter(loaiSanPhams,this);
        expandMenu.setAdapter(expandMenuAdapter);
        expandMenuAdapter.notifyDataSetChanged();
    }


    public void dangNhapBangServer(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
        menuItemLogin.setTitle(nhanVien.getTennv());
        emailNhanVien = nhanVien.getEmail();
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("emailNhanVien",emailNhanVien);
        editor.apply();
        Log.d("emailNhanVien",emailNhanVien);
    }


    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
        //Log.d("onOffsetChanged",collapsingToolbarLayout.getHeight() + " - " +i + " - "+ViewCompat.getMinimumHeight(collapsingToolbarLayout));
        if (collapsingToolbarLayout.getHeight()+i <= 1.95*ViewCompat.getMinimumHeight(collapsingToolbarLayout)) {
            LinearLayout linearLayout = appBarLayout.findViewById(R.id.lnSearch);
            linearLayout.animate().alpha(0).setDuration(100);

            MenuItem itSearch = menu.findItem(R.id.itSearchHome);
            itSearch.setVisible(true);

        } else {
            LinearLayout linearLayout = appBarLayout.findViewById(R.id.lnSearch);
            linearLayout.animate().alpha(1).setDuration(500);
            try {
                MenuItem itSearch = menu.findItem(R.id.itSearchHome);
                itSearch.setVisible(false);
            } catch (Exception ex){

            }
        }
    }

    public void laySoLuongSanPham(){
        GioHangAPI gioHangAPI = APIUtils.gioHangAPI();
        gioHangAPI.getAllGioHang(dangnhap).enqueue(new Callback<List<GioHang>>() {
            @Override
            public void onResponse(Call<List<GioHang>> call, Response<List<GioHang>> response) {
                gioHangList = response.body();
                if (gioHangList!=null){
                    Log.d("getAllGioHang","Có data trả về!");
                    //
                    getAllGioHang(gioHangList);
                } else {
                    Log.d("getAllGioHang","Ko có data trả về!");
                    getAllGioHang(null);
                }
            }

            @Override
            public void onFailure(Call<List<GioHang>> call, Throwable t) {
                Log.d("getAllGioHang","Lỗi: \n"+t.toString());
            }
        });
    }
    public void getAllGioHang(List<GioHang> gioHangList) {
        if (gioHangList==null){
            tvGioHang.setText("0");
        } else {
            int sosanpham = 0;
            for (int i = 0;i<gioHangList.size();i++) {
                sosanpham+=gioHangList.get(i).getSoluong();
            }
            Log.d("getAllGioHang", "Size: " + sosanpham);
            tvGioHang.setText(sosanpham+ "");
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        laySoLuongSanPham();
    }
}