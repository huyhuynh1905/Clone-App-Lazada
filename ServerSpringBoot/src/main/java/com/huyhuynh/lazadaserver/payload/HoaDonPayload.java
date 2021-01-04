package com.huyhuynh.lazadaserver.payload;

import com.huyhuynh.lazadaserver.dto.ChiTietHoaDonDTO;
import com.huyhuynh.lazadaserver.dto.HoaDonDTO;

import java.util.List;

/**
 * @project: lazadaserver
 * @author: HuyHuynh on 04/01/2021
 */
public class HoaDonPayload {
    private HoaDonDTO hoaDon;
    private List<ChiTietHoaDonDTO> chiTietHoaDonList;

    public HoaDonPayload() {
    }

    public HoaDonPayload(HoaDonDTO hoaDon, List<ChiTietHoaDonDTO> chiTietHoaDonList) {
        this.hoaDon = hoaDon;
        this.chiTietHoaDonList = chiTietHoaDonList;
    }

    public HoaDonDTO getHoaDon() {
        return hoaDon;
    }

    public void setHoaDon(HoaDonDTO hoaDon) {
        this.hoaDon = hoaDon;
    }

    public List<ChiTietHoaDonDTO> getChiTietHoaDonList() {
        return chiTietHoaDonList;
    }

    public void setChiTietHoaDonList(List<ChiTietHoaDonDTO> chiTietHoaDonList) {
        this.chiTietHoaDonList = chiTietHoaDonList;
    }
}
