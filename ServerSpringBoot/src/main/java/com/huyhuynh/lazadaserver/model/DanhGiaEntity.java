package com.huyhuynh.lazadaserver.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @project: lazadaserver
 * @author: HuyHuynh on 01/01/2021
 */
@Entity
@Table(name = "danhgia")
public class DanhGiaEntity {
    @Id
    String madg;

    @Column(name = "tenthietbi")
    String tenthietbi;
    @Column(name = "tieude")
    String tieude;
    @Column(name = "noidung")
    String noidung;
    @Column(name = "ngaydanhgia")
    String ngaydanhgia;
    @Column(name = "sosao")
    int sosao;
    @Column(name = "masp")
    int masp;

    public DanhGiaEntity() {
    }

    public DanhGiaEntity(String madg, String tenthietbi, String tieude, String noidung,
                         String ngaydanhgia, int sosao, int masp) {
        this.madg = madg;
        this.tenthietbi = tenthietbi;
        this.tieude = tieude;
        this.noidung = noidung;
        this.ngaydanhgia = ngaydanhgia;
        this.sosao = sosao;
        this.masp = masp;
    }

    public String getMadg() {
        return madg;
    }

    public void setMadg(String madg) {
        this.madg = madg;
    }

    public String getTenthietbi() {
        return tenthietbi;
    }

    public void setTenthietbi(String tenthietbi) {
        this.tenthietbi = tenthietbi;
    }

    public String getTieude() {
        return tieude;
    }

    public void setTieude(String tieude) {
        this.tieude = tieude;
    }

    public String getNoidung() {
        return noidung;
    }

    public void setNoidung(String noidung) {
        this.noidung = noidung;
    }

    public String getNgaydanhgia() {
        return ngaydanhgia;
    }

    public void setNgaydanhgia(String ngaydanhgia) {
        this.ngaydanhgia = ngaydanhgia;
    }

    public int getSosao() {
        return sosao;
    }

    public void setSosao(int sosao) {
        this.sosao = sosao;
    }

    public int getMasp() {
        return masp;
    }

    public void setMasp(int masp) {
        this.masp = masp;
    }
}
