package com.huyhuynh.lazadaserver.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @project: lazadaserver
 * @author: HuyHuynh on 16/12/2020
 */
@Entity
@Table (name = "loaisanpham")
public class LoaiSanPhamEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "maloaisp")
    private int maloaisp;

    @Column(name = "tenloaisp")
    private String tenloaisp;
    @Column(name = "maloai_cha")
    private int maloaicha;

    @OneToMany(mappedBy = "loaiSanPham")
    private List<SanPhamEntity> sanPhamEntityList = new ArrayList<>();

    /*
    @OneToOne(mappedBy = "loaiSanPham")
    private ThuongHieuEntity thuongHieuEntity;
     */

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
}
