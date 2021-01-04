package com.huyhuynh.lazadaserver.api;
import com.huyhuynh.lazadaserver.payload.HoaDonPayload;
import com.huyhuynh.lazadaserver.service.HoaDonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @project: lazadaserver
 * @author: HuyHuynh on 04/01/2021
 */
@RestController
@CrossOrigin
public class HoaDonAPI {
    @Autowired
    HoaDonService hoaDonService;

    @PostMapping(value = "/themhoadon")
    public Map<String,Boolean> themHoaDon(@RequestBody HoaDonPayload hoaDonPayload){
        Map<String,Boolean> map=new HashMap<>();
        boolean kq = hoaDonService.themVaoHoaDon(hoaDonPayload.getHoaDon(),hoaDonPayload.getChiTietHoaDonList());
        map.put("message",kq);
        return map;
    }
}
