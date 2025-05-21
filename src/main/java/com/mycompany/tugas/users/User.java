package com.praktikum.tugas.users;

public abstract class User {
    protected String nama;
    protected String nim;
    protected String username;
    protected String password;

    public User(String nama, String nim, String username, String password) {
        this.nama = nama;
        this.nim = nim;
        this.username = username;
        this.password = password;
    }

    public abstract boolean login(String inputUsername, String inputPassword);


    public String getNama() { return nama; }
    public String getNim() { return nim; }

    public abstract void displayAppMenu();
    public abstract void displayInfo();
}

