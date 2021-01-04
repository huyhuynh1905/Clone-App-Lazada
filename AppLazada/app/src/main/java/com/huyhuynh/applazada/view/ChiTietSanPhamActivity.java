package com.huyhuynh.applazada.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.MenuItemCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.huyhuynh.applazada.R;
import com.huyhuynh.applazada.adapter.DanhGiaAdapter;
import com.huyhuynh.applazada.adapter.ViewSlideImageCtspAdapter;
import com.huyhuynh.applazada.fragment.fragmentsanpham.FragmentLoadImageChiTietSanPham;
import com.huyhuynh.applazada.model.ChiTietSanPham;
import com.huyhuynh.applazada.model.DanhGia;
import com.huyhuynh.applazada.model.GioHang;
import com.huyhuynh.applazada.model.SanPham;
import com.huyhuynh.applazada.presenter.ChiTietSanPhamPresenter;
import com.huyhuynh.applazada.presenter.GioHangPresenter;
import com.huyhuynh.applazada.presenter.NhanVienPresenter;
import com.huyhuynh.applazada.retrofit.APIUtils;
import com.huyhuynh.applazada.retrofit.NhanVienAPI;
import com.huyhuynh.applazada.view.impl.ChiTietSanPhamActivityView;

import org.w3c.dom.Text;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChiTietSanPhamActivity extends AppCompatActivity implements ChiTietSanPhamActivityView {
    SanPham sanPham;
    ChiTietSanPhamPresenter chiTietSanPhamPresenter;
    String[] linkHinhs;
    ViewPager viewPager;

    Button btnMuaNgay;
    ImageButton btnThemGioHang;
    TextView tvTensp,tvGiasp,tvTenChDongGoi,tvThongTinChiTietSp,tvDanhGiaSp,tvXemTatCaNhanXet, tvGioHang;
    RatingBar ratingBar;
    Toolbar toolbar;
    LinearLayout lnDots,lnThongSoKiThuat;
    ImageView imgXemThem;
    RecyclerView rcvDanhGiaChiTiet;

    List<Fragment> fragments;
    TextView[] txtDots;

    boolean checkXemThem = false;
    private static final int REQUEST_DANHGIA = 19;

    List<DanhGia> danhGiaList;
    DanhGiaAdapter danhGiaAdapter;

    //Giỏ hàng
    GioHangPresenter gioHangPresenter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_san_pham);
        init();
    }

    private void init() {
        viewPager = findViewById(R.id.viewpagerSlider_ctsp);
        btnMuaNgay = findViewById(R.id.btnMuaNgay_ctsp);
        btnThemGioHang = findViewById(R.id.imThemGioHang_ctsp);
        tvTensp = findViewById(R.id.txtTenSanPham_ctsp);
        tvGiasp = findViewById(R.id.txtGiaTien_ctsp);
        ratingBar = findViewById(R.id.rbDanhGia_ctsp);
        toolbar = findViewById(R.id.toolbar_ctsp);
        lnDots = findViewById(R.id.layoutDots_ctsp);
        tvTenChDongGoi = findViewById(R.id.txtTenCHDongGoi_ctsp);
        tvThongTinChiTietSp = findViewById(R.id.txtThongTinChiTiet_ctsp);
        lnThongSoKiThuat = findViewById(R.id.lnThongSoKyThuat_ctsp);
        imgXemThem = findViewById(R.id.imgXemThemChiTiet_ctsp);
        tvDanhGiaSp = findViewById(R.id.txtVietDanhGia_ctsp);
        rcvDanhGiaChiTiet = findViewById(R.id.recyclerDanhGiaChiTiet_ctsp);
        tvXemTatCaNhanXet = findViewById(R.id.txtXemTatCaNhanXet_ctsp);





        chiTietSanPhamPresenter = new ChiTietSanPhamPresenter(this);
        final Intent intent = getIntent();
        final Bundle bundle = intent.getBundleExtra("dataSanPham");
        if (bundle!=null) {
            sanPham = (SanPham) bundle.getSerializable("sanpham");
            layTenNhanVien(sanPham.getManv());
            chiTietSanPhamPresenter.getChiTietSanPhamByMasp(sanPham.getMasp());
            setThongTinSanPham();
        }
        toolbar.setTitle(sanPham.getTensp());
        setSupportActionBar(toolbar);

        //Viết đánh giá
        tvDanhGiaSp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentDanhGia = new Intent(ChiTietSanPhamActivity.this,DanhGiaActivity.class);
                intentDanhGia.putExtra("masp",sanPham.getMasp());
                startActivityForResult(intentDanhGia,REQUEST_DANHGIA);
            }
        });
        chiTietSanPhamPresenter.layDanhSachDanhGia(sanPham.getMasp()); //lấy danh sách đánh giá

        //xem tất cả nhận xét
        tvXemTatCaNhanXet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (danhGiaList==null||danhGiaList.size()==0){
                    Toast.makeText(ChiTietSanPhamActivity.this,
                            "Không có bình luận nào cho sản phẩm này!",Toast.LENGTH_SHORT).show();
                } else {
                    Intent intentDanhGia = new Intent(ChiTietSanPhamActivity.this, DanhSachDanhGiaActivity.class);
                    Bundle bundleDanhGia = new Bundle();
                    bundleDanhGia.putSerializable("danhGiaList", (Serializable) danhGiaList);
                    intentDanhGia.putExtra("bundleDanhGia", bundleDanhGia);
                    startActivity(intentDanhGia);
                }
            }
        });

        //Giỏ hàng
        gioHangPresenter = new GioHangPresenter(this);
        
        btnThemGioHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                themGioHang();
            }
        });

        //
        btnMuaNgay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                themGioHang();
                Intent intentMuaNgay = new Intent(ChiTietSanPhamActivity.this,GioHangActivity.class);
                startActivity(intentMuaNgay);
            }
        });
    }

    private void themGioHang() {
        if (HomeActivity.dangnhap>0) {
            GioHang gioHang = new GioHang();
            gioHang.setHinhanh(sanPham.getHinhlon());
            gioHang.setGiatien(sanPham.getGia());
            gioHang.setTensp(sanPham.getTensp());
            gioHang.setSoluong(1);
            gioHang.setMasp(sanPham.getMasp());
            gioHang.setManv(HomeActivity.dangnhap);
            gioHangPresenter.themGioHang(gioHang);
        } else {
            Toast.makeText(ChiTietSanPhamActivity.this,"Vui lòng đăng nhập để thêm giỏ hàng!",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(ChiTietSanPhamActivity.this,DangNhapActivity.class);
            startActivity(intent);
        }

    }

    private void setThongTinSanPham() {
        //Load hình dạng slider
        String hinh = sanPham.getHinhnho();
        linkHinhs = hinh.split(",");
        addListImage(linkHinhs);

        //gán các giá trị
        tvTensp.setText(sanPham.getTensp());
        NumberFormat numberFormat = new DecimalFormat("###,###");
        tvGiasp.setText(numberFormat.format(sanPham.getGia())+" vnđ");
        tvThongTinChiTietSp.setText(sanPham.getThongtin().substring(0,100)+"...");

        if (sanPham.getThongtin().length()<100){
            imgXemThem.setVisibility(View.GONE);
        } else {
            imgXemThem.setVisibility(View.VISIBLE);

            imgXemThem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (!checkXemThem) {
                        imgXemThem.setImageResource(R.drawable.ic_keyboard_arrow_up_black_24dp);
                        tvThongTinChiTietSp.setText(sanPham.getThongtin());
                        lnThongSoKiThuat.setVisibility(View.VISIBLE);
                        checkXemThem=true;
                    } else {
                        imgXemThem.setImageResource(R.drawable.ic_keyboard_arrow_down_black_24dp);
                        tvThongTinChiTietSp.setText(sanPham.getThongtin().substring(0,100)+"...");
                        lnThongSoKiThuat.setVisibility(View.GONE);
                        checkXemThem=false;
                    }
                }
            });
        }

    }

    public void layTenNhanVien(int manv) {
        NhanVienAPI nhanVienAPI = APIUtils.nhanVienAPI();
        nhanVienAPI.laytenNhanVien(manv).enqueue(new Callback<Map<String,String>>() {
            @Override
            public void onResponse(Call<Map<String,String>> call, Response<Map<String,String>> response) {
                Map<String,String> map = response.body();
                String tennv = map.get("tennv");
                tvTenChDongGoi.setText(tennv);
            }
            @Override
            public void onFailure(Call<Map<String,String>> call, Throwable t) {
                Log.d("layTenNhanVien","Lỗi: \n"+t.toString());
            }
        });
    }

    @Override
    public void loadThongTinSanPham(List<ChiTietSanPham> chiTietSanPhamList) {
        if (chiTietSanPhamList!=null){
            hienThiThongSoKiThuat(chiTietSanPhamList);
        } else {
            Log.d("getChiTietSanPhamByMasp","Chưa trả gì về hết");
        }
    }

    private void hienThiThongSoKiThuat(List<ChiTietSanPham> chiTietSanPhamList){
        TextView txtTieuDeThongSoKyThuat = new TextView(this);
        txtTieuDeThongSoKyThuat.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        lnThongSoKiThuat.addView(txtTieuDeThongSoKyThuat);
        for (int i=0 ;i<chiTietSanPhamList.size(); i++){
            LinearLayout lnChiTiet = new LinearLayout(this);
            lnChiTiet.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            lnChiTiet.setOrientation(LinearLayout.HORIZONTAL);

            TextView txtTenThongSo = new TextView(this);
            txtTenThongSo.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT,1.0f));
            txtTenThongSo.setText(chiTietSanPhamList.get(i).getTenchitiet());

            TextView txtGiaTriThongSo = new TextView(this);
            txtGiaTriThongSo.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT,1.0f));
            txtGiaTriThongSo.setText(chiTietSanPhamList.get(i).getGiatri());

            lnChiTiet.addView(txtTenThongSo);
            lnChiTiet.addView(txtGiaTriThongSo);

            lnThongSoKiThuat.addView(lnChiTiet);
        }

    }
    private void addListImage(String[] linkHinhs) {
        fragments = new ArrayList<>();
        for (int i=0;i<linkHinhs.length;i++){
            FragmentLoadImageChiTietSanPham fragmentLoadImage = new FragmentLoadImageChiTietSanPham();
            Bundle bundle = new Bundle();
            bundle.putString("linkImage",linkHinhs[i]);
            fragmentLoadImage.setArguments(bundle);
            fragments.add(fragmentLoadImage);
        }
        ViewSlideImageCtspAdapter viewSlideImageCtspAdapter = new ViewSlideImageCtspAdapter(getSupportFragmentManager(),fragments);
        viewPager.setAdapter(viewSlideImageCtspAdapter);
        viewSlideImageCtspAdapter.notifyDataSetChanged();
        themDotSlider(0);
        viewPagerListener();
    }

    private void viewPagerListener() {
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                themDotSlider(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void themDotSlider(int position){
        txtDots = new TextView[fragments.size()];
        lnDots.removeAllViews();
        for (int i=0;i<fragments.size();i++){
            txtDots[i] = new TextView(this);
            txtDots[i].setText(Html.fromHtml("&#8226;"));
            txtDots[i].setTextSize(30);
            txtDots[i].setTextColor(Color.argb(100,128,149,161)); //colorSliderInActive

            lnDots.addView(txtDots[i]);
        }
        txtDots[position].setTextColor(Color.argb(100,24,53,69)); //bkgToolbar
    }


    @Override
    public void getAllDanhGia(List<DanhGia> danhGiaLists) {
        danhGiaList = danhGiaLists;
        danhGiaAdapter = new DanhGiaAdapter(this,danhGiaLists);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        rcvDanhGiaChiTiet.setLayoutManager(layoutManager);
        rcvDanhGiaChiTiet.setAdapter(danhGiaAdapter);
        danhGiaAdapter.notifyDataSetChanged();
        int tongdanhgia = 0;
        for (DanhGia danhGia : danhGiaLists){
            tongdanhgia+=danhGia.getSosao();
        }
        if (tongdanhgia>0){
            ratingBar.setRating((float) (tongdanhgia/danhGiaLists.size()));
        }

    }

    @Override
    public void themGioHang(boolean kq) {
        if (kq){
            Toast.makeText(ChiTietSanPhamActivity.this,"Thêm thành công!",Toast.LENGTH_SHORT).show();
            gioHangPresenter.getAllGioHang(HomeActivity.dangnhap);
        } else {
            Toast.makeText(ChiTietSanPhamActivity.this,"Thêm thất bại!",Toast.LENGTH_SHORT).show();
            gioHangPresenter.getAllGioHang(HomeActivity.dangnhap);
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_home_activity,menu);
        MenuItem itemGioHang = menu.findItem(R.id.itCart);
        View customGiaoDienGioHang = MenuItemCompat.getActionView(itemGioHang);
        tvGioHang =customGiaoDienGioHang.findViewById(R.id.tvSoLuongSanPhamItemGioHang);
        gioHangPresenter.getAllGioHang(HomeActivity.dangnhap);
        customGiaoDienGioHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (HomeActivity.dangnhap>-1) {
                    Intent intent = new Intent(ChiTietSanPhamActivity.this, GioHangActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(ChiTietSanPhamActivity.this,"Bạn vui lòng đăng nhập!",Toast.LENGTH_SHORT).show();
                }
            }
        });
        return true;
    }
    @Override
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
}