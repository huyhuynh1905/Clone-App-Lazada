package com.huyhuynh.lazadaserver.api;

import com.huyhuynh.lazadaserver.dto.DanhGiaDTO;
import com.huyhuynh.lazadaserver.service.DanhGiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

/**
 * @project: lazadaserver
 * @author: HuyHuynh on 01/01/2021
 */
@RestController
@CrossOrigin
public class DanhhGiaAPI {
    @Autowired
    DanhGiaService danhGiaService;

    @PostMapping(value = "/themdanhgia")
    public Map<String,String> themDanhGia(@RequestBody DanhGiaDTO danhGiaDTO) {
        boolean ketqua = danhGiaService.themDanhGia(danhGiaDTO);
        Map<String, String> message = new HashMap<>();
        if (ketqua){
            message.put("message","true");
        } else {
            message.put("message","false");
        }
        return message;
    }

    @GetMapping(value = "/laydanhgia")
    public List<DanhGiaDTO> layDanhSachDanhGia(@RequestParam("masp") int masp){
        List<DanhGiaDTO> danhGiaDTOList = new ArrayList<>();
        danhGiaDTOList = danhGiaService.gettAllDanhGiaByMasp(masp);
        return danhGiaDTOList;
    }
}
