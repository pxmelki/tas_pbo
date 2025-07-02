package Salon;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class dl_data_pembookingan {
    // Variabel publik untuk membawa data dari/ke GUI
    public String No_Antrian;
    public String Nama;
    public String Tanggal_Booking;
    public String Telephone;
    public String Alamat;
    public String Jenis_layanan;

    // Method simpan yang lebih aman dengan try-with-resources
    public void simpan() throws SQLException {
        String sql = "INSERT INTO pembookingan(No_Antrian, Nama, Tanggal_Booking, Telephone, Alamat, Jenis_Layanan) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = koneksi.getkoneksi();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            
            pst.setString(1, No_Antrian);
            pst.setString(2, Nama);
            pst.setString(3, Tanggal_Booking);
            pst.setString(4, Telephone);
            pst.setString(5, Alamat);
            pst.setString(6, Jenis_layanan);
            
            pst.executeUpdate();
            // Pindahkan pesan sukses ke kelas GUI agar kelas ini fokus pada data saja
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal menyimpan data: " + e.getMessage());
            throw e; // Lemparkan exception agar kelas pemanggil tahu ada masalah
        }
    }

    // Method rubah yang sudah diperbaiki logika SQL dan parameternya
    public void rubah() throws SQLException {
        // SQL diperbaiki: No_Antrian hanya ada di WHERE, tidak di SET
        String sql = "UPDATE pembookingan SET Nama=?, Tanggal_Booking=?, Telephone=?, Alamat=?, Jenis_Layanan=? WHERE No_Antrian=?";
        try (Connection conn = koneksi.getkoneksi();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            
            // Urutan parameter disesuaikan dengan SQL yang benar
            pst.setString(1, Nama);
            pst.setString(2, Tanggal_Booking);
            pst.setString(3, Telephone);
            pst.setString(4, Alamat);
            pst.setString(5, Jenis_layanan);
            pst.setString(6, No_Antrian); // No_Antrian sebagai parameter terakhir untuk WHERE
            
            pst.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal mengubah data: " + e.getMessage());
            throw e;
        }
    }

    // Method hapus yang lebih aman dengan try-with-resources
    public void hapus() throws SQLException {
        String sql = "DELETE FROM pembookingan WHERE No_Antrian=?";
        try (Connection conn = koneksi.getkoneksi();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            
            pst.setString(1, No_Antrian);
            pst.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal menghapus data: " + e.getMessage());
            throw e;
        }
    }
    
    /**
     * Mengambil semua data dari pembookingan. Ini adalah satu-satunya method yang diperlukan
     * untuk membaca data tabel. Method UpdateJTable() dihapus karena redundan.
     * * PENTING: Kelas yang memanggil method ini BERTANGGUNG JAWAB untuk menutup
     * semua sumber daya (ResultSet, Statement, Connection) setelah selesai digunakan.
     */
    public ResultSet getData() throws SQLException {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        
        try {
            conn = koneksi.getkoneksi();
            if (conn == null) {
                // Sebaiknya tidak menggunakan JOptionPane di kelas data logic
                // Cukup lemparkan exception agar ditangani oleh GUI
                throw new SQLException("Koneksi ke database gagal.");
            }
            String sql = "SELECT * FROM pembookingan";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            return rs;
        } catch (SQLException e) {
            // Jika terjadi error, pastikan semua resource yang sempat terbuka ditutup
            if (rs != null) rs.close();
            if (pst != null) pst.close();
            if (conn != null) conn.close();
            // Lemparkan lagi errornya agar GUI tahu ada masalah
            throw e; 
        }
        // Koneksi sengaja tidak ditutup di sini agar ResultSet bisa dibaca oleh GUI
    }
}