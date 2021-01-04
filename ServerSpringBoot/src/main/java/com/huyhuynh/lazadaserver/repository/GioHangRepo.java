package com.huyhuynh.lazadaserver.repository;

import com.huyhuynh.lazadaserver.model.GioHangEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.*;

/**
 * @project: lazadaserver
 * @author: HuyHuynh on 02/01/2021
 */
public interface GioHangRepo extends JpaRepository<GioHangEntity,Integer> {
    List<GioHangEntity> findAllByManv(int manv);
    List<GioHangEntity> findAllByManvAndMasp(int manv, int masp);
}
