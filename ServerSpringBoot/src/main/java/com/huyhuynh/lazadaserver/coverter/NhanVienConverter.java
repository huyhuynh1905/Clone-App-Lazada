package com.huyhuynh.lazadaserver.coverter;

import com.huyhuynh.lazadaserver.dto.NhanVienDTO;
import com.huyhuynh.lazadaserver.model.LoaiNhanVienEntity;
import com.huyhuynh.lazadaserver.model.NhanVienEntity;
import org.springframework.stereotype.Component;


/**
 * @project: lazadaserver
 * @author: HuyHuynh on 21/12/2020
 */
@Component
public class NhanVienConverter {
    public NhanVienDTO toNhanVienDTO(NhanVienEntity entity){
        NhanVienDTO nhanVienDTO = new NhanVienDTO();
        nhanVienDTO.setManv(entity.getManv());
        nhanVienDTO.setTennv(entity.getTennv());
        nhanVienDTO.setTendn(entity.getTendn());
        nhanVienDTO.setEmail(entity.getEmail());
        nhanVienDTO.setDiachi(entity.getDiachi());
        nhanVienDTO.setMatkhau(entity.getMatkhau());
        nhanVienDTO.setNhanemail(entity.isNhanemail());
        nhanVienDTO.setGioitinh(entity.getGioitinh());
        nhanVienDTO.setNgaysinh(entity.getNgaysinh());
        nhanVienDTO.setSodt(entity.getSodt());
        if (entity.getLoaiNhanVien().getMaloainv()==1){
            nhanVienDTO.setLoaiNhanVien(1);
        } else {
            nhanVienDTO.setLoaiNhanVien(2);
        }
        return nhanVienDTO;
    }
    public NhanVienEntity toNhanVienEntity(NhanVienDTO nhanVienDTO){
        NhanVienEntity entity = new NhanVienEntity();
        entity.setManv(nhanVienDTO.getManv());
        entity.setTennv(nhanVienDTO.getTennv());
        entity.setTendn(nhanVienDTO.getTendn());
        entity.setEmail(nhanVienDTO.getEmail());
        entity.setDiachi(nhanVienDTO.getDiachi());
        entity.setMatkhau(nhanVienDTO.getMatkhau());
        entity.setNhanemail(nhanVienDTO.isNhanemail());
        entity.setGioitinh(nhanVienDTO.getGioitinh());
        entity.setNgaysinh(nhanVienDTO.getNgaysinh());
        entity.setSodt(nhanVienDTO.getSodt());
        if (nhanVienDTO.getLoaiNhanVien()==1){
            entity.setLoaiNhanVien(new LoaiNhanVienEntity(1));
        } else {
            entity.setLoaiNhanVien(new LoaiNhanVienEntity(2));
        }
        return entity;
    }
}
