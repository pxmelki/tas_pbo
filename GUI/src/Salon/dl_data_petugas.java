
package Salon;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class dl_data_petugas {
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    
    private String sql;
    
    public String Id_petugas;
    public String nama;
    public String telephone;
    public String alamat;
    
    public void simpan()throws SQLException{
        conn = koneksi.getkoneksi();
        sql = "INSERT INTO `data_petugas`(`Id_Pelanggan`, `Nama`, `Telepon`, `Alamat`)VALUES(?,?,?,?)";
        try{
            pst = conn.prepareStatement(sql);
            pst.setString(1, Id_petugas);
            pst.setString(2, nama);
            pst.setString(3,telephone);
            pst.setString(4, alamat);
            pst.execute();
        }catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        } finally {
            closeResources();
        }
       
        
    }
    public void rubah()throws SQLException{
        conn = koneksi.getkoneksi();
        sql = "UPDATE data_petugas SET Nama=?,Telepon=?,Alamat=? WHERE Id_pelanggan=? ";
        try{
            pst = conn.prepareStatement(sql);
            pst.setString(1, nama);
            pst.setString(2, telephone);
            pst.setString(3,alamat);
            pst.setString(4, Id_petugas);
            pst.executeUpdate();    
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        } finally {
            closeResources();
        }
        
    }
    public void hapus()throws SQLException{
        conn = koneksi.getkoneksi();
        sql = "DELETE FROM `data_petugas` WHERE Id_pelanggan =?";
        try{
            pst = conn.prepareStatement(sql);
            pst.setString(1, Id_petugas);
            pst.execute();
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }finally{
            closeResources();
        }   
    }
    public ResultSet UpdateJTable()throws SQLException{
        conn = koneksi.getkoneksi();
        sql = "SELECT `Id_Pelanggan`, `Nama`,`Telepon`, `Alamat` FROM `data_petugas`";
        pst = conn.prepareStatement(sql);
        rs = pst.executeQuery();
        return rs;
    }
    public ResultSet getData() {
        conn = koneksi.getkoneksi();
        sql = "SELECT * FROM data_petugas";
        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        e.printStackTrace();
    }
    return rs;
}
private void closeResources() {
    try {
        if (rs != null) rs.close();
        if (pst != null) pst.close();
        if (conn != null) conn.close();
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error closing resources: " + e.getMessage());
    }
    try {
            if (pst != null) {
                pst.close();
                System.out.println("PreparedStatement closed");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error closing PreparedStatement: " + e.getMessage());
            e.printStackTrace();
        }

        try {
            if (conn != null) {
                conn.close();
                System.out.println("Connection closed");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error closing Connection: " + e.getMessage());
            e.printStackTrace();
        }
    }
}