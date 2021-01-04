package com.huyhuynh.lazadaserver.service;

import com.huyhuynh.lazadaserver.coverter.SanPhamConverter;
import com.huyhuynh.lazadaserver.dto.SanPhamDTO;
import com.huyhuynh.lazadaserver.model.SanPhamEntity;
import com.huyhuynh.lazadaserver.repository.SanPhamRepo;
import com.huyhuynh.lazadaserver.service.impl.SanPhamServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @project: lazadaserver
 * @author: HuyHuynh on 28/12/2020
 */
@Service
@Transactional
public class SanPhamService implements SanPhamServiceImpl {

    @Autowired
    SanPhamRepo sanPhamRepo;

    @Autowired
    SanPhamConverter sanPhamConverter;

    @Override
    public List<SanPhamDTO> getAllSanPham() {
        List<SanPhamEntity> sanPhamEntityList = sanPhamRepo.findAll();
        List<SanPhamDTO> sanPhamDTOList = new ArrayList<>();
        for (SanPhamEntity sanPhamEntity : sanPhamEntityList){
            sanPhamDTOList.add(sanPhamConverter.toSanPhamDTO(sanPhamEntity));
        }
        return sanPhamDTOList;
    }

    @Override
    public List<SanPhamDTO> timKiemSanPham(String tentimkiem) {
        List<SanPhamDTO> dtoList = new ArrayList<>();
        List<SanPhamEntity> entities = sanPhamRepo.findAllByTenspContaining(tentimkiem);
        for (SanPhamEntity entity : entities){
            dtoList.add(sanPhamConverter.toSanPhamDTO(entity));
        }
        return dtoList;
    }
}
