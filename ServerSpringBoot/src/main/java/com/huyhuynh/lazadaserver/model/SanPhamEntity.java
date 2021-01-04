package com.huyhuynh.lazadaserver.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @project: lazadaserver
 * @author: HuyHuynh on 28/12/2020
 */
@Entity
@Table(name = "sanpham")
public class SanPhamEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int masp;

    @Column(name = "tensp")
    private String tensp;
    @Column(name = "gia")
    private int gia;
    @Column(name = "hinhlon")
    private String hinhlon;
    @Column(name = "hinhnho")
    private String hinhnho;
    @Column(name = "thongtin")
    private String thongtin;
    @Column(name = "soluong")
    private int soluong;
    @Column(name = "math")
    private int math;
    @Column(name = "luotmua")
    private int luotmua;

    @ManyToOne
    @JoinColumn(name = "maloaisp")
    private LoaiSanPhamEntity loaiSanPham;

    @ManyToOne
    @JoinColumn(name = "manv")
    private NhanVienEntity nhanVien;

    public LoaiSanPhamEntity getLoaiSanPham() {
        return loaiSanPham;
    }

    public void setLoaiSanPham(LoaiSanPhamEntity loaiSanPham) {
        this.loaiSanPham = loaiSanPham;
    }

    public NhanVienEntity getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NhanVienEntity nhanVien) {
        this.nhanVien = nhanVien;
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

}
