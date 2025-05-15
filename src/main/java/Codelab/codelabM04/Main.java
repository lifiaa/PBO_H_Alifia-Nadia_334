package com.praktikum.codelabM04;

import java.util.Scanner;

import com.praktikum.codelabM04.perpustakaan.Buku;
import com.praktikum.codelabM04.perpustakaan.Fiksi;
import com.praktikum.codelabM04.perpustakaan.NonFiksi;
import com.praktikum.codelabM04.perpustakaan.User;
import com.praktikum.codelabM04.perpustakaan.dbBuku;
import com.praktikum.codelabM04.perpustakaan.dbUser;

public class Main {
    public static void main(String[] args) {
        //Start baru
        //insert(make)new book
        dbBuku.tambahBuku(new Fiksi("Hujan", "Tere Liye", "Drama"));
        dbBuku.tambahBuku(new NonFiksi("Laut Bercerita", "Leila Chudori", "Sejarah"));

        Scanner scanner = new Scanner(System.in);

        dbUser.addUser(new User("Alifia", "H334"));
        dbUser.addUser(new User("Marvella", "H79"));

        System.out.println("Masukkan nama: ");
        String nama = scanner.nextLine();
        System.out.println("Masukkan ID Anggota: ");
        String idUser = scanner.nextLine();

        User user = dbUser.cariUser(nama, idUser);

        if(user != null){
            System.out.println("Anda adalah anggota perpustakaan.\nIdentitas anda :");
            user.displayInfo();

            while (true) {
                System.out.println("\n1. Pinjam Buku\n2. Kembalikan Buku\n3. Lihat Daftar Buku\n4. Keluar");
                System.out.print("Pilih menu: ");
                int pilihan = scanner.nextInt();
                scanner.nextLine(); // biar input aman

                switch (pilihan) {
                    case 1 -> {
                        System.out.print("Judul buku yang ingin dipinjam: ");
                        String judul = scanner.nextLine();
                        Buku buku = dbBuku.cariBuku(judul);

                        if (buku != null && buku.isTersedia()) {
                            user.pinjamBuku(judul);
                            buku.setAvailable(false);
                        } else {
                            System.out.println("Buku tidak tersedia atau tidak ditemukan.");
                        }
                    }

                    case 2 -> {
                        System.out.print("Judul buku yang ingin dikembalikan: ");
                        String judul = scanner.nextLine();
                        Buku buku = dbBuku.cariBuku(judul);

                        if (buku != null && !buku.isTersedia()) {
                            user.kembalikanBuku(judul);
                            buku.setAvailable(true);
                        } else {
                            System.out.println("Buku tidak sedang dipinjam atau tidak ditemukan.");
                        }
                    }

                    case 3 -> dbBuku.tampilkanBuku();

                    case 4 -> {
                        System.out.println("Terima kasih telah menggunakan sistem perpustakaan.");
                        return; // keluar dari program
                    }

                    default -> System.out.println("Pilihan tidak valid.");
                }
            }
        }
        // end baru
        /*
        Buku buku1 = new NonFiksi("Madilog", "Tan Malaka", "Sejarah & Ilmu Pengetahuan");
        Buku buku2 = new Fiksi("Hujan", "Tere Liye", "Sains Fiksi");

        buku1.displayInfo();
        buku2.displayInfo();

        User anggota1 = new User("Alifia", "H334");
        User anggota2 = new User("Marvella", "H379");

        anggota1.displayInfo();
        anggota2.displayInfo();

        anggota1.pinjamBuku("Madilog");
        anggota2.pinjamBuku("Hujan", 7);

        anggota1.kembalikanBuku("Madilog");
        anggota2.kembalikanBuku("Hujan");*/
    }
}
