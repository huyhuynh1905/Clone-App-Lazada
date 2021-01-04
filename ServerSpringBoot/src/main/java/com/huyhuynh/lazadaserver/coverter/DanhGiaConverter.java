package com.huyhuynh.lazadaserver.coverter;

import com.huyhuynh.lazadaserver.dto.DanhGiaDTO;
import com.huyhuynh.lazadaserver.dto.LoaiSanPhamDTO;
import com.huyhuynh.lazadaserver.model.DanhGiaEntity;
import com.huyhuynh.lazadaserver.model.LoaiSanPhamEntity;
import org.springframework.stereotype.Component;

/**
 * @project: lazadaserver
 * @author: HuyHuynh on 01/01/2021
 */
@Component
public class DanhGiaConverter {
    public DanhGiaDTO toDanhGiaDTO(DanhGiaEntity entity){
        DanhGiaDTO dto = new DanhGiaDTO();
        dto.setMadg(entity.getMadg());
        dto.setNgaydanhgia(entity.getNgaydanhgia());
        dto.setTieude(entity.getTieude());
        dto.setTenthietbi(entity.getTenthietbi());
        dto.setSosao(entity.getSosao());
        dto.setMasp(entity.getMasp());
        dto.setNoidung(entity.getNoidung());
        return dto;
    }
    public DanhGiaEntity toDanhGiaEntity(DanhGiaDTO dto){
        DanhGiaEntity entity = new DanhGiaEntity();
        entity.setMadg(dto.getMadg());
        entity.setNgaydanhgia(dto.getNgaydanhgia());
        entity.setTieude(dto.getTieude());
        entity.setTenthietbi(dto.getTenthietbi());
        entity.setSosao(dto.getSosao());
        entity.setMasp(dto.getMasp());
        entity.setNoidung(dto.getNoidung());
        return entity;
    }
}
