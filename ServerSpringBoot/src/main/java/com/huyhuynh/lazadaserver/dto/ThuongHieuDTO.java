package com.huyhuynh.lazadaserver.dto;


/**
 * @project: lazadaserver
 * @author: HuyHuynh on 28/12/2020
 */
public class ThuongHieuDTO {

    private int math;
    private String tenth;
    private int luotmua;


    public ThuongHieuDTO() {
    }

    public ThuongHieuDTO(int math, String tenth, int luotmua) {
        this.math = math;
        this.tenth = tenth;
        this.luotmua = luotmua;
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
}
