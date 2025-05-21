package com.praktikum.codelab5;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import com.praktikum.codelab05.StokKurangException;

public class ManageStok {
    public static void main(String[] args) {
        ArrayList<Barang> daftarBarang = new ArrayList<>();

        daftarBarang.add(new Barang("Margarin", 50));
        daftarBarang.add(new Barang("Minyak", 70));
        daftarBarang.add(new Barang("Tepung", 30));
        daftarBarang.add(new Barang("Telur", 40));

        Scanner scanner = new Scanner(System.in);
        boolean benar= true;

        System.out.println("\n===== Sistem Manajemen Stok =====\n");

        while (benar) {
            System.out.println("===== Menu Manajemen Stok =====");
            System.out.println("1. Tambah Barang Baru");
            System.out.println("2. Tampilkan Semua Barang");
            System.out.println("3. Kurangi Stok Barang");
            System.out.println("0. Keluar");
            System.out.print("Pilih opsi: ");

            int pilihan;
            try {
                pilihan = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Input harus berupa angka!");
                scanner.nextLine();
                continue;
            }

            switch(pilihan){
                case 1 -> {
                    System.out.println("Masukkan nama barang: ");
                    String namaBarang = scanner.nextLine();
                    System.out.println("Masukkan stok awal barang: ");
                    try{
                        int stokAwal = scanner.nextInt();
                        scanner.nextLine();
                        daftarBarang.add(new Barang(namaBarang, stokAwal));
                        System.out.println("Barang " + namaBarang + " berhasil ditambahkan.\n");
                    } catch (InputMismatchException e) {
                        System.out.println("Input harus berupa angka!");
                        scanner.nextLine();
                    }
                }

                case 2 -> {
                    System.out.println("\n--- Daftar Barang ---");
                    if (daftarBarang.isEmpty()) {
                        System.out.println("Stok barang kosong.");
                    } else {
                        int index = 0;
                        for (Barang cariBarang : daftarBarang) {
                            System.out.println("+----------------+--------+");
                            System.out.printf("| %-14s | %-6s |\n", "Nama Barang", "Stok");
                            System.out.println("+----------------+--------+");
                            System.out.printf("| %-14s | %-6d |\n", "tas", 60);
                            System.out.println("+----------------+--------+");

                        }
                    }
                    System.out.println("----------------------\n");
                }

                case 3 -> {
                    System.out.println("\n--- Daftar Barang (Pilih untuk Kurangi Stok) ---");
                    if (daftarBarang.isEmpty()) {
                        System.out.println("Stok barang kosong.\n");
                        break;
                    }
                    for (int i = 0; i < daftarBarang.size(); i++) {
                        Barang cariBarang = daftarBarang.get(i);
                        System.out.println(i + ". " + cariBarang.getNama() + " (Stok: " + cariBarang.getStok() + ")");
                    }
                    try {
                        System.out.print("Masukkan nomor indeks barang: ");
                        int idx = scanner.nextInt();
                        Barang barangDipilih = daftarBarang.get(idx);

                        System.out.print("Masukkan jumlah stok yang akan diambil: ");
                        int jumlahDiambil = scanner.nextInt();
                        scanner.nextLine();

                        if (jumlahDiambil > barangDipilih.getStok()) {
                            throw new StokKurangException("Stok untuk " + barangDipilih.getNama() +" hanya tersisa " + barangDipilih.getStok());
                        }

                        barangDipilih.setStok(barangDipilih.getStok() - jumlahDiambil);
                        System.out.println("Stok barang " + barangDipilih.getNama() +" berhasil dikurangi. Sisa stok: " + barangDipilih.getStok() + "\n");
                    } catch (InputMismatchException e) {
                        System.out.println("Input harus berupa angka!\n");
                        scanner.nextLine();
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Indeks tidak valid!\n");
                    } catch (StokKurangException e) {
                        System.out.println("Error: " + e.getMessage() + "\n");
                    }
                }

                case 0 -> {
                    System.out.println("Terima kasih! Program selesai.");
                    benar = false;
                }

                default -> System.out.println("Opsi tidak dikenal. Silakan pilih ulang.\n");
            }
        }
        scanner.close();
    }
}
