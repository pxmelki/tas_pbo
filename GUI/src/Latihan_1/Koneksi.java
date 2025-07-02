/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Latihan_1;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author krisl
 */
public class Koneksi {
    private static Connection con;
    public static Connection getkoneksi() {
        try {
            if(con == null){ // kalo koneksi nya ga ada
                String db = "jdbc:mysql://localhost:3306/db_pbo_salon";
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
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        getkoneksi();
    }
    
}

