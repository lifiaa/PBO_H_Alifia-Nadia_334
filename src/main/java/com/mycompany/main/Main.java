package com.mycompany.main;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

//main class
public class Main {
    private static final Map<String, Mahasiswa> mahasiswaDB = new HashMap<>();
    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();
    
    public static void main(String[] args) {
        //database simulasi
        mahasiswaDB.put("202410370110334", new Mahasiswa("Alifia Nadia Ruksana", "202410370110334"));
        // mahasiswaDB.put("202410370110379", new Mahasiswa("Ayshea Marvella Pasha", "202410370110379"));

        Admin admin = new Admin("Admin Satu", "0001", "admin", "1234");

        //login system
        while (true) { 
            System.out.println("\n\n=== Selamat datang di Sistem Login! ===");
            System.out.println("Pilih login: \n1. Admin  \n2. Mahasiswa");
            int pilihan = scanner.nextInt();
            scanner.nextLine(); // Membersihkan newline
                        
            switch (pilihan) {
                case 1 -> loginAdmin(admin);
                case 2 -> loginMahasiswa();
                default -> System.out.println("Jenis login tidak valid!");
            }   
            
            System.out.println("Apakah Anda ingin login ulang? (ya/tidak): ");
            String text = scanner.nextLine().trim().toLowerCase();
            if (!text.equals("ya")) {
                break;
            }
        }
    }

    private static void loginAdmin(Admin admin){
        while (true) { 
            System.out.println("\n==== Login Admin ====");
            System.out.print("Username: ");
            String username = scanner.nextLine();
            System.out.print("Password: ");
            String password = scanner.nextLine();
    
            if(admin.login(username, password)){
                System.err.println("\n=================================================");
                System.out.println("Login admin berhasil! ID Tiket: " + generateTicketID());
                System.err.println("=================================================");
            } else{
                System.err.println("\n=================================================");
                System.out.println("Login admin gagal! Username atau password salah.");
                System.err.println("=================================================");
            }

            break;
        }
    }


    private static void loginMahasiswa(){
        while (true) { 
            System.out.println("\n==== Login Mahasiswa ====");
            System.out.print("username: ");
            String inputNama = scanner.nextLine();
            System.out.print("password: ");
            String inputNim = scanner.nextLine();
            
            Mahasiswa mahasiswa = mahasiswaDB.get(inputNim);
            
            if(mahasiswa != null && mahasiswa.login(inputNama, inputNim)){
                mahasiswa.displayInfo();
            } else{
                System.err.println("\n============================================");
                System.out.println("Login mahasiswa gagal! Nama atau NIM salah.");
                System.err.println("============================================\n");
            }

            break;
        }   
    }
    
    private static String generateTicketID(){
        return "Tiket-" + (1000 + random.nextInt(9000));
    }

    
}
