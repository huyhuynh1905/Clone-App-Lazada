package com.huyhuynh.lazadaserver.service.impl;

import com.huyhuynh.lazadaserver.dto.SanPhamDTO;

import java.util.List;

/**
 * @project: lazadaserver
 * @author: HuyHuynh on 28/12/2020
 */
public interface SanPhamServiceImpl {
    List<SanPhamDTO> getAllSanPham();
    List<SanPhamDTO> timKiemSanPham(String tentimkiem);
}
