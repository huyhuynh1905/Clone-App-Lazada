package com.huyhuynh.lazadaserver.dto;

import javax.persistence.Column;

/**
 * @project: lazadaserver
 * @author: HuyHuynh on 16/12/2020
 */
public class LoaiSanPhamDTO {

    private int maloaisp;
    private String tenloaisp;
    private int maloaicha;

    public LoaiSanPhamDTO() {
    }

    public LoaiSanPhamDTO(int maloaisp, String tenloaisp, int maloaicha) {
        this.maloaisp = maloaisp;
        this.tenloaisp = tenloaisp;
        this.maloaicha = maloaicha;
    }

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

