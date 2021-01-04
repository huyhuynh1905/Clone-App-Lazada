package com.huyhuynh.lazadaserver.model;

import java.io.Serializable;

/**
 * @project: lazadaserver
 * @author: HuyHuynh on 04/01/2021
 */
public class ChiTietHoaDonId implements Serializable {
    private int mahd;

    private int masp;

    public ChiTietHoaDonId() {
    }

    public ChiTietHoaDonId(int mahd, int masp) {
        this.mahd = mahd;
        this.masp = masp;
    }
}
