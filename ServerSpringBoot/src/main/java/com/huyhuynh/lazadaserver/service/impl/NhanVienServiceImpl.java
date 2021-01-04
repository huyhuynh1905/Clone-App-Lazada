package com.huyhuynh.lazadaserver.service.impl;

import com.huyhuynh.lazadaserver.dto.NhanVienDTO;
import com.huyhuynh.lazadaserver.model.NhanVienEntity;

/**
 * @project: lazadaserver
 * @author: HuyHuynh on 21/12/2020
 */
public interface NhanVienServiceImpl {
    boolean themNhanVien(String tennv, String email, String matkhau, boolean nhanEmail);
    NhanVienDTO dangNhapVoiEmailVaMatKhau(String email, String matkhau);
    String layTenNhanVien(int manv);
}
