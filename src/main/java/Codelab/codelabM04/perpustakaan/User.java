package com.praktikum.codelabM04.perpustakaan;

public class User implements Peminjaman {
    private String nama;
    private String idUser;

    public User(String nama, String idUser){
        this.nama = nama;
        this.idUser = idUser;
    }

    public String getNama(){
        return nama;
    }
    public void setNama(String nama){
        this.nama = nama;
    }
    public String getIDUser(){
        return idUser;
    }
    public void setIdUser(String idUser){
        this.idUser = idUser;
    }

    @Override
    public void pinjamBuku(String judul){
        System.out.println(nama + " meminjam buku berjudul " + judul);
    }

    public void pinjamBuku(String judul, int waktuPinjam){
        System.out.println(nama + " meminjam buku berjudul " + judul + " selama " + waktuPinjam + " hari.");
    }

    @Override
    public void kembalikanBuku(String judul){
        System.out.println(nama + " mengembalikan buku berjudul " + judul);
    }

    public void displayInfo(){
        System.out.println("==========================");
        System.out.println("Nama anggota: " + nama);
        System.out.println("ID anggota: " + idUser);
        System.out.println("==========================");
    }
}