package Salon;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class dl_data_stokbarang {
    // Variabel publik untuk membawa data dari/ke GUI
    public String Kode_barang;
    public String Nama_barang;
    public String Tanggal_masuk;
    public String Jumlah_stok;
    public String Harga_barang;

    // Method simpan yang sudah diperbaiki
    public void simpan() throws SQLException {
        String sql = "INSERT INTO stok_barang (Kode_barang, Nama_barang, Tanggal_masuk, Jumlah_stok, Harga_barang) VALUES (?, ?, ?, ?, ?)";
        // Gunakan try-with-resources untuk memastikan koneksi dan statement selalu tertutup
        try (Connection conn = koneksi.getkoneksi();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            
            pst.setString(1, Kode_barang);
            pst.setString(2, Nama_barang);
            pst.setString(3, Tanggal_masuk);
            pst.setString(4, Jumlah_stok);
            pst.setString(5, Harga_barang);
            
            pst.executeUpdate(); // Cukup panggil ini satu kali
            JOptionPane.showMessageDialog(null, "Data berhasil disimpan.");
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal menyimpan data: " + e.getMessage());
            // Lemparkan kembali exception agar pemanggil tahu ada error
            throw e;
        }
    }

    // Method rubah yang sudah diperbaiki
    public void rubah() throws SQLException {
        String sql = "UPDATE stok_barang SET Nama_barang=?, Tanggal_masuk=?, Jumlah_stok=?, Harga_barang=? WHERE Kode_barang=?";
        try (Connection conn = koneksi.getkoneksi();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            
            pst.setString(1, Nama_barang);
            pst.setString(2, Tanggal_masuk);
            pst.setString(3, Jumlah_stok);
            pst.setString(4, Harga_barang);
            pst.setString(5, Kode_barang);
            
            pst.executeUpdate();
             JOptionPane.showMessageDialog(null, "Data berhasil diubah.");
             
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal mengubah data: " + e.getMessage());
            throw e;
        }
    }

    // Method hapus yang sudah diperbaiki
    public void hapus() throws SQLException {
        String sql = "DELETE FROM stok_barang WHERE Kode_barang=?";
        try (Connection conn = koneksi.getkoneksi();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            
            pst.setString(1, Kode_barang);
            pst.executeUpdate(); // Gunakan executeUpdate untuk konsistensi
            JOptionPane.showMessageDialog(null, "Data berhasil dihapus.");
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal menghapus data: " + e.getMessage());
            throw e;
        }
    }
    

    public ResultSet getData() throws SQLException {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        
        try {
            conn = koneksi.getkoneksi();
            if (conn == null) {
                JOptionPane.showMessageDialog(null, "Koneksi ke database gagal.");
                return null;
            }
            String sql = "SELECT * FROM stok_barang";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            return rs;
        } catch (SQLException e) {
            // Jika ada error, tutup semua resource sebelum melempar exception
            if (rs != null) rs.close();
            if (pst != null) pst.close();
            if (conn != null) conn.close();
            JOptionPane.showMessageDialog(null, "Gagal mengambil data: " + e.getMessage());
            throw e;
        }
        // JANGAN TUTUP KONEKSI DI SINI, karena ResultSet yang dikembalikan masih membutuhkannya.
    }
}