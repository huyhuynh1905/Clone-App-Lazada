package com.huyhuynh.lazadaserver.repository;

import com.huyhuynh.lazadaserver.model.DanhGiaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
/**
 * @project: lazadaserver
 * @author: HuyHuynh on 01/01/2021
 */
public interface DanhGiaRepo extends JpaRepository<DanhGiaEntity,String> {
    List<DanhGiaEntity> getAllByMasp(int masp);
}
