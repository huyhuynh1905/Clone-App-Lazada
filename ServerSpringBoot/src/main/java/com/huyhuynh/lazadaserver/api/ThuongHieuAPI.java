package com.huyhuynh.lazadaserver.api;

import com.huyhuynh.lazadaserver.model.ChiTietThuongHieu;
import com.huyhuynh.lazadaserver.model.ThuongHieuEntity;
import com.huyhuynh.lazadaserver.payload.ThuongHieuPayload;
import com.huyhuynh.lazadaserver.service.ChiTietThuongHieuService;
import com.huyhuynh.lazadaserver.service.ThuongHieuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @project: lazadaserver
 * @author: HuyHuynh on 29/12/2020
 */
@RestController
@CrossOrigin
public class ThuongHieuAPI {

    @Autowired
    ChiTietThuongHieuService chiTietThuongHieuService;

    @Autowired
    ThuongHieuService thuongHieuService;

    @GetMapping(value = "/getallthuonghieu")
    public List<ThuongHieuPayload> getAllThuongHieu(){
        List<ThuongHieuPayload> thuongHieuPayloads = new ArrayList<>();
        List<ThuongHieuEntity> thuongHieuEntities = thuongHieuService.getAllThuongHieu();
        List<ChiTietThuongHieu> chiTietThuongHieus = chiTietThuongHieuService.getAllChiTietThuongHieu();
        for (ChiTietThuongHieu cth : chiTietThuongHieus){
            ThuongHieuPayload thuongHieuPayload = new ThuongHieuPayload();
            thuongHieuPayload.setMath(cth.getMath());
            thuongHieuPayload.setTenth(thuongHieuEntities.get(cth.getMath()-1).getTenth());
            thuongHieuPayload.setHinhthuonghieu(cth.getHinhthuonghieu());
            thuongHieuPayload.setLuotmua(thuongHieuEntities.get(cth.getMath()-1).getLuotmua());
            thuongHieuPayloads.add(thuongHieuPayload);
        }
        return thuongHieuPayloads;
    }
}
