package com.huyhuynh.lazadaserver.api;

import com.huyhuynh.lazadaserver.dto.GioHangDTO;
import com.huyhuynh.lazadaserver.service.GioHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @project: lazadaserver
 * @author: HuyHuynh on 02/01/2021
 */
@RestController
@CrossOrigin
public class GioHangAPI {

    @Autowired
    GioHangService gioHangService;

    @GetMapping(value = "/getgiohang")
    public List<GioHangDTO> getGioHang(@RequestParam("manv") int manv){
        return gioHangService.getAllGioHangByManv(manv);
    }

    @PostMapping(value = "/themgiohang")
    public Map<String,Boolean> themGioHang(@RequestBody GioHangDTO gioHangDTO){
        Map<String,Boolean> map = new HashMap<>();
        boolean kq = gioHangService.themGioHang(gioHangDTO);
        if (kq){
            map.put("message",true);
            return map;
        } else {
            map.put("message",false);
            return map;
        }
    }

    @PostMapping(value = "/giamsoluonggiohang")
    public Map<String,Boolean> giamSoLuongGioHang(@RequestBody GioHangDTO gioHangDTO){
        Map<String,Boolean> map = new HashMap<>();
        boolean kq = gioHangService.giamSoLuong(gioHangDTO);
        if (kq){
            map.put("message",true);
            return map;
        } else {
            map.put("message",false);
            return map;
        }
    }

    @DeleteMapping(value = "/xoagiohang")
    public Map<String,Boolean> xoaGioHang(@RequestBody GioHangDTO gioHangDTO){
        Map<String,Boolean> map = new HashMap<>();
        boolean kq = gioHangService.xoaGioHang(gioHangDTO);
        if (kq){
            map.put("message",true);
            return map;
        } else {
            map.put("message",false);
            return map;
        }
    }
}
