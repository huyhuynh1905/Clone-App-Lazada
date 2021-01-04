package com.huyhuynh.lazadaserver.payload;

/**
 * @project: lazadaserver
 * @author: HuyHuynh on 29/12/2020
 */
public class ThuongHieuPayload {
    private int math;
    private String tenth;
    private int luotmua;
    private String hinhthuonghieu;

    public ThuongHieuPayload() {
    }

    public ThuongHieuPayload(int math, String tenth, int luotmua, String hinhthuonghieu) {
        this.math = math;
        this.tenth = tenth;
        this.luotmua = luotmua;
        this.hinhthuonghieu = hinhthuonghieu;
    }

    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        this.math = math;
    }

    public String getTenth() {
        return tenth;
    }

    public void setTenth(String tenth) {
        this.tenth = tenth;
    }

    public int getLuotmua() {
        return luotmua;
    }

    public void setLuotmua(int luotmua) {
        this.luotmua = luotmua;
    }

    public String getHinhthuonghieu() {
        return hinhthuonghieu;
    }

    public void setHinhthuonghieu(String hinhthuonghieu) {
        this.hinhthuonghieu = hinhthuonghieu;
    }
}
