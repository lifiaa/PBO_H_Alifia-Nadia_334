package com.praktikum.codelabM04.perpustakaan;
import java.util.*;

public class dbUser {
    public static Map<String, User> daftarUser = new HashMap<>();
    
    public static void addUser(User user){
        daftarUser.put(user.getNama()+ "-" + user.getIDUser().toLowerCase(), user);
    }

    public static User cariUser(String nama, String idUser){
        return daftarUser.get(nama + "-" + idUser);
    }
}

