package com.huyhuynh.applazada.fragment.fragmenthome.viewinterface;

import com.huyhuynh.applazada.model.SanPham;
import com.huyhuynh.applazada.model.ThuongHieu;

import java.util.List;

public interface FragmenDienTuView {
    void hienThiDanhSachThuongHieu(List<ThuongHieu> listThuongHieus);
    void hienThiDanhSachSanPham(List<SanPham> sanPhamList);
}
