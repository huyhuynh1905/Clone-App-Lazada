package com.huyhuynh.lazadaserver.coverter;

import com.huyhuynh.lazadaserver.dto.ChiTietHoaDonDTO;
import com.huyhuynh.lazadaserver.model.ChiTietHoaDonEntity;
import org.springframework.stereotype.Component;

/**
 * @project: lazadaserver
 * @author: HuyHuynh on 04/01/2021
 */
@Component
public class ChiTietHoaDonConverter {
    public ChiTietHoaDonDTO toChiTietHoaDonDTO(ChiTietHoaDonEntity entity){
        ChiTietHoaDonDTO dto = new ChiTietHoaDonDTO();
        dto.setMahd(entity.getMahd());
        dto.setMasp(entity.getMasp());
        dto.setSoluong(entity.getSoluong());
        return dto;
    }

    public ChiTietHoaDonEntity toChiTietHoaDonEntity(ChiTietHoaDonDTO dto){
        ChiTietHoaDonEntity entity = new ChiTietHoaDonEntity();
        entity.setMahd(dto.getMahd());
        entity.setMasp(dto.getMasp());
        entity.setSoluong(dto.getSoluong());
        return entity;
    }
}
