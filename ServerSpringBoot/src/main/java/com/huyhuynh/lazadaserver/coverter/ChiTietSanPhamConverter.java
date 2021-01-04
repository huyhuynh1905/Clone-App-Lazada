package com.huyhuynh.lazadaserver.coverter;

import com.huyhuynh.lazadaserver.dto.ChiTietSanPhamDTO;
import com.huyhuynh.lazadaserver.model.ChiTietSanPhamEntity;
import org.springframework.stereotype.Component;

/**
 * @project: lazadaserver
 * @author: HuyHuynh on 31/12/2020
 */
@Component
public class ChiTietSanPhamConverter {
    public ChiTietSanPhamDTO toChiTietSanPhamDTO(ChiTietSanPhamEntity entity){
        ChiTietSanPhamDTO dto = new ChiTietSanPhamDTO();
        dto.setMachitiet(entity.getMachitiet());
        dto.setMasp(entity.getMasp());
        dto.setTenchitiet(entity.getTenchitiet());
        dto.setGiatri(entity.getGiatri());
        return dto;
    }

    public ChiTietSanPhamEntity toChiTietSanPhamEntity(ChiTietSanPhamDTO dto){
        ChiTietSanPhamEntity entity = new ChiTietSanPhamEntity();
        entity.setMachitiet(dto.getMachitiet());
        entity.setMasp(dto.getMasp());
        entity.setTenchitiet(dto.getTenchitiet());
        entity.setGiatri(dto.getGiatri());
        return entity;
    }
}
