package com.praktikum.tugas.main;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import com.praktikum.tugas.models.Items;
import com.praktikum.tugas.users.Admin;
import com.praktikum.tugas.users.Mahasiswa;
import com.praktikum.tugas.users.User;

public class LoginSystem {
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    //static arrayList
    public static ArrayList<User> userList = new ArrayList<>();
    public static ArrayList<Items> reportedItems = new ArrayList<>();


    public static void main(String[] args) {
        // database simulasi
        Admin admin = new Admin("Admin Satu", "0001", "admin", "Admin123");
        Mahasiswa mahasiswa = new Mahasiswa("Mahasiswa 1", "202410370110334", "alifia", "mahasiswa123");

        userList.add(new Admin("Admin", "0001", "admin", "admin123"));
        userList.add(new Mahasiswa("Alifia", "0334", "mahasiswa01", "alifia123" ));
        userList.add(new Mahasiswa("Ardian", "0342", "mahasiswa02", "ardian123"));

        while (true) {
            System.out.println("\n=== Selamat datang di Sistem Login ===");
            System.out.println("1. Login sebagai Admin");
            System.out.println("2. Login sebagai Mahasiswa");
            System.out.println("3. Keluar");
            System.out.print("Pilihan: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1 -> login(admin);
                case 2 -> login(mahasiswa);
                case 3 -> {
                    System.out.println("Terima kasih telah menggunakan program ini. Sampai jumpa!");
                    return;
                }
                default -> System.out.println("Pilihan tidak valid.");
            }
        }
    }

    private static void login(User dumUser) {
    System.out.print("Username: ");
    String username = scanner.nextLine();
    System.out.print("Password: ");
    String password = scanner.nextLine();

    User loginUser = null;

    for (User user : userList) {
        if (user instanceof Admin admin) {
            if (admin.login(username, password)) {
                loginUser = admin;
                break;
            }
        } else if (user instanceof Mahasiswa mhs) {
            if (mhs.getNama().equals(username) && mhs.getNim().equals(password)) {
                loginUser = mhs;
                break;
            }
        }
    }

    if (loginUser != null) {
        System.out.println("\nLogin berhasil! ID Tiket: " + generateTicketID());
        System.out.println();
        loginUser.displayInfo();
        System.out.println();
        loginUser.displayAppMenu(); // polymorphism action
    } else {
        System.out.println("Login gagal! Username atau password salah.");
    }
}


    private static String generateTicketID() {
        return "TIKET-" + (1000 + random.nextInt(9000));
    }
}
