package com.mycompany.codelabM4;

import com.mycompany.codelabM4.perpustakaan.*;

public class Main {
    public static void main(String[] args) {
        Buku buku1 = new NonFiksi("Madilog", "Tan Malaka", "Sejarah & Ilmu Pengetahuan");
        Buku buku2 = new Fiksi("Hujan", "Tere Liye", "Sains Fiksi");

        buku1.displayInfo();
        buku2.displayInfo();

        Anggota anggota1 = new Anggota("Alifia", "H334");
        Anggota anggota2 = new Anggota("Marvella", "H379");

        anggota1.displayInfo();
        anggota2.displayInfo();

        anggota1.pinjamBuku("Madilog");
        anggota2.pinjamBuku("Hujan", 7);

        anggota1.kembalikanBuku("Madilog");
        anggota2.kembalikanBuku("Hujan");
    }
}
