package com.huyhuynh.lazadaserver.service.impl;

import java.util.*;

import com.huyhuynh.lazadaserver.dto.ChiTietHoaDonDTO;
import com.huyhuynh.lazadaserver.dto.HoaDonDTO;

/**
 * @project: lazadaserver
 * @author: HuyHuynh on 04/01/2021
 */
public interface HoaDonServiceImpl {
    boolean themVaoHoaDon(HoaDonDTO hoaDonDTO, List<ChiTietHoaDonDTO> chiTietHoaDonList);
}
