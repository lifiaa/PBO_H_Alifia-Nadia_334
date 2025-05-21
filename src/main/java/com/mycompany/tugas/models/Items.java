package com.praktikum.tugas.models;

public class Items {
    private String nama;
    private String deskripsi;
    private String lokasi;
    private String status;

    public Items(String nama, String deskripsi, String lokasi){
        this.nama = nama;
        this.deskripsi = deskripsi;
        this.lokasi = lokasi;
        this.status = "Reported";
    }

    public String getNama(){
        return nama;
    }

    public String getDeskripsi(){
        return deskripsi;
    }

    public String getLokasi(){
        return lokasi;
    }

    public String getStatus(){
        return status;
    }

    public void setStatus(String status){
        this.status = status;
    }
}
