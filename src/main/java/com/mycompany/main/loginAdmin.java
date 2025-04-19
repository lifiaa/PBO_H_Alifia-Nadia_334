package com.mycompany.main;

public class loginAdmin {
    public loginAdmin(Admin admin){
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

    private static String generateTicketID() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'generateTicketID'");
    }
}
