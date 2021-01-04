package com.huyhuynh.lazadaserver.service;

import com.huyhuynh.lazadaserver.coverter.NhanVienConverter;
import com.huyhuynh.lazadaserver.dto.NhanVienDTO;
import com.huyhuynh.lazadaserver.model.LoaiNhanVienEntity;
import com.huyhuynh.lazadaserver.model.NhanVienEntity;
import com.huyhuynh.lazadaserver.repository.NhanVienRepo;
import com.huyhuynh.lazadaserver.service.impl.NhanVienServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @project: lazadaserver
 * @author: HuyHuynh on 21/12/2020
 */
@Service
@Transactional
public class NhanVienService implements NhanVienServiceImpl {

    @Autowired
    NhanVienRepo nhanVienRepo;

    @Autowired
    NhanVienConverter nhanVienConverter;


    @Override
    public boolean themNhanVien(String tennv, String email, String matkhau, boolean nhanEmail) {
        NhanVienEntity nhanVienEntity = new NhanVienEntity(tennv,email,matkhau,nhanEmail);
        nhanVienEntity.setLoaiNhanVien(new LoaiNhanVienEntity(2));
        NhanVienEntity nhanVienCheck = nhanVienRepo.findByEmail(email);
        if (nhanVienCheck!=null){
            return false;
        } else {
            nhanVienRepo.save(nhanVienEntity);
            return true;
        }

    }

    @Override
    public NhanVienDTO dangNhapVoiEmailVaMatKhau(String email, String matkhau) {
        NhanVienEntity nhanVienEntity = nhanVienRepo.findAllByEmailAndMatkhau(email,matkhau);
        return nhanVienConverter.toNhanVienDTO(nhanVienEntity);
    }

    @Override
    public String layTenNhanVien(int manv) {
        NhanVienEntity nhanVienEntity = nhanVienRepo.findByManv(manv);
        String tennv = nhanVienEntity.getTennv();
        return tennv;
    }
}
