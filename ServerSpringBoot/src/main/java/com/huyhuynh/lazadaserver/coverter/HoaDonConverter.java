package com.huyhuynh.lazadaserver.coverter;

import com.huyhuynh.lazadaserver.dto.HoaDonDTO;
import com.huyhuynh.lazadaserver.model.HoaDonEntity;
import org.springframework.stereotype.Component;

/**
 * @project: lazadaserver
 * @author: HuyHuynh on 04/01/2021
 */
@Component
public class HoaDonConverter {
    public HoaDonDTO toHoaDonDTO(HoaDonEntity entity){
        HoaDonDTO dto = new HoaDonDTO();
        dto.setMahd(entity.getMahd());
        dto.setNgaymua(entity.getNgaymua());
        dto.setNgaygiao(entity.getNgaygiao());
        dto.setDiachi(entity.getDiachi());
        dto.setSodt(entity.getSodt());
        dto.setTennguoinhan(entity.getTennguoinhan());
        dto.setChuyenkhoan(entity.getChuyenkhoan());
        dto.setMachuyenkhoan(entity.getMachuyenkhoan());
        dto.setTrangthai(entity.getTrangthai());
        return dto;
    }
    public HoaDonEntity toHoaDonEntity(HoaDonDTO dto){
        HoaDonEntity entity = new HoaDonEntity();
        entity.setMahd(dto.getMahd());
        entity.setNgaymua(dto.getNgaymua());
        entity.setNgaygiao(dto.getNgaygiao());
        entity.setDiachi(dto.getDiachi());
        entity.setSodt(dto.getSodt());
        entity.setTennguoinhan(dto.getTennguoinhan());
        entity.setChuyenkhoan(dto.getChuyenkhoan());
        entity.setMachuyenkhoan(dto.getMachuyenkhoan());
        entity.setTrangthai(dto.getTrangthai());
        return entity;
    }
}
