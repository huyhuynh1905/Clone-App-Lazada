package com.huyhuynh.lazadaserver.repository;

import com.huyhuynh.lazadaserver.model.ChiTietThuongHieu;
import com.huyhuynh.lazadaserver.model.ChiTietThuongHieuId;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @project: lazadaserver
 * @author: HuyHuynh on 29/12/2020
 */
public interface ChiTietThuongHieuRepo extends JpaRepository<ChiTietThuongHieu, ChiTietThuongHieuId> {
}
