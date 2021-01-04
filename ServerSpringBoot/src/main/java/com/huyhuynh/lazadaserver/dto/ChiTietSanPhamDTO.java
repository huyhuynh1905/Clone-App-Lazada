package com.huyhuynh.lazadaserver.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @project: lazadaserver
 * @author: HuyHuynh on 31/12/2020
 */
public class ChiTietSanPhamDTO {
    private int machitiet;
    private int masp;
    private String tenchitiet;
    private String giatri;


    public ChiTietSanPhamDTO() {
    }

    public ChiTietSanPhamDTO(int machitiet, int masp, String tenchitiet, String giatri) {
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
