package com.huyhuynh.applazada.model;

public class ThuongHieu {
    private int math;
    private String tenth;
    private int luotmua;
    private String hinhthuonghieu;


    public ThuongHieu() {
    }

    public ThuongHieu(int math, String tenth, int luotmua, String hinhthuonghieu) {
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
