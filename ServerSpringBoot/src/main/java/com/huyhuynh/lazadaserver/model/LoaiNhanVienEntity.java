package com.huyhuynh.lazadaserver.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @project: lazadaserver
 * @author: HuyHuynh on 21/12/2020
 */
@Entity
@Table(name = "loainhanvien")
public class LoaiNhanVienEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int maloainv;

    @Column(name = "tenloainv")
    private String tenloainv;

    @OneToMany(mappedBy = "loaiNhanVien")
    private List<NhanVienEntity> nhanVienEntityList = new ArrayList<>();

    public LoaiNhanVienEntity() {
    }

    public LoaiNhanVienEntity(int maloainv) {
        this.maloainv = maloainv;
    }

    public LoaiNhanVienEntity(int maloainv, String tenloainv) {
        this.maloainv = maloainv;
        this.tenloainv = tenloainv;
    }

    public int getMaloainv() {
        return maloainv;
    }

    public void setMaloainv(int maloainv) {
        this.maloainv = maloainv;
    }

    public String getTenloainv() {
        return tenloainv;
    }

    public void setTenloainv(String tenloainv) {
        this.tenloainv = tenloainv;
    }

    public List<NhanVienEntity> getNhanVienEntityList() {
        return nhanVienEntityList;
    }

    public void setNhanVienEntityList(List<NhanVienEntity> nhanVienEntityList) {
        this.nhanVienEntityList = nhanVienEntityList;
    }
}
