package com.huyhuynh.lazadaserver.coverter;

import com.huyhuynh.lazadaserver.dto.ThuongHieuDTO;
import com.huyhuynh.lazadaserver.model.ThuongHieuEntity;
import org.springframework.stereotype.Component;

/**
 * @project: lazadaserver
 * @author: HuyHuynh on 28/12/2020
 */

@Component
public class ThuongHieuConverter {
    public ThuongHieuDTO toThuongHieuDTO (ThuongHieuEntity entity){
        ThuongHieuDTO thuongHieuDTO = new ThuongHieuDTO();
        thuongHieuDTO.setMath(entity.getMath());
        thuongHieuDTO.setTenth(entity.getTenth());
        thuongHieuDTO.setLuotmua(entity.getLuotmua());
        return thuongHieuDTO;
    }
    public ThuongHieuEntity toThuongHieuEntity (ThuongHieuDTO thuongHieuDTO){
        ThuongHieuEntity entity = new ThuongHieuEntity();
        entity.setMath(thuongHieuDTO.getMath());
        entity.setTenth(thuongHieuDTO.getTenth());
        entity.setLuotmua(thuongHieuDTO.getLuotmua());
        return entity;
    }
}
