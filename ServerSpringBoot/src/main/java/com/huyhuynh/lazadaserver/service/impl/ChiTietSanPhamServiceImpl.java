package com.huyhuynh.lazadaserver.service.impl;

import com.huyhuynh.lazadaserver.dto.ChiTietSanPhamDTO;

import java.util.List;

/**
 * @project: lazadaserver
 * @author: HuyHuynh on 31/12/2020
 */
public interface ChiTietSanPhamServiceImpl {
    List<ChiTietSanPhamDTO> getAllChiTietSanPhamByMasp(int masp);
}
