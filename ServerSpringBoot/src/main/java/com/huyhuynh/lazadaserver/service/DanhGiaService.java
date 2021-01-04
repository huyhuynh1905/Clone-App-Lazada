package com.huyhuynh.lazadaserver.service;

import com.huyhuynh.lazadaserver.coverter.DanhGiaConverter;
import com.huyhuynh.lazadaserver.dto.DanhGiaDTO;
import com.huyhuynh.lazadaserver.model.DanhGiaEntity;
import com.huyhuynh.lazadaserver.repository.DanhGiaRepo;
import com.huyhuynh.lazadaserver.service.impl.DanhGiaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @project: lazadaserver
 * @author: HuyHuynh on 01/01/2021
 */
@Service
@Transactional
public class DanhGiaService implements DanhGiaServiceImpl {
    @Autowired
    DanhGiaConverter converter;
    @Autowired
    DanhGiaRepo danhGiaRepo;

    @Override
    public boolean themDanhGia(DanhGiaDTO danhGiaDTO) {
        try{
            Calendar cal = Calendar.getInstance();
            Date date = cal.getTime();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            String ngaydanhgia = sdf.format(date);
            danhGiaDTO.setNgaydanhgia(ngaydanhgia);
            danhGiaRepo.save(converter.toDanhGiaEntity(danhGiaDTO));
            return true;
        } catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<DanhGiaDTO> gettAllDanhGiaByMasp(int masp) {
        List<DanhGiaEntity> danhGiaEntityList = danhGiaRepo.getAllByMasp(masp);
        List<DanhGiaDTO> danhGiaDTOS = new ArrayList<>();
        for (DanhGiaEntity danhGiaEntity : danhGiaEntityList){
            danhGiaDTOS.add(converter.toDanhGiaDTO(danhGiaEntity));
        }
        return danhGiaDTOS;
    }
}
