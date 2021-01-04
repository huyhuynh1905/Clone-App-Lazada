package com.huyhuynh.lazadaserver.api;

import com.huyhuynh.lazadaserver.dto.ChiTietSanPhamDTO;
import com.huyhuynh.lazadaserver.service.ChiTietSanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

/**
 * @project: lazadaserver
 * @author: HuyHuynh on 31/12/2020
 */

@RestController
@CrossOrigin
public class ChiTietSanPhamAPI {
    @Autowired
    ChiTietSanPhamService chiTietSanPhamService;

    @GetMapping(value = "/getchitietspbyid={masp}")
    public List<ChiTietSanPhamDTO> getAllChiTietByMasp(@PathVariable Integer masp){
        return chiTietSanPhamService.getAllChiTietSanPhamByMasp(masp);
    }
}
