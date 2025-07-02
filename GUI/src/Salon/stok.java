
package Salon;

import java.sql.ResultSetMetaData; 
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.sql.Statement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.table.DefaultTableModel;

public class stok extends javax.swing.JFrame {


    private void ViewData() {
        
        dl_data_stokbarang ck = new dl_data_stokbarang();
        try {
            ResultSet rs = ck.getData();
            if (rs != null) {
                // 3. Menghapus cast yang tidak perlu
                ResultSetMetaData metaData = rs.getMetaData();
                int columnCount = metaData.getColumnCount();

                DefaultTableModel model = new DefaultTableModel();
                for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                    model.addColumn(metaData.getColumnLabel(columnIndex));
                }

                while (rs.next()) {
                    Object[] rowData = new Object[columnCount];
                    for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                        rowData[columnIndex - 1] = rs.getObject(columnIndex);
                    }
                    model.addRow(rowData);
                }
                jTable1.setModel(model);
            } else {
                JOptionPane.showMessageDialog(null, "No data found");
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e);
        }
    }
    private void autoNumber() {
        String Kd = "KD000";
        int i = 1;
        try {
            Connection con = koneksi.getkoneksi();
            Statement st = con.createStatement();
            String sql = "SELECT Kode_barang FROM stok_barang ORDER BY Kode_barang DESC LIMIT 1";
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                Kd = rs.getString("Kode_barang");
                String numericPart = Kd.substring(2);
                try {
                    i = Integer.parseInt(numericPart) + 1;
                } catch (NumberFormatException ex) {
                    i = 1; // Jika format tidak valid, mulai dari 1
                }
            }
            Kd = "KD" + String.format("%03d", i);
            txkodebarang.setText(Kd);
            rs.close();
            st.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private Connection conn;

    public stok() {
        initComponents();
        ViewData();
        autoNumber();
        conn = koneksi.getkoneksi();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txkodebarang = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txnamabarang = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txjumlah = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txharga = new javax.swing.JTextField();
        cbsimpan = new javax.swing.JButton();
        cbedit = new javax.swing.JButton();
        cbhapus = new javax.swing.JButton();
        cbtambah = new javax.swing.JButton();
        cbkembali = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        jLabel4.setText("jLabel4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 204, 255));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 30)); // NOI18N
        jLabel1.setText("SALON FTI");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/salon (2).png"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel3.setText("DATA STOK BARANG");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(285, 285, 285))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(0, 153, 204));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Kode Barang");

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Nama Barang");

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Tanggal Masuk Barang");

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Jumlah Stok");

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Harga Barang");

        cbsimpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/diskette.png"))); // NOI18N
        cbsimpan.setText("SIMPAN");
        cbsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbsimpanActionPerformed(evt);
            }
        });

        cbedit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/edit (1).png"))); // NOI18N
        cbedit.setText("EDIT");
        cbedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbeditActionPerformed(evt);
            }
        });

        cbhapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/delete.png"))); // NOI18N
        cbhapus.setText("HAPUS");
        cbhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbhapusActionPerformed(evt);
            }
        });

        cbtambah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/plus (1).png"))); // NOI18N
        cbtambah.setText("TAMBAH");
        cbtambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbtambahActionPerformed(evt);
            }
        });

        cbkembali.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/undo.png"))); // NOI18N
        cbkembali.setText("KEMBALI");
        cbkembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbkembaliActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Kode Barang", "Nama Barang", "Tanggal Masuk", "Jumlah Stok", "Harga Barang"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5)
                            .addComponent(txkodebarang)
                            .addComponent(jLabel6)
                            .addComponent(txnamabarang)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(txjumlah)
                            .addComponent(jLabel9)
                            .addComponent(txharga)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cbsimpan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbhapus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cbedit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbtambah, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(cbkembali)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txkodebarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txnamabarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addGap(30, 30, 30)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txjumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txharga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbsimpan)
                    .addComponent(cbedit))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbhapus)
                    .addComponent(cbtambah))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbkembali)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbsimpanActionPerformed
        dl_data_stokbarang ck = new dl_data_stokbarang();
        ck.Kode_barang = txkodebarang.getText();
        ck.Nama_barang = txnamabarang.getText();
        ck.Jumlah_stok = txjumlah.getText();
        ck.Harga_barang = txharga.getText();
        
        Date selectedDate = date.getDate();
        if (selectedDate != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String formattedDate = sdf.format(selectedDate);
            ck.Tanggal_masuk = formattedDate;
        } else {
             JOptionPane.showMessageDialog(null, "Tanggal tidak boleh kosong!");
             return;
        }
        
        try {
            ck.simpan();
            autoNumber();
            JOptionPane.showMessageDialog(null, "Berhasil");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        // 7. Memindahkan ViewData() ke posisi yang benar
        ViewData();
    
    }//GEN-LAST:event_cbsimpanActionPerformed

    private void cbtambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbtambahActionPerformed
        autoNumber();
        txnamabarang.setText("");
        date.setDate(null);
        txjumlah.setText("");
        txharga.setText("");
    }//GEN-LAST:event_cbtambahActionPerformed

    private void cbeditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbeditActionPerformed
        dl_data_stokbarang ck = new dl_data_stokbarang();
        ck.Kode_barang = txkodebarang.getText();
        ck.Nama_barang = txnamabarang.getText();
        Date selectDate = date.getDate();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = sdf.format(selectDate);
        ck.Tanggal_masuk = formattedDate;
        ck.Jumlah_stok = txjumlah.getText();
        ck.Harga_barang = txharga.getText();
        try{
            ck.rubah();
            JOptionPane.showMessageDialog(null, "Berhasil");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error" + e.getMessage());
        }
        ViewData();
    }//GEN-LAST:event_cbeditActionPerformed

    private void cbhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbhapusActionPerformed
        String ObjButtons[]= {"yes","No"};
                int PromptResult = JOptionPane.showOptionDialog(null, "Yakin Mau Hapus?", "Massage", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, ObjButtons, ObjButtons[1]);
        if(PromptResult == 0){
            dl_data_stokbarang ck = new dl_data_stokbarang();
            ck.Kode_barang = txkodebarang.getText();
            try{
                ck.hapus();
                JOptionPane.showMessageDialog(null, "Berhasil Dihapus");
            }catch (Exception e){
                JOptionPane.showMessageDialog(null, "Error" + e.getMessage());
            }
            
        } 
        ViewData();
    }//GEN-LAST:event_cbhapusActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int row = jTable1.getSelectedRow();
        if (row >=0 && row < jTable1.getRowCount()){
            txkodebarang.setText(jTable1.getModel().getValueAt(row, 0).toString());
            txnamabarang.setText(jTable1.getModel().getValueAt(row, 1).toString());
            String dateString = jTable1.getModel().getValueAt(row, 2).toString();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            txjumlah.setText(jTable1.getModel().getValueAt(row, 3).toString());
            txharga.setText(jTable1.getModel().getValueAt(row, 4).toString());
            try{
                Date date = sdf.parse(dateString);
                this.date.setDate(date);
            }catch(Exception e){
                 e.printStackTrace();
           }
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void cbkembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbkembaliActionPerformed
        menu_salon1 mainMenu = new menu_salon1();
        mainMenu.setVisible(true);
        dispose();
    }//GEN-LAST:event_cbkembaliActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(stok.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(stok.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(stok.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(stok.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new stok().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cbedit;
    private javax.swing.JButton cbhapus;
    private javax.swing.JButton cbkembali;
    private javax.swing.JButton cbsimpan;
    private javax.swing.JButton cbtambah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txharga;
    private javax.swing.JTextField txjumlah;
    private javax.swing.JTextField txkodebarang;
    private javax.swing.JTextField txnamabarang;
    // End of variables declaration//GEN-END:variables
}
