package com.huyhuynh.lazadaserver.service.impl;

import com.huyhuynh.lazadaserver.dto.LoaiSanPhamDTO;
import com.huyhuynh.lazadaserver.model.LoaiSanPhamEntity;

import java.util.List;

/**
 * @project: lazadaserver
 * @author: HuyHuynh on 16/12/2020
 */
public interface LoaiSanPhamServiceImpl {

    List<LoaiSanPhamDTO> getAllLoaiSanPhamByMaLoaiCha(Integer maloaicha);
    List<LoaiSanPhamDTO> getAllLoaiSanPham();
    List<LoaiSanPhamDTO> getAllLoaiSanPhamByMaLoaiSp(Integer maloaisp);
}
