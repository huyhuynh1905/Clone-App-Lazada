package com.huyhuynh.lazadaserver.repository;

import com.huyhuynh.lazadaserver.model.LoaiSanPhamEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @project: lazadaserver
 * @author: HuyHuynh on 16/12/2020
 */
public interface LoaiSanPhamRepo extends JpaRepository<LoaiSanPhamEntity,Integer> {
    List<LoaiSanPhamEntity> findAllByMaloaicha(int maloaicha);
    List<LoaiSanPhamEntity> findAll();
    List<LoaiSanPhamEntity> findAllByMaloaisp(int maloaisp);
}
