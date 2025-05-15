package com.praktikum.codelabM04.perpustakaan;

public abstract class Buku {
    protected String judul;
    protected String penulis;
    protected boolean tersedia = true;

    public Buku(String judul, String penulis){
        this.judul = judul;
        this.penulis = penulis;
    }
    
    public boolean isTersedia(){
        return tersedia;
    }
    
    public void setAvailable(boolean status){
        this.tersedia = status;
    }
    
    public String getJudul(){
        return judul;
    }
    
    public String getPenulis(){
        return penulis;
    } 
    
    public abstract void displayInfo();
}
