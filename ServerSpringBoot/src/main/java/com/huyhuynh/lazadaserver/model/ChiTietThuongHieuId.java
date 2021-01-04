package com.huyhuynh.lazadaserver.model;

import java.io.Serializable;

/**
 * @project: lazadaserver
 * @author: HuyHuynh on 29/12/2020
 */
public class ChiTietThuongHieuId implements Serializable {
    private int math;
    private int maloaisp;

    public ChiTietThuongHieuId() {
    }

    public ChiTietThuongHieuId(int math, int maloaisp) {
        this.math = math;
        this.maloaisp = maloaisp;
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
}
