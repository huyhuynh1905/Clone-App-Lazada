package com.huyhuynh.applazada.retrofit;

import com.huyhuynh.applazada.model.ChiTietHoaDon;
import com.huyhuynh.applazada.model.HoaDon;

import java.util.List;

public class HoaDonPayload {
    private HoaDon hoaDon;
    private List<ChiTietHoaDon> chiTietHoaDonList;

    public HoaDonPayload() {
    }

    public HoaDonPayload(HoaDon hoaDon, List<ChiTietHoaDon> chiTietHoaDonList) {
        this.hoaDon = hoaDon;
        this.chiTietHoaDonList = chiTietHoaDonList;
    }

    public HoaDon getHoaDon() {
        return hoaDon;
    }

    public void setHoaDon(HoaDon hoaDon) {
        this.hoaDon = hoaDon;
    }

    public List<ChiTietHoaDon> getChiTietHoaDonList() {
        return chiTietHoaDonList;
    }

    public void setChiTietHoaDonList(List<ChiTietHoaDon> chiTietHoaDonList) {
        this.chiTietHoaDonList = chiTietHoaDonList;
    }
}
