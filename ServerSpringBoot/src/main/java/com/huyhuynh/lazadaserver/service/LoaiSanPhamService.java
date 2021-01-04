package com.huyhuynh.lazadaserver.service;

import com.huyhuynh.lazadaserver.coverter.LoaiSanPhamConverter;
import com.huyhuynh.lazadaserver.dto.LoaiSanPhamDTO;
import com.huyhuynh.lazadaserver.model.LoaiSanPhamEntity;
import com.huyhuynh.lazadaserver.repository.LoaiSanPhamRepo;
import com.huyhuynh.lazadaserver.service.impl.LoaiSanPhamServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @project: lazadaserver
 * @author: HuyHuynh on 16/12/2020
 */
@Service
@Transactional
public class LoaiSanPhamService implements LoaiSanPhamServiceImpl {

    @Autowired
    private LoaiSanPhamRepo loaiSanPhamRepo;

    @Autowired
    private LoaiSanPhamConverter converter;


    @Override
    public List<LoaiSanPhamDTO> getAllLoaiSanPhamByMaLoaiCha(Integer maloaicha) {
        List<LoaiSanPhamEntity> loaiSanPhamEntities = loaiSanPhamRepo.findAllByMaloaicha(maloaicha);
        List<LoaiSanPhamDTO> loaiSanPhamDTOS = new ArrayList<>();
        for (LoaiSanPhamEntity entity:loaiSanPhamEntities ){
            loaiSanPhamDTOS.add(converter.toLoaiSPDTO(entity));
        }
        return loaiSanPhamDTOS;
    }

    @Override
    public List<LoaiSanPhamDTO> getAllLoaiSanPham() {
        List<LoaiSanPhamEntity> loaiSanPhamEntities = loaiSanPhamRepo.findAll();
        List<LoaiSanPhamDTO> loaiSanPhamDTOS = new ArrayList<>();
        for (LoaiSanPhamEntity entity:loaiSanPhamEntities ){
            loaiSanPhamDTOS.add(converter.toLoaiSPDTO(entity));
        }
        return loaiSanPhamDTOS;
    }

    @Override
    public List<LoaiSanPhamDTO> getAllLoaiSanPhamByMaLoaiSp(Integer maloaisp) {
        List<LoaiSanPhamEntity> loaiSanPhamEntities = loaiSanPhamRepo.findAllByMaloaisp(maloaisp);
        List<LoaiSanPhamDTO> loaiSanPhamDTOS = new ArrayList<>();
        for (LoaiSanPhamEntity entity : loaiSanPhamEntities) {
            loaiSanPhamDTOS.add(converter.toLoaiSPDTO(entity));
        }
        return loaiSanPhamDTOS;
    }
}
