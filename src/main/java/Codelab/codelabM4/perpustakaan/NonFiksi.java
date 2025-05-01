package com.mycompany.codelabM4.perpustakaan;

public class NonFiksi extends Buku {
    private String genre;

    public NonFiksi(String judul, String penulis, String genre){
        super(judul, penulis);
        this.genre = genre;
    }

    @Override
    public void displayInfo(){
        System.out.println("Buku non-fiksi: " + judul + ", oleh: " + penulis + " (genre: " + genre + ")");
    }
}
