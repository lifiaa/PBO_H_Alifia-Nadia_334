package com.mycompany.codelabM4.perpustakaan;

public class Anggota implements Peminjaman {
    private String nama;
    private String idAnggota;

    public Anggota(String nama, String idAnggota){
        this.nama = nama;
        this.idAnggota = idAnggota;
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
        System.out.println("ID anggota: " + idAnggota);
        System.out.println("==========================");
    }
}
