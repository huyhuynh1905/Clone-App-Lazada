package com.huyhuynh.lazadaserver.service;

import com.huyhuynh.lazadaserver.model.ChiTietThuongHieu;
import com.huyhuynh.lazadaserver.repository.ChiTietThuongHieuRepo;
import com.huyhuynh.lazadaserver.service.impl.ChiTietThuongHieuServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @project: lazadaserver
 * @author: HuyHuynh on 29/12/2020
 */
@Service
@Transactional
public class ChiTietThuongHieuService implements ChiTietThuongHieuServiceImpl {

    @Autowired
    ChiTietThuongHieuRepo chiTietThuongHieuRepo;

    @Override
    public List<ChiTietThuongHieu> getAllChiTietThuongHieu() {
        List<ChiTietThuongHieu> chiTietThuongHieus = chiTietThuongHieuRepo.findAll();
        return chiTietThuongHieus;
    }
}
