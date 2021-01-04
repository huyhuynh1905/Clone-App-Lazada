package com.huyhuynh.applazada.model;

import java.io.Serializable;

public class GioHang implements Serializable {
    private int magiohang;
    private int manv;
    private int masp;
    private String tensp;
    private int giatien;
    private String hinhanh;
    private int soluong;

    public GioHang() {
    }

    public GioHang(int magiohang, int manv, int masp, String tensp, int giatien, String hinhanh, int soluong) {
        this.magiohang = magiohang;
        this.manv = manv;
        this.masp = masp;
        this.tensp = tensp;
        this.giatien = giatien;
        this.hinhanh = hinhanh;
        this.soluong = soluong;
    }

    public int getMagiohang() {
        return magiohang;
    }

    public void setMagiohang(int magiohang) {
        this.magiohang = magiohang;
    }

    public int getManv() {
        return manv;
    }

    public void setManv(int manv) {
        this.manv = manv;
    }

    public int getMasp() {
        return masp;
    }

    public void setMasp(int masp) {
        this.masp = masp;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public int getGiatien() {
        return giatien;
    }

    public void setGiatien(int giatien) {
        this.giatien = giatien;
    }

    public String getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(String hinhanh) {
        this.hinhanh = hinhanh;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }
}
