package com.huyhuynh.applazada.model;

import java.util.List;

public class LoaiSanPham {
    private int maloaisp;
    private String tenloaisp;
    private int maloaicha;
    private List<LoaiSanPham> listLoaiSPCon;

    public LoaiSanPham(int maloaisp, String tenloaisp, int maloaicha) {
        this.maloaisp = maloaisp;
        this.tenloaisp = tenloaisp;
        this.maloaicha = maloaicha;
    }

    public LoaiSanPham() {
    }

    public int getMaloaisp() {
        return maloaisp;
    }

    public void setMaloaisp(int maloaisp) {
        this.maloaisp = maloaisp;
    }

    public String getTenloaisp() {
        return tenloaisp;
    }

    public void setTenloaisp(String tenloaisp) {
        this.tenloaisp = tenloaisp;
    }

    public int getMaloaicha() {
        return maloaicha;
    }

    public void setMaloaicha(int maloaicha) {
        this.maloaicha = maloaicha;
    }

    public List<LoaiSanPham> getListLoaiSPCon() {
        return listLoaiSPCon;
    }

    public void setListLoaiSPCon(List<LoaiSanPham> listLoaiSPCon) {
        this.listLoaiSPCon = listLoaiSPCon;
    }
}
