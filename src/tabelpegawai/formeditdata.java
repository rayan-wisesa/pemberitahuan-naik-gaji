package tabelpegawai;
import javax.swing.ImageIcon;
import java.awt.Image; 
import java.awt.event.ComponentEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.event.ComponentAdapter;
import tabelpegawai.koneksi;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.time.LocalDate;

public class formeditdata extends javax.swing.JFrame {
    
    private String SQL; 
    
    public formeditdata() {
        initComponents();
        this.addComponentListener(new ComponentAdapter() {
            @Override
    public void componentResized(ComponentEvent e) {
        int frameWidth = getWidth();
        int frameHeight = getHeight();

        // Hitung ulang posisi komponen seperti di atas
        // (copy ulang logika setBounds di sini)
    }
});
        


    
    }
    
    public formeditdata(String nama, String nip, String jabatan, String unitKerja, String bulan, String tahun) {
    initComponents();
            int currentYear = java.time.Year.now().getValue();
        for (int i = currentYear; i <= currentYear + 10; i++) {
        combotahun.addItem(String.valueOf(i));
    }
        nama_pegawaifield.setText(nama);
        nip_field.setText(nip);
        comboboxjabatan.setSelectedItem(jabatan);
        comboboxunitkerja.setSelectedItem(unitKerja);
        combobulan.setSelectedItem(bulan);
        combotahun.setSelectedItem(tahun);
        this.setSize(1300, 750);   // sesuaikan dengan ukuran desain
        this.setLocationRelativeTo(null); // agar muncul di tengah layar
        this.setResizable(false);
        
                jLabel1.setBounds(0, 0, getWidth(), getHeight());
        
        String pathLogo = "/images/Lambang_Kota_Tanjungpinang.png";
        int lebarLogo = 100; 
        int tinggiLogo = 120; 
        
        tampilkanGambar(Logo_Tanjungpinang, pathLogo, lebarLogo, tinggiLogo);

}


    private void tampilkanGambar(JLabel label, String pathGambar, int lebar, int tinggi) {
        try {
            java.net.URL imageUrl = getClass().getResource(pathGambar);

            if (imageUrl != null) {
                ImageIcon originalIcon = new ImageIcon(imageUrl);
                Image img = originalIcon.getImage();
                Image scaledImage = img.getScaledInstance(lebar, tinggi, Image.SCALE_SMOOTH);
                ImageIcon finalIcon = new ImageIcon(scaledImage);
                label.setIcon(finalIcon);
                label.setText("");
            } else {
                System.err.println("Gambar tidak ditemukan pada path: " + pathGambar);
            }

        } catch (Exception e) {
            System.err.println("Gagal memproses gambar: " + e.getMessage());
            e.printStackTrace();
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Logo_Tanjungpinang = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        nama_pegawaifield = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        nip_field = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        comboboxjabatan = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        comboboxunitkerja = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        combobulan = new javax.swing.JComboBox<>();
        combotahun = new javax.swing.JComboBox<>();
        jButton3 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Logo_Tanjungpinang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Lambang_Kota_Tanjungpinang.png"))); // NOI18N
        getContentPane().add(Logo_Tanjungpinang, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 0, 130, 140));

        jPanel1.setBackground(java.awt.Color.white);
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel5.setFont(new java.awt.Font("Nirmala UI", 1, 24)); // NOI18N
        jLabel5.setText("Edit Data");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Nama Pegawai");

        nama_pegawaifield.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("NIP");

        nip_field.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("Jabatan");

        comboboxjabatan.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        comboboxjabatan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboboxjabatan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboboxjabatanActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setText("Unit Kerja");

        comboboxunitkerja.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        comboboxunitkerja.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Unit Kerja", "Item 2", "Item 3", "Item 4" }));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setText("Bulan Kenaikan Gaji");

        jButton1.setBackground(java.awt.Color.black);
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jButton1.setForeground(java.awt.Color.white);
        jButton1.setText("Tambah Data");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        combobulan.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        combobulan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Pilih Bulan--", "Januari", "Februari ", "Maret", "April", "Mei", "Juni", "Juli", "Agustus", "September", "Oktober", "November", "Desember" }));

        combotahun.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        combotahun.setModel(combotahun.getModel());
        combotahun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combotahunActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 628, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nama_pegawaifield)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(comboboxjabatan, 0, 280, Short.MAX_VALUE)
                            .addComponent(combobulan, 0, 280, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(comboboxunitkerja, 0, 280, Short.MAX_VALUE)
                            .addComponent(jLabel9)
                            .addComponent(combotahun, 0, 280, Short.MAX_VALUE)))
                    .addComponent(nip_field)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nama_pegawaifield, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nip_field, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comboboxjabatan, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboboxunitkerja))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(combobulan, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combotahun, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addGap(54, 54, 54))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 220, 630, 450));

        jButton3.setBackground(java.awt.Color.red);
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton3.setText("Kembali");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 600, -1, -1));

        jLabel4.setFont(new java.awt.Font("Nirmala UI", 1, 30)); // NOI18N
        jLabel4.setText("TANJUNGPINANG");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 160, -1, -1));

        jLabel2.setFont(new java.awt.Font("Nirmala UI", 0, 36)); // NOI18N
        jLabel2.setText("Pemerintahan Kota");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 130, -1, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bg_putih.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel3.setText("jLabel3");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 190, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboboxjabatanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboboxjabatanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboboxjabatanActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
    new formtabelpegawai().setVisible(true);
            dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
    int tanggal = 1;
    String bulanStr = combobulan.getSelectedItem().toString();

    if (bulanStr.equals("--Pilih Bulan--")) {
        JOptionPane.showMessageDialog(null, "Silakan pilih bulan terlebih dahulu!");
        return; // hentikan proses insert
    }


    int bulan = 0;
    switch (bulanStr) {
    case "Januari": bulan = 1; break;
    case "Februari": bulan = 2; break;
    case "Maret": bulan = 3; break;
    case "April": bulan = 4; break;
    case "Mei": bulan= 5; break;
    case "Juni": bulan = 6; break;
    case "Juli": bulan = 7; break;
    case "Agustus": bulan = 8; break;
    case "September": bulan = 9; break;
    case "Oktober": bulan = 10; break;
    case "November": bulan = 11; break;
    case "Desember": bulan = 12; break;
    }
    
    int tahun = Integer.parseInt(combotahun.getSelectedItem().toString());

    // gabungkan jadi LocalDate
    LocalDate date = LocalDate.of(tahun, bulan, tanggal);

        java.sql.Connection conn = new koneksi().connect();
    try{
            java.sql.PreparedStatement stmt = conn.prepareStatement("UPDATE kenaikan_gaji SET nama=?, nip_pegawai=?, jabatan=?, unit_kerja=?, bulan_kenaikan=? WHERE nip_pegawai=?");
            try{
                stmt.setString(1, nama_pegawaifield.getText());
                stmt.setString(2, nip_field.getText());
                stmt.setString(3, comboboxjabatan.getSelectedItem().toString());
                stmt.setString(4, comboboxunitkerja.getSelectedItem().toString());
                stmt.setDate(5, java.sql.Date.valueOf(date));
                stmt.setString(6, nip_field.getText()); // nip lama atau nip yang jadi kunci
                stmt.executeUpdate();
                JOptionPane.showMessageDialog(null,"Data Berhasil di Simpan","Pesan",JOptionPane.INFORMATION_MESSAGE);
                new formtabelpegawai().setVisible(true);
            dispose();
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Data Gagal di Simpan","Pesan",JOptionPane.INFORMATION_MESSAGE);
            }
    }catch(Exception e){

    }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void combotahunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combotahunActionPerformed

    }//GEN-LAST:event_combotahunActionPerformed

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
            java.util.logging.Logger.getLogger(formeditdata.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(formeditdata.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(formeditdata.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(formeditdata.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new formeditdata().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Logo_Tanjungpinang;
    private javax.swing.JComboBox<String> comboboxjabatan;
    private javax.swing.JComboBox<String> comboboxunitkerja;
    private javax.swing.JComboBox<String> combobulan;
    private javax.swing.JComboBox<String> combotahun;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField nama_pegawaifield;
    private javax.swing.JTextField nip_field;
    // End of variables declaration//GEN-END:variables
}
