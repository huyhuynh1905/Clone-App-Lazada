package com.huyhuynh.lazadaserver.api;

import com.huyhuynh.lazadaserver.dto.NhanVienDTO;
import com.huyhuynh.lazadaserver.service.NhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @project: lazadaserver
 * @author: HuyHuynh on 21/12/2020
 */

@RestController
@CrossOrigin
public class LoginAPI {

    @Autowired
    NhanVienService nhanVienService;


    @PostMapping(value = "/dangnhap")
    public NhanVienDTO dangNhap(String email, String matkhau){
        try{
            NhanVienDTO nhanVienDTO = nhanVienService.dangNhapVoiEmailVaMatKhau(email,matkhau);
            return nhanVienDTO;
        } catch (Exception e){
            return null;
        }
    }
}
