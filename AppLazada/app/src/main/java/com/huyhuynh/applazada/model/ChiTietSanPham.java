package com.huyhuynh.applazada.model;

public class ChiTietSanPham {
    private int machitiet;
    private int masp;
    private String tenchitiet;
    private String giatri;


    public ChiTietSanPham() {
    }

    public ChiTietSanPham(int machitiet, int masp, String tenchitiet, String giatri) {
        this.machitiet = machitiet;
        this.masp = masp;
        this.tenchitiet = tenchitiet;
        this.giatri = giatri;
    }

    public int getMachitiet() {
        return machitiet;
    }

    public void setMachitiet(int machitiet) {
        this.machitiet = machitiet;
    }

    public int getMasp() {
        return masp;
    }

    public void setMasp(int masp) {
        this.masp = masp;
    }

    public String getTenchitiet() {
        return tenchitiet;
    }

    public void setTenchitiet(String tenchitiet) {
        this.tenchitiet = tenchitiet;
    }

    public String getGiatri() {
        return giatri;
    }

    public void setGiatri(String giatri) {
        this.giatri = giatri;
    }
}
