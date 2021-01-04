package com.huyhuynh.applazada.model;

import java.util.List;

public class DienTu {
    List<ThuongHieu> thuongHieuList;
    List<SanPham> sanPhamList;
    String imgBanner;

    public List<ThuongHieu> getThuongHieuList() {
        return thuongHieuList;
    }

    public void setThuongHieuList(List<ThuongHieu> thuongHieuList) {
        this.thuongHieuList = thuongHieuList;
    }

    public List<SanPham> getSanPhamList() {
        return sanPhamList;
    }

    public void setSanPhamList(List<SanPham> sanPhamList) {
        this.sanPhamList = sanPhamList;
    }

    public String getImgBanner() {
        return imgBanner;
    }

    public void setImgBanner(String imgBanner) {
        this.imgBanner = imgBanner;
    }
}
