package com.huyhuynh.lazadaserver.dto;

/**
 * @project: lazadaserver
 * @author: HuyHuynh on 04/01/2021
 */
public class HoaDonDTO {
    private int mahd;
    private String ngaymua;
    private String ngaygiao;
    private String trangthai;
    private String tennguoinhan;
    private String sodt;
    private String diachi;
    private int chuyenkhoan;
    private String machuyenkhoan;

    public HoaDonDTO() {
    }

    public HoaDonDTO(int mahd, String ngaymua, String ngaygiao, String trangthai, String tennguoinhan, String sodt,
                     String diachi, int chuyenkhoan, String machuyenkhoan) {
        this.mahd = mahd;
        this.ngaymua = ngaymua;
        this.ngaygiao = ngaygiao;
        this.trangthai = trangthai;
        this.tennguoinhan = tennguoinhan;
        this.sodt = sodt;
        this.diachi = diachi;
        this.chuyenkhoan = chuyenkhoan;
        this.machuyenkhoan = machuyenkhoan;
    }

    public String getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }

    public int getMahd() {
        return mahd;
    }

    public void setMahd(int mahd) {
        this.mahd = mahd;
    }

    public String getNgaymua() {
        return ngaymua;
    }

    public void setNgaymua(String ngaymua) {
        this.ngaymua = ngaymua;
    }

    public String getNgaygiao() {
        return ngaygiao;
    }

    public void setNgaygiao(String ngaygiao) {
        this.ngaygiao = ngaygiao;
    }

    public String getTennguoinhan() {
        return tennguoinhan;
    }

    public void setTennguoinhan(String tennguoinhan) {
        this.tennguoinhan = tennguoinhan;
    }

    public String getSodt() {
        return sodt;
    }

    public void setSodt(String sodt) {
        this.sodt = sodt;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public int getChuyenkhoan() {
        return chuyenkhoan;
    }

    public void setChuyenkhoan(int chuyenkhoan) {
        this.chuyenkhoan = chuyenkhoan;
    }

    public String getMachuyenkhoan() {
        return machuyenkhoan;
    }

    public void setMachuyenkhoan(String machuyenkhoan) {
        this.machuyenkhoan = machuyenkhoan;
    }
}
