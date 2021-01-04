package com.huyhuynh.lazadaserver.model;


import javax.persistence.*;

/**
 * @project: lazadaserver
 * @author: HuyHuynh on 28/12/2020
 */
@Entity
@Table(name = "chitietthuonghieu")
@IdClass(value = ChiTietThuongHieuId.class)
public class ChiTietThuongHieu {
    @Id
    private int math;
    @Id
    private int maloaisp;

    @Column(name = "hinhthuonghieu")
    private String hinhthuonghieu;

    public ChiTietThuongHieu() {
    }

    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        this.math = math;
    }

    public int getMaloaisp() {
        return maloaisp;
    }

    public void setMaloaisp(int maloaisp) {
        this.maloaisp = maloaisp;
    }

    public String getHinhthuonghieu() {
        return hinhthuonghieu;
    }

    public void setHinhthuonghieu(String hinhthuonghieu) {
        this.hinhthuonghieu = hinhthuonghieu;
    }
}
