package com.huyhuynh.lazadaserver.model;

import javax.persistence.*;

/**
 * @project: lazadaserver
 * @author: HuyHuynh on 02/01/2021
 */
@Entity
@Table(name = "giohang")
public class GioHangEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int magiohang;

    @Column(name = "manv")
    private int manv;
    @Column(name = "masp")
    private int masp;
    @Column(name = "tensp")
    private String tensp;
    @Column(name = "giatien")
    private int giatien;
    @Column(name = "hinhanh")
    private String hinhanh;
    @Column(name = "soluong")
    private int soluong;

    public GioHangEntity() {
    }

    public GioHangEntity(int magiohang, int manv, int masp, String tensp, int giatien, String hinhanh, int soluong) {
        this.magiohang = magiohang;
        this.manv = manv;
        this.masp = masp;
        this.tensp = tensp;
        this.giatien = giatien;
        this.hinhanh = hinhanh;
        this.soluong = soluong;
    }

    public GioHangEntity(int manv, int masp, String tensp, int giatien, String hinhanh, int soluong) {
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
