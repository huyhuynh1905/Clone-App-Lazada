package com.huyhuynh.lazadaserver.repository;

import com.huyhuynh.lazadaserver.model.SanPhamEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @project: lazadaserver
 * @author: HuyHuynh on 28/12/2020
 */
public interface SanPhamRepo extends JpaRepository<SanPhamEntity,Integer> {

    List<SanPhamEntity> findAllByTenspContaining(String name);

}
