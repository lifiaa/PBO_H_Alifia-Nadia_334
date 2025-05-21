package com.praktikum.tugas.users;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Iterator;

import com.praktikum.tugas.actions.adminActions;
import com.praktikum.tugas.main.LoginSystem;
import com.praktikum.tugas.models.Items;

public class Admin extends User implements adminActions {
    public Admin(String nama, String nim, String username, String password) {
        super(nama, nim, username, password);
    }
    
    @Override
    public boolean login(String inputUsername, String inputPassword) {
        return this.username.equals(inputUsername) && this.password.equals(inputPassword);
    }
    @Override
    public void displayInfo() {
        System.out.println("\n=== Login Admin berhasil! Selamat datang, " + getNama() + " ===");
    }

    @Override
    public void manageItems() {
        Scanner scanner = new Scanner(System.in);
        int pilihan = -1;

        System.out.println("\n=== MENU KELOLA LAPORAN BARANG ===");
        System.out.println("1. Lihat semua laporan");
        System.out.println("2. Tandai barang telah diambil");
        System.out.println("3. Keluar");
        System.out.print("Pilihan: ");

        try {
            pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1 -> {
                    if (LoginSystem.reportedItems.isEmpty()) {
                        System.out.println(">> Tidak ada laporan barang.");
                    } else {
                        System.out.println(">> Daftar Semua Laporan:");
                        int i = 0;
                        for (Items item : LoginSystem.reportedItems) {
                            System.out.println("[" + i + "] " + item.getNama());
                            System.out.println("    Deskripsi: " + item.getDeskripsi());
                            System.out.println("    Lokasi   : " + item.getLokasi());
                            System.out.println("    Status   : " + item.getStatus());
                            i++;
                        }
                    }
                }

                case 2 ->{
                    ArrayList<Integer> reportedIndexes = new ArrayList<>();
                    for (int i = 0; i < LoginSystem.reportedItems.size(); i++) {
                        if (LoginSystem.reportedItems.get(i).getStatus().equalsIgnoreCase("Reported")) {
                            System.out.println("[" + i + "] " + LoginSystem.reportedItems.get(i).getNama());
                            reportedIndexes.add(i);
                        }
                    }

                    if (reportedIndexes.isEmpty()) {
                        System.out.println(">> Tidak ada barang yang dilaporkan.");
                        break;
                    }

                    System.out.print("Masukkan indeks barang yang ingin ditandai sebagai 'Claimed': ");
                    try {
                        int index = scanner.nextInt();
                        if (index < 0 || index >= LoginSystem.reportedItems.size()) {
                            System.out.println(">> Indeks tidak valid.");
                        } else {
                            LoginSystem.reportedItems.get(index).setStatus("Claimed");
                            System.out.println(">> Barang berhasil ditandai sebagai 'Claimed'.");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println(">> Input harus berupa angka.");
                        scanner.nextLine(); // Bersihkan buffer
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println(">> Indeks di luar jangkauan.");
                    }
                }

                case 0 -> System.out.println("Kembali ke menu admin.");
                default -> System.out.println(">> Pilihan tidak valid.");
            }
        } catch (InputMismatchException e) {
            System.out.println(">> Input harus berupa angka!");
            scanner.nextLine(); // Clear input buffer
        }
    }

    @Override
    public void manageUsers() {
        Scanner scanner = new Scanner(System.in);
        int pilihan = -1;

        while (pilihan != 0) {
            System.out.println("\n==== MENU KELOLA MAHASISWA ====");
            System.out.println("1. Tambah Mahasiswa");
            System.out.println("2. Hapus Mahasiswa");
            System.out.println("0. Kembali");
            System.out.print("Pilih: ");

            try {
                pilihan = scanner.nextInt();
                scanner.nextLine(); // Clear newline

                switch (pilihan) {
                    case 1 -> {
                        System.out.print("Nama Mahasiswa: ");
                        String nama = scanner.nextLine();
                        System.out.print("NIM: ");
                        String nim = scanner.nextLine();
                        System.out.print("Username: ");
                        String username = scanner.nextLine();
                        System.out.print("Password: ");
                        String password = scanner.nextLine();

                        Mahasiswa mhs = new Mahasiswa(nama, nim, username, password);
                        LoginSystem.userList.add(mhs);
                        System.out.println(">> Mahasiswa berhasil ditambahkan.");
                    }

                    case 2 -> {
                        System.out.print("Masukkan NIM Mahasiswa yang ingin dihapus: ");
                        String nimHapus = scanner.nextLine();

                        boolean found = false;
                        Iterator<User> iterator = LoginSystem.userList.iterator();
                        while (iterator.hasNext()) {
                            User u = iterator.next();
                            if (u instanceof Mahasiswa && u.getNim().equals(nimHapus)) {
                                iterator.remove();
                                found = true;
                                System.out.println(">> Mahasiswa berhasil dihapus.");
                                break;
                            }
                        }

                        if (!found) {
                            System.out.println(">> Mahasiswa dengan NIM tersebut tidak ditemukan.");
                        }
                    }

                    case 0 -> System.out.println("Kembali ke menu admin.");
                    default -> System.out.println(">> Pilihan tidak valid.");
                }

            } catch (InputMismatchException e) {
                System.out.println(">> Input harus berupa angka!");
                scanner.nextLine();
            }
        }
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
                case 1 -> manageItems();
                case 2 -> manageUsers();
            }
        } while (pilihan != 0);
    }
}
