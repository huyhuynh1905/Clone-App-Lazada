package com.huyhuynh.lazadaserver.service;

import com.huyhuynh.lazadaserver.coverter.ChiTietHoaDonConverter;
import com.huyhuynh.lazadaserver.coverter.HoaDonConverter;
import com.huyhuynh.lazadaserver.dto.ChiTietHoaDonDTO;
import com.huyhuynh.lazadaserver.dto.HoaDonDTO;
import com.huyhuynh.lazadaserver.model.GioHangEntity;
import com.huyhuynh.lazadaserver.model.HoaDonEntity;
import com.huyhuynh.lazadaserver.repository.ChiTietHoaDonRepo;
import com.huyhuynh.lazadaserver.repository.GioHangRepo;
import com.huyhuynh.lazadaserver.repository.HoaDonRepo;
import com.huyhuynh.lazadaserver.service.impl.HoaDonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @project: lazadaserver
 * @author: HuyHuynh on 04/01/2021
 */
@Service
@Transactional
public class HoaDonService implements HoaDonServiceImpl {
    @Autowired
    HoaDonConverter converter;

    @Autowired
    ChiTietHoaDonConverter chiTietHoaDonConverter;

    @Autowired
    HoaDonRepo hoaDonRepo;

    @Autowired
    ChiTietHoaDonRepo chiTietHoaDonRepo;

    @Autowired
    GioHangRepo gioHangRepo;


    @Override
    public boolean themVaoHoaDon(HoaDonDTO hoaDonDTO, List<ChiTietHoaDonDTO> chiTietHoaDonList) {
        try{
            HoaDonEntity entity = converter.toHoaDonEntity(hoaDonDTO);
            Calendar calendar = Calendar.getInstance();
            Date ngaythem = calendar.getTime();
            calendar.set(Calendar.DATE,Calendar.DATE+3);
            Date ngaygiao = calendar.getTime();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            String ngaythemStr = sdf.format(ngaythem);
            String ngaygiaoStr = sdf.format(ngaygiao);
            entity.setNgaymua(ngaythemStr);
            entity.setNgaygiao(ngaygiaoStr);
            hoaDonRepo.save(entity);
            List<HoaDonEntity> hoaDonEntities = hoaDonRepo.findAll();
            int mahd = hoaDonEntities.get(hoaDonEntities.size()-1).getMahd();
            int manv = hoaDonEntities.get(0).getMahd();
            for (ChiTietHoaDonDTO dto: chiTietHoaDonList){
                dto.setMahd(mahd);
                chiTietHoaDonRepo.save(chiTietHoaDonConverter.toChiTietHoaDonEntity(dto));
            }
            //Xoá giỏ hàng:
            List<GioHangEntity> gioHangDel = gioHangRepo.findAllByManv(manv);
            for (GioHangEntity gioHangEntity: gioHangDel){
                gioHangRepo.delete(gioHangEntity);
            }
            return true;
        } catch (Exception e){
            System.out.println("Lỗi: "+e.toString());
            return false;
        }
    }
}
