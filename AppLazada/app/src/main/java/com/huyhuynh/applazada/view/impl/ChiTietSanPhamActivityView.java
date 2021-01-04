package com.huyhuynh.applazada.view.impl;

import com.huyhuynh.applazada.model.ChiTietSanPham;
import com.huyhuynh.applazada.model.DanhGia;
import com.huyhuynh.applazada.model.GioHang;

import java.util.List;

public interface ChiTietSanPhamActivityView {
    void loadThongTinSanPham(List<ChiTietSanPham> chiTietSanPhamList);
    void getAllDanhGia(List<DanhGia> danhGiaList);
    void themGioHang(boolean kq);
    void getAllGioHang(List<GioHang> gioHangList);
}
