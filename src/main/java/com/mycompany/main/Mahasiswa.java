package com.mycompany.main;

public class Mahasiswa extends User {
    private final String prodi = "Informatika";
    private final int usia = 19;
    private final String asal = "Kalimantan Tengah/Pangkalan Bun";
    
    @Override
    public boolean login(String inputNama, String inputNim) {
        return super.login(inputNama, inputNim);
    }

    public Mahasiswa(String nama, String nim) {
        super(nama, nim);
    }

    @Override
    public void displayInfo() {
        System.out.println("\n==== Informasi Mahasiswa ====");
        System.out.println("Nama: " + nama);
        System.out.println("NIM: " + nim);
        System.out.println("Prodi: " + prodi);
        System.out.println("Usia: " + usia);
        System.out.println("Asal: " + asal);
        System.out.println("=============================\n");
    }
}

