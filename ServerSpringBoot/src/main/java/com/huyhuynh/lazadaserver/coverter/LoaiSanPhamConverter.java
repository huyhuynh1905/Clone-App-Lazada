package com.huyhuynh.lazadaserver.coverter;

import com.huyhuynh.lazadaserver.dto.LoaiSanPhamDTO;
import com.huyhuynh.lazadaserver.model.LoaiSanPhamEntity;
import org.springframework.stereotype.Component;

/**
 * @project: lazadaserver
 * @author: HuyHuynh on 16/12/2020
 */
@Component
public class LoaiSanPhamConverter {
    public LoaiSanPhamDTO toLoaiSPDTO(LoaiSanPhamEntity entity){
        LoaiSanPhamDTO loaiSanPhamDTO = new LoaiSanPhamDTO();
        loaiSanPhamDTO.setMaloaisp(entity.getMaloaisp());
        loaiSanPhamDTO.setTenloaisp(entity.getTenloaisp());
        loaiSanPhamDTO.setMaloaicha(entity.getMaloaicha());
        return loaiSanPhamDTO;
    }
    public LoaiSanPhamEntity toLoaiSPEntity(LoaiSanPhamDTO loaiSanPhamDTO){
        LoaiSanPhamEntity loaiSanPhamEntity = new LoaiSanPhamEntity();
        loaiSanPhamEntity.setMaloaisp(loaiSanPhamDTO.getMaloaisp());
        loaiSanPhamEntity.setTenloaisp(loaiSanPhamDTO.getTenloaisp());
        loaiSanPhamEntity.setMaloaicha(loaiSanPhamDTO.getMaloaicha());
        return loaiSanPhamEntity;
    }
}
