package com.huyhuynh.applazada.retrofit;

public class APIUtils {
    public static final String urlAnh = "http://192.168.1.102:8081/images";
    public static final String baseUrl = "http://192.168.1.102:8081/";

    public static LoaiSanPhamAPI getDataLoaiSanPham(){
        return RetrofitClient.getRetrofit(baseUrl).create(LoaiSanPhamAPI.class);
    }

    public static NhanVienAPI nhanVienAPI(){
        return RetrofitClient.getRetrofit(baseUrl).create(NhanVienAPI.class);
    }
    public static FragmentDienTuAPI dienTuAPI(){
        return RetrofitClient.getRetrofit(baseUrl).create(FragmentDienTuAPI.class);
    }
    public static ChiTietSanPhamAPI chiTietSanPhamAPI(){
        return RetrofitClient.getRetrofit(baseUrl).create(ChiTietSanPhamAPI.class);
    }

    public static DanhGiaAPI danhGiaAPI(){
        return RetrofitClient.getRetrofit(baseUrl).create(DanhGiaAPI.class);
    }

    public static GioHangAPI gioHangAPI(){
        return RetrofitClient.getRetrofit(baseUrl).create(GioHangAPI.class);
    }

    public static HoaDonAPI hoaDonAPI(){
        return RetrofitClient.getRetrofit(baseUrl).create(HoaDonAPI.class);
    }

    public static SanPhamAPI sanPhamAPI(){
        return RetrofitClient.getRetrofit(baseUrl).create(SanPhamAPI.class);
    }
}
