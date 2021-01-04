package com.huyhuynh.applazada.retrofit;


import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface HoaDonAPI {

    @POST(value = "themhoadon")
    Call<Map<String,Boolean>> themHoaDon(@Body HoaDonPayload hoaDonPayload);

}
