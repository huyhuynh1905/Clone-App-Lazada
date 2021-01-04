package com.huyhuynh.lazadaserver.service;

import com.huyhuynh.lazadaserver.model.ThuongHieuEntity;
import com.huyhuynh.lazadaserver.repository.ThuongHieuRepo;
import com.huyhuynh.lazadaserver.service.impl.ThuongHieuServiceImpl;
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
public class ThuongHieuService implements ThuongHieuServiceImpl {

    @Autowired
    ThuongHieuRepo thuongHieuRepo;

    @Override
    public List<ThuongHieuEntity> getAllThuongHieu() {
        List<ThuongHieuEntity> thuongHieuEntities = thuongHieuRepo.findAll();
        return thuongHieuEntities;
    }
}
