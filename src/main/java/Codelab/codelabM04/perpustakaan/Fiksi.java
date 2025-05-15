package com.praktikum.codelabM04.perpustakaan;

public class Fiksi extends Buku {
    private String genre;

    public Fiksi(String judul, String penulis, String genre) {
        super(judul, penulis);
        this.genre = genre;
    }

    @Override
    public void displayInfo(){
        System.out.println("Buku fiksi: " + judul 
                + ", oleh: " + penulis 
                + " (genre: " + genre + ")" 
                + "Status: " + (tersedia ? "Tersedia" : "Dipinjam"));
    }
}
