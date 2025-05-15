package com.praktikum.codelabM04.perpustakaan;
import java.util.*;

public class dbBuku {
    public static Map<String, Buku> daftarBuku = new HashMap<>();

    public static void tambahBuku(Buku buku) {
        daftarBuku.put(buku.getJudul().toLowerCase(), buku);
    }

    public static Buku cariBuku(String judul) {
        return daftarBuku.get(judul.toLowerCase());
    }

    public static void tampilkanBuku() {
        System.out.println("\n=== Daftar Buku di Perpustakaan ===");
        for (Buku buku : daftarBuku.values()) {
            buku.displayInfo();
        }
    }
}
