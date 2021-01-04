package com.huyhuynh.applazada.model;

public class ChiTietHoaDon {
    private int mahd;
    private int masp;
    private int soluong;

    public ChiTietHoaDon() {
    }

    public ChiTietHoaDon(int mahd, int masp, int soluong) {
        this.mahd = mahd;
        this.masp = masp;
        this.soluong = soluong;
    }

    public int getMahd() {
        return mahd;
    }

    public void setMahd(int mahd) {
        this.mahd = mahd;
    }

    public int getMasp() {
        return masp;
    }

    public void setMasp(int masp) {
        this.masp = masp;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }
}
