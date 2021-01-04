package com.huyhuynh.lazadaserver.dto;

/**
 * @project: lazadaserver
 * @author: HuyHuynh on 28/12/2020
 */
public class SanPhamDTO {
    private int masp;
    private String tensp;
    private int gia;
    private String hinhlon;
    private String hinhnho;
    private String thongtin;
    private int soluong;
    private int math;
    private int luotmua;
    private int maloaisp;
    private int manv;

    public SanPhamDTO() {
    }

    public SanPhamDTO(int masp, String tensp, int gia, String hinhlon, String hinhnho, String thongtin, int soluong
            , int math, int luotmua, int maloaisp, int manv) {
        this.masp = masp;
        this.tensp = tensp;
        this.gia = gia;
        this.hinhlon = hinhlon;
        this.hinhnho = hinhnho;
        this.thongtin = thongtin;
        this.soluong = soluong;
        this.math = math;
        this.luotmua = luotmua;
        this.maloaisp = maloaisp;
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

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public String getHinhlon() {
        return hinhlon;
    }

    public void setHinhlon(String hinhlon) {
        this.hinhlon = hinhlon;
    }

    public String getHinhnho() {
        return hinhnho;
    }

    public void setHinhnho(String hinhnho) {
        this.hinhnho = hinhnho;
    }

    public String getThongtin() {
        return thongtin;
    }

    public void setThongtin(String thongtin) {
        this.thongtin = thongtin;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        this.math = math;
    }

    public int getLuotmua() {
        return luotmua;
    }

    public void setLuotmua(int luotmua) {
        this.luotmua = luotmua;
    }

    public int getMaloaisp() {
        return maloaisp;
    }

    public void setMaloaisp(int maloaisp) {
        this.maloaisp = maloaisp;
    }

    public int getManv() {
        return manv;
    }

    public void setManv(int manv) {
        this.manv = manv;
    }
}
