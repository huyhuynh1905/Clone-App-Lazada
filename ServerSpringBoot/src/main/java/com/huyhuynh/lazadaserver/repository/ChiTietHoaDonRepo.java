package com.huyhuynh.lazadaserver.repository;

import com.huyhuynh.lazadaserver.model.ChiTietHoaDonEntity;
import com.huyhuynh.lazadaserver.model.ChiTietHoaDonId;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @project: lazadaserver
 * @author: HuyHuynh on 04/01/2021
 */
public interface ChiTietHoaDonRepo extends JpaRepository<ChiTietHoaDonEntity, ChiTietHoaDonId> {

}
