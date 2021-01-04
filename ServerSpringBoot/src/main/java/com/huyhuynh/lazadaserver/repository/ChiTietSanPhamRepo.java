package com.huyhuynh.lazadaserver.repository;

import com.huyhuynh.lazadaserver.model.ChiTietSanPhamEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @project: lazadaserver
 * @author: HuyHuynh on 31/12/2020
 */
public interface ChiTietSanPhamRepo extends JpaRepository<ChiTietSanPhamEntity,Integer> {
    List<ChiTietSanPhamEntity> findAllByMasp(int masp);
}
