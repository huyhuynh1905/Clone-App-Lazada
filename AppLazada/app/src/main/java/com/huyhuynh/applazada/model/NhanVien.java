package com.huyhuynh.applazada.model;

import androidx.annotation.NonNull;

public class NhanVien {
    private int manv;
    private String tennv;
    private String tendn;
    private String email;
    private String matkhau;
    private String diachi;
    private String ngaysinh;
    private String sodt;
    private String gioitinh;
    private String cmnd;
    private boolean nhanemail;
    private int loaiNhanVien;


    public NhanVien() {

    }

    public NhanVien(int manv, String tennv, String tendn, String email, String matkhau
            , String diachi, String ngaysinh, String sodt, String gioitinh
            , String cmnd, boolean nhanemail, int loaiNhanVien) {

        this.manv = manv;
        this.tennv = tennv;
        this.tendn = tendn;
        this.email = email;
        this.matkhau = matkhau;
        this.diachi = diachi;
        this.ngaysinh = ngaysinh;
        this.sodt = sodt;
        this.gioitinh = gioitinh;
        this.cmnd = cmnd;
        this.nhanemail = nhanemail;
        this.loaiNhanVien = loaiNhanVien;
    }

    public int getManv() {
        return manv;
    }

    public void setManv(int manv) {
        this.manv = manv;
    }

    public String getTennv() {
        return tennv;
    }

    public void setTennv(String tennv) {
        this.tennv = tennv;
    }

    public String getTendn() {
        return tendn;
    }

    public void setTendn(String tendn) {
        this.tendn = tendn;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(String ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getSodt() {
        return sodt;
    }

    public void setSodt(String sodt) {
        this.sodt = sodt;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public boolean isNhanemail() {
        return nhanemail;
    }

    public void setNhanemail(boolean nhanemail) {
        this.nhanemail = nhanemail;
    }

    public int getLoaiNhanVien() {
        return loaiNhanVien;
    }

    public void setLoaiNhanVien(int loaiNhanVien) {
        this.loaiNhanVien = loaiNhanVien;
    }


    @NonNull
    @Override
    public String toString() {
        return "{\n" +
                "    \"manv\": " +this.manv+"\n"+
                "    \"tennv\": " +this.tennv+"\n"+
                "    \"email\": " +this.email+"\n"+
                "    \"matkhau\": " +this.matkhau+"\n"+
                "    \"nhanemail\": " +this.nhanemail+"\n"+
                "    \"loaiNhanVien\": " +this.loaiNhanVien+"\n"+
                "}";
    }
}
