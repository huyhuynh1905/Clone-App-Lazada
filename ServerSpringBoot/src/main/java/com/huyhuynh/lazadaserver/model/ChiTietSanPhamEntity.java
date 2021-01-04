package com.huyhuynh.lazadaserver.model;

import javax.persistence.*;

/**
 * @project: lazadaserver
 * @author: HuyHuynh on 31/12/2020
 */
@Entity
@Table(name = "chitietsanpham")
public class ChiTietSanPhamEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int machitiet;
    @Column(name = "masp")
    private int masp;
    @Column(name = "tenchitiet")
    private String tenchitiet;
    @Column(name = "giatri")
    private String giatri;

    public ChiTietSanPhamEntity() {
    }

    public ChiTietSanPhamEntity(int machitiet, int masp, String tenchitiet, String giatri) {
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
