package com.huyhuynh.lazadaserver.model;

import javax.persistence.*;

/**
 * @project: lazadaserver
 * @author: HuyHuynh on 28/12/2020
 */

@Entity
@Table(name = "thuonghieu")
public class ThuongHieuEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int math;

    @Column(name = "tenth")
    private String tenth;

    @Column(name = "luotmua")
    private int luotmua;

    /*
    @OneToOne
    @JoinTable(name = "chitietthuonghieu",
            joinColumns =
                    { @JoinColumn(name = "math", referencedColumnName = "math") },
            inverseJoinColumns =
                    { @JoinColumn(name = "maloaisp", referencedColumnName = "maloaisp") })
    private LoaiSanPhamEntity loaiSanPham;

     */

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
