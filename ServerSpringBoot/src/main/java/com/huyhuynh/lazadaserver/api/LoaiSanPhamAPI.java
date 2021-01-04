package com.huyhuynh.lazadaserver.api;

import com.huyhuynh.lazadaserver.dto.LoaiSanPhamDTO;
import com.huyhuynh.lazadaserver.service.LoaiSanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @project: lazadaserver
 * @author: HuyHuynh on 16/12/2020
 */

@CrossOrigin
@RestController
public class LoaiSanPhamAPI {

    @Autowired
    private LoaiSanPhamService loaiSanPhamService;

    @GetMapping(value = "/getbymaloaicha={maloaicha}")
    public List<LoaiSanPhamDTO> getAllByMaLoaiCha(@PathVariable Integer maloaicha){
        return loaiSanPhamService.getAllLoaiSanPhamByMaLoaiCha(maloaicha);
    }
    @GetMapping(value = "/getbymaloaisp={maloaisp}")
    public List<LoaiSanPhamDTO> getAllLoaiSanPhamByMaLoaiSp(@PathVariable Integer maloaisp){
        return loaiSanPhamService.getAllLoaiSanPhamByMaLoaiSp(maloaisp);
    }

    @GetMapping(value = "/getloaisanpham")
    public List<LoaiSanPhamDTO> getAllLoaiSanPham(){
        return loaiSanPhamService.getAllLoaiSanPham();
    }

}
