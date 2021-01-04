package com.huyhuynh.lazadaserver.service;

import com.huyhuynh.lazadaserver.coverter.GioHangConverter;
import com.huyhuynh.lazadaserver.dto.GioHangDTO;
import com.huyhuynh.lazadaserver.model.GioHangEntity;
import com.huyhuynh.lazadaserver.repository.GioHangRepo;
import com.huyhuynh.lazadaserver.service.impl.GioHangServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @project: lazadaserver
 * @author: HuyHuynh on 02/01/2021
 */
@Service
@Transactional
public class GioHangService implements GioHangServiceImpl {

    @Autowired
    GioHangConverter converter;

    @Autowired
    GioHangRepo gioHangRepo;

    @Override
    public List<GioHangDTO> getAllGioHangByManv(int manv) {
        List<GioHangEntity> gioHangEntities = gioHangRepo.findAllByManv(manv);
        List<GioHangDTO> gioHangDTOS = new ArrayList<>();
        for (GioHangEntity gioHangEntity : gioHangEntities){
            gioHangDTOS.add(converter.toGioHangDTO(gioHangEntity));
        }
        return gioHangDTOS;
    }

    @Override
    public boolean themGioHang(GioHangDTO gioHangDTO) {
        GioHangEntity entity = new GioHangEntity(gioHangDTO.getManv(),gioHangDTO.getMasp(),gioHangDTO.getTensp(),
                gioHangDTO.getGiatien(),gioHangDTO.getHinhanh(),gioHangDTO.getSoluong());
        List<GioHangEntity> gioHangEntityList = gioHangRepo.findAllByManvAndMasp(gioHangDTO.getManv(),
                gioHangDTO.getMasp());
        if (gioHangEntityList.size()>0) {
            for (int i=0;i<gioHangEntityList.size();i++){
                if (gioHangEntityList.get(i).getMasp()==gioHangDTO.getMasp()){
                    entity.setMagiohang(gioHangEntityList.get(i).getMagiohang());
                    int giatien = gioHangEntityList.get(i).getGiatien()+gioHangDTO.getGiatien();
                    int soluong = gioHangEntityList.get(i).getSoluong()+gioHangDTO.getSoluong();
                    entity.setGiatien(giatien);
                    entity.setSoluong(soluong);
                    gioHangRepo.save(entity);
                    return true;
                }
            }
        } else {
            gioHangRepo.save(entity);
            System.out.println();
            return true;
        }
        return false;
    }

    @Override
    public boolean xoaGioHang(GioHangDTO gioHangDTO) {
        try{
            gioHangRepo.delete(converter.toGioHangEntity(gioHangDTO));
            return true;
        } catch (Exception e){
            System.out.println("Lỗi xoá!");
            return false;
        }
    }

    @Override
    public boolean giamSoLuong(GioHangDTO gioHangDTO) {
        GioHangEntity entity = new GioHangEntity(gioHangDTO.getManv(),gioHangDTO.getMasp(),gioHangDTO.getTensp(),
                gioHangDTO.getGiatien(),gioHangDTO.getHinhanh(),gioHangDTO.getSoluong());
        List<GioHangEntity> gioHangEntityList = gioHangRepo.findAllByManvAndMasp(gioHangDTO.getManv(),
                gioHangDTO.getMasp());
        if (gioHangEntityList.size()>0) {
            for (int i=0;i<gioHangEntityList.size();i++){
                if (gioHangEntityList.get(i).getMasp()==gioHangDTO.getMasp()){
                    entity.setMagiohang(gioHangEntityList.get(i).getMagiohang());
                    int giatien = gioHangEntityList.get(i).getGiatien()-gioHangDTO.getGiatien();
                    int soluong = gioHangEntityList.get(i).getSoluong()-gioHangDTO.getSoluong();
                    entity.setGiatien(giatien);
                    entity.setSoluong(soluong);
                    gioHangRepo.save(entity);
                    return true;
                }
            }
        } else {
            gioHangRepo.save(entity);
            System.out.println();
            return true;
        }
        return false;
    }
}
