package com.huyhuynh.lazadaserver.api;

import com.huyhuynh.lazadaserver.dto.SanPhamDTO;
import com.huyhuynh.lazadaserver.service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @project: lazadaserver
 * @author: HuyHuynh on 28/12/2020
 */
@RestController
@CrossOrigin
public class SanPhamAPI {

    @Autowired
    SanPhamService sanPhamService;

    @GetMapping(value = "/getallsanpham")
    public List<SanPhamDTO> getAllSanPham(){
        return sanPhamService.getAllSanPham();
    }

    @GetMapping(value = "/timkiemsanpham")
    public List<SanPhamDTO> timKiemSanPham(@RequestParam("tentimkiem") String tentimkiem){
        return sanPhamService.timKiemSanPham(tentimkiem);
    }
}
