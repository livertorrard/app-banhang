package com.example.sportwear.model;

import java.io.Serializable;

public class SanPhamAdias implements Serializable {
    private int idSpadias;
    private String Hinhanh;
    private String ten;
    private Integer gia;
    private String mota;

    public SanPhamAdias(int idSpadias, String hinhanh, String ten, Integer gia, String mota) {
        this.idSpadias = idSpadias;
        Hinhanh = hinhanh;
        this.ten = ten;
        this.gia = gia;
        this.mota = mota;
    }

    public int getIdSpadias() {
        return idSpadias;
    }

    public void setIdSpadias(int idSpadias) {
        this.idSpadias = idSpadias;
    }

    public String getHinhanh() {
        return Hinhanh;
    }

    public void setHinhanh(String hinhanh) {
        Hinhanh = hinhanh;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public Integer getGia() {
        return gia;
    }

    public void setGia(Integer gia) {
        this.gia = gia;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }
}
