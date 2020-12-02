package com.example.sportwear.model;

public class Loaisanpham {
    public int Id;
    public String Tenloaisanpham;
    public String Hinhanhloaisanpham;

    public Loaisanpham(int id, String tenloaisanpham, String hinhanhloaisanpham) {
        Id = id;
        Tenloaisanpham = tenloaisanpham;
        Hinhanhloaisanpham = hinhanhloaisanpham;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getTenloaisanpham() {
        return Tenloaisanpham;
    }

    public void setTenloaisanpham(String tenloaisanpham) {
        Tenloaisanpham = tenloaisanpham;
    }

    public String getHinhanhloaisanpham() {
        return Hinhanhloaisanpham;
    }

    public void setHinhanhloaisanpham(String hinhanhloaisanpham) {
        Hinhanhloaisanpham = hinhanhloaisanpham;
    }
}
