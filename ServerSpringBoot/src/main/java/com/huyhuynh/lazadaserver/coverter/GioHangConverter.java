package com.huyhuynh.lazadaserver.coverter;

import com.huyhuynh.lazadaserver.dto.GioHangDTO;
import com.huyhuynh.lazadaserver.model.GioHangEntity;
import org.springframework.stereotype.Component;

/**
 * @project: lazadaserver
 * @author: HuyHuynh on 02/01/2021
 */
@Component
public class GioHangConverter {
    public GioHangDTO toGioHangDTO(GioHangEntity entity){
        GioHangDTO dto = new GioHangDTO();
        dto.setMagiohang(entity.getMagiohang());
        dto.setManv(entity.getManv());
        dto.setMasp(entity.getMasp());
        dto.setTensp(entity.getTensp());
        dto.setGiatien(entity.getGiatien());
        dto.setHinhanh(entity.getHinhanh());
        dto.setSoluong(entity.getSoluong());
        return dto;
    }

    public GioHangEntity toGioHangEntity(GioHangDTO dto){
        GioHangEntity entity = new GioHangEntity();
        entity.setMagiohang(dto.getMagiohang());
        entity.setManv(dto.getManv());
        entity.setMasp(dto.getMasp());
        entity.setTensp(dto.getTensp());
        entity.setGiatien(dto.getGiatien());
        entity.setHinhanh(dto.getHinhanh());
        entity.setSoluong(dto.getSoluong());
        return entity;
    }
}
