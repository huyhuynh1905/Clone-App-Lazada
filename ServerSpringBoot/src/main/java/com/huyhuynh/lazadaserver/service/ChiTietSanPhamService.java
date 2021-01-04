package com.huyhuynh.lazadaserver.service;

import com.huyhuynh.lazadaserver.coverter.ChiTietSanPhamConverter;
import com.huyhuynh.lazadaserver.dto.ChiTietSanPhamDTO;
import com.huyhuynh.lazadaserver.model.ChiTietSanPhamEntity;
import com.huyhuynh.lazadaserver.repository.ChiTietSanPhamRepo;
import com.huyhuynh.lazadaserver.service.impl.ChiTietSanPhamServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @project: lazadaserver
 * @author: HuyHuynh on 31/12/2020
 */
@Service
@Transactional
public class ChiTietSanPhamService implements ChiTietSanPhamServiceImpl {
    @Autowired
    ChiTietSanPhamConverter chiTietSanPhamConverter;
    @Autowired
    ChiTietSanPhamRepo chiTietSanPhamRepo;

    @Override
    public List<ChiTietSanPhamDTO> getAllChiTietSanPhamByMasp(int masp) {
        List<ChiTietSanPhamEntity> chiTietSanPhamEntities = chiTietSanPhamRepo.findAllByMasp(masp);
        List<ChiTietSanPhamDTO> chiTietSanPhamDTOS =new ArrayList<>();
        for (ChiTietSanPhamEntity ctsp : chiTietSanPhamEntities){
            chiTietSanPhamDTOS.add(chiTietSanPhamConverter.toChiTietSanPhamDTO(ctsp));
        }
        return chiTietSanPhamDTOS;
    }
}
