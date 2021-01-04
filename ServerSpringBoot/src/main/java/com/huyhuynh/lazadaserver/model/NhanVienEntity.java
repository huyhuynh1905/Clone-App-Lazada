package com.huyhuynh.lazadaserver.model;

import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @project: lazadaserver
 * @author: HuyHuynh on 21/12/2020
 */

@Entity
@Table(name = "nhanvien")
public class NhanVienEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int manv;

    @Column(name = "tennv")
    private String tennv;
    @Column(name = "tendn")
    private String tendn;
    @Column(name = "email")
    private String email;
    @Column(name = "matkhau")
    private String matkhau;
    @Column(name = "diachi")
    private String diachi;
    @Column(name = "ngaysinh")
    private String ngaysinh;
    @Column(name = "sodt")
    private String sodt;
    @Column(name = "gioitinh")
    private String gioitinh;
    @Column(name = "cmnd")
    private String cmnd;
    @Column(name = "nhanemail")
    private boolean nhanemail;

    @ManyToOne
    @JoinColumn(name = "maloainv")
    private LoaiNhanVienEntity loaiNhanVien;

    @OneToMany(mappedBy = "nhanVien")
    private List<SanPhamEntity> sanPhamEntityList = new ArrayList<>();

    public NhanVienEntity() {

    }

    public NhanVienEntity(String tennv, String email, String matkhau, boolean nhanemail) {
        this.tennv = tennv;
        this.email = email;
        this.matkhau = matkhau;
        this.nhanemail = nhanemail;
    }

    public NhanVienEntity(int manv, String tennv, String tendn, String email, String matkhau
            , String diachi, String ngaysinh, String sodt, String gioitinh
            , String cmnd, int maloainv, boolean nhanemail) {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isNhanemail() {
        return nhanemail;
    }

    public void setNhanemail(boolean nhanemail) {
        this.nhanemail = nhanemail;
    }


    public LoaiNhanVienEntity getLoaiNhanVien() {
        return loaiNhanVien;
    }

    public void setLoaiNhanVien(LoaiNhanVienEntity loaiNhanVien) {
        this.loaiNhanVien = loaiNhanVien;
    }

}

