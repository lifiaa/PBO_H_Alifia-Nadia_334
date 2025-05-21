package com.praktikum.tugas.users;
import java.util.Scanner;

import com.praktikum.tugas.actions.mahasiswaActions;
import com.praktikum.tugas.main.LoginSystem;
import com.praktikum.tugas.models.Items;

public class Mahasiswa extends User implements mahasiswaActions {
    private final String prodi = "Informatika";
    private final int usia = 19;
    private final String asal = "Kalimantan Tengah/Pangkalan Bun";

    public Mahasiswa(String nama, String nim, String username, String password) {
        super(nama, nim, username, password);
    }
    
    @Override
    public boolean login(String inputUsername, String inputPassword) {
        return this.username.equals(inputUsername) && this.password.equals(inputPassword);
    }

    @Override
    public void reportItems(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nama barang: ");
        String nama = scanner.nextLine();
        System.out.println("Deskripsi: ");
        String deskripsi = scanner.nextLine();
        System.out.println("Lokasi terakhir terlihat: ");
        String lokasi = scanner.nextLine();

        Items item = new Items(nama, deskripsi, lokasi);
        LoginSystem.reportedItems.add(item);
    
        System.out.println("\n>> LAPORAN BARANG HILANG BERHASIL DIKIRIM!");

        System.out.println("Detail Laporan:");
        System.out.println("-> Nama Barang: " + nama);
        System.out.println("-> Deskripsi: " + deskripsi);
        System.out.println("-> Lokasi Terakhir: " + lokasi);
        System.out.println("============================================\n\n");
    }

    @Override
    public void viewReportedItems(){
        System.out.println(">> Fitur Lihat Laporan Belum Tersedia <<\n\n");
    }

    @Override
    public void displayInfo() {
        System.out.println("\n==== Informasi Mahasiswa ====");
        System.out.println("Nama: " + getNama());
        System.out.println("NIM: " + getNim());
        System.out.println("Prodi: " + prodi);
        System.out.println("Usia: " + usia);
        System.out.println("Asal: " + asal);
        System.out.println("=============================\n");
    }

    @Override
    public void displayAppMenu() {
        Scanner scanner = new Scanner(System.in);
        int pilihan;
        do {
            System.out.println("1. Laporkan Barang Temuan/Hilang");
            System.out.println("2. Lihat Daftar Laporan");
            System.out.println("0. Logout");
            System.out.print("Pilih: ");
            pilihan = scanner.nextInt();
            scanner.nextLine(); // clear buffer
            switch (pilihan) {
                case 1 -> reportItems();
                case 2 -> viewReportedItems();
            }
        } while (pilihan != 0);
    }
}

