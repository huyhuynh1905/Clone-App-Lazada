package com.huyhuynh.lazadaserver.coverter;

import com.huyhuynh.lazadaserver.dto.NhanVienDTO;
import com.huyhuynh.lazadaserver.dto.SanPhamDTO;
import com.huyhuynh.lazadaserver.model.LoaiNhanVienEntity;
import com.huyhuynh.lazadaserver.model.NhanVienEntity;
import com.huyhuynh.lazadaserver.model.SanPhamEntity;
import org.springframework.stereotype.Component;

/**
 * @project: lazadaserver
 * @author: HuyHuynh on 28/12/2020
 */
@Component
public class SanPhamConverter {
    public SanPhamDTO toSanPhamDTO(SanPhamEntity entity){
        SanPhamDTO sanPhamDTO = new SanPhamDTO();
        sanPhamDTO.setMasp(entity.getMasp());
        sanPhamDTO.setTensp(entity.getTensp());
        sanPhamDTO.setGia(entity.getGia());
        sanPhamDTO.setHinhlon(entity.getHinhlon());
        sanPhamDTO.setHinhnho(entity.getHinhnho());
        sanPhamDTO.setThongtin(entity.getThongtin());
        sanPhamDTO.setSoluong(entity.getSoluong());
        sanPhamDTO.setMath(entity.getMath());
        sanPhamDTO.setLuotmua(entity.getLuotmua());
        sanPhamDTO.setMaloaisp(entity.getLoaiSanPham().getMaloaisp());
        sanPhamDTO.setManv(entity.getNhanVien().getManv());
        return sanPhamDTO;
    }
    public SanPhamEntity toSanPhamEntity(SanPhamDTO sanPhamDTO){
        SanPhamEntity entity = new SanPhamEntity();
        entity.setMasp(sanPhamDTO.getMasp());
        entity.setTensp(sanPhamDTO.getTensp());
        entity.setGia(sanPhamDTO.getGia());
        entity.setHinhlon(sanPhamDTO.getHinhlon());
        entity.setHinhnho(sanPhamDTO.getHinhnho());
        entity.setThongtin(sanPhamDTO.getThongtin());
        entity.setSoluong(sanPhamDTO.getSoluong());
        entity.setMath(sanPhamDTO.getMath());
        entity.setLuotmua(sanPhamDTO.getLuotmua());
        return entity;
    }
}
