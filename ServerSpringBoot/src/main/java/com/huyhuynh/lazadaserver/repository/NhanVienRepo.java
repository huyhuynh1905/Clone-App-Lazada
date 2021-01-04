package com.huyhuynh.lazadaserver.repository;

import com.huyhuynh.lazadaserver.model.NhanVienEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @project: lazadaserver
 * @author: HuyHuynh on 21/12/2020
 */
public interface NhanVienRepo extends JpaRepository<NhanVienEntity,Integer> {
    NhanVienEntity findAllByEmailAndMatkhau(String email, String matkhau);
    NhanVienEntity findByEmail(String email);
    NhanVienEntity findByManv(int manv);
}
