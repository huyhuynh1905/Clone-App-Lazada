package com.huyhuynh.lazadaserver.service.impl;

import com.huyhuynh.lazadaserver.dto.DanhGiaDTO;
import java.util.List;
/**
 * @project: lazadaserver
 * @author: HuyHuynh on 01/01/2021
 */
public interface DanhGiaServiceImpl {
    boolean themDanhGia(DanhGiaDTO danhGiaDTO);
    List<DanhGiaDTO> gettAllDanhGiaByMasp(int masp);
}
