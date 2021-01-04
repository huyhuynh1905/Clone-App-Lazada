package com.huyhuynh.lazadaserver.api;

import com.huyhuynh.lazadaserver.service.NhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @project: lazadaserver
 * @author: HuyHuynh on 21/12/2020
 */

@RestController
@CrossOrigin
public class NhanVienAPI {

    @Autowired
    NhanVienService nhanVienService;

    @PostMapping(value = "/dangki")
    public Map<String,String> themNhanVien(String tennv, String email, String matkhau, boolean nhanemail){
        Map<String,String> response = new HashMap<>();
        boolean ketqua = nhanVienService.themNhanVien(tennv,email,matkhau,nhanemail);
        if (ketqua){
            response.put("Message","Đăng kí thành công!");
            return response;
        } else {
            response.put("Message","Đăng kí thất bại, tài khoản có thể đã tồn tại!");
            return response;
        }
    }

    @GetMapping("/laytennhanvien")
    public Map<String,String> layTenNhanVien(@RequestParam("manv") int manv){
        Map<String,String> map = new HashMap<>();
        map.put("n",nhanVienService.layTenNhanVien(manv));
        return map;
    }

}
