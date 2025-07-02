
package Salon;

import java.sql.Connection;
import java.sql.DriverManager;

public class koneksi {
    private static Connection con;
    public static Connection getkoneksi() {
        try {
            if(con == null || con.isClosed()){ 
                String db = "jdbc:mysql://localhost:3306/salon";
                String user = "root";
                String pass = "";
                con = DriverManager.getConnection(db, user, pass);
                System.out.println("Koneksi berhasil");
            }
            }catch (Exception e) {
            System.out.println("Koneksi gagal" + e.getMessage());
        }
        return con;
    }
    public static void main(String[] args) {
        getkoneksi();
    }
}