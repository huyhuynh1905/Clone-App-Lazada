package com.huyhuynh.lazadaserver.service.impl;

import com.huyhuynh.lazadaserver.dto.GioHangDTO;

import java.util.*;

/**
 * @project: lazadaserver
 * @author: HuyHuynh on 02/01/2021
 */
public interface GioHangServiceImpl {
    List<GioHangDTO> getAllGioHangByManv(int manv);
    boolean themGioHang(GioHangDTO gioHangDTO);
    boolean xoaGioHang(GioHangDTO gioHangDTO);
    boolean giamSoLuong(GioHangDTO gioHangDTO);
}
