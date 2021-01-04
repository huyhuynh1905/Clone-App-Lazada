package com.huyhuynh.lazadaserver.model;

import javax.persistence.*;

/**
 * @project: lazadaserver
 * @author: HuyHuynh on 04/01/2021
 */
@Entity
@Table(name = "chitiethoadon")
@IdClass(ChiTietHoaDonId.class)
public class ChiTietHoaDonEntity {
    @Id
    private int mahd;
    @Id
    private int masp;

    @Column(name = "soluong")
    private int soluong;

    public ChiTietHoaDonEntity() {
    }

    public ChiTietHoaDonEntity(int mahd, int masp, int soluong) {
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
