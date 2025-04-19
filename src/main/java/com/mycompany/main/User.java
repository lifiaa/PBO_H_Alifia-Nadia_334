package com.mycompany.main;

public class User {
    protected String nama;
    protected String nim;

    // Constructor
    public User(String nama, String nim) {
        this.nama = nama;
        this.nim = nim;
    }

    // Getter dan Setter
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    // Method login (akan di-override)
    public boolean login(String inputNama, String inputNim) {
        return this.nama.equals(inputNama) && this.nim.equals(inputNim);
    }

    // Method displayInfo (akan di-override)
    public void displayInfo() {
        System.out.println("Nama: " + nama + ", NIM: " + nim);
    }
}

