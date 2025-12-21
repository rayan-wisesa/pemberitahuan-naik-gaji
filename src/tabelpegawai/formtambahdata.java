package tabelpegawai;
import javax.swing.*;
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
import java.sql.Date;
import java.sql.ResultSet;
import java.util.Map;
import java.util.HashMap;

public class formtambahdata extends javax.swing.JFrame {

    private String SQL;
    
    public formtambahdata() {
        initComponents();
        loadPangkatComboBox();
    
    // Placeholder
    nama_pegawaifield.putClientProperty(
    "JTextField.placeholderText", "Masukkan nama pegawai"
);

    nip_field.putClientProperty(
    "JTextField.placeholderText", "Masukkan NIP pegawai"
);

    jabatan_field.putClientProperty(
    "JTextField.placeholderText", "Masukkan jabatan"
);
    
    nama_pegawaifield.putClientProperty("FlatLaf.style", "arc:14");
    nip_field.putClientProperty("FlatLaf.style", "arc:14");
    jabatan_field.putClientProperty("FlatLaf.style", "arc:14");

    comboboxpangkat.putClientProperty("FlatLaf.style", "arc:14");
    combobulan.putClientProperty("FlatLaf.style", "arc:14");
    combotahun.putClientProperty("FlatLaf.style", "arc:14");

    styleButton(jButton1, new java.awt.Color(34,197,94));
    styleButton(jButton3, new java.awt.Color(239,68,68));


        this.addComponentListener(new ComponentAdapter() {
            @Override
    public void componentResized(ComponentEvent e) {
        int frameWidth = getWidth();
        int frameHeight = getHeight();

        // Hitung ulang posisi komponen seperti di atas
        // (copy ulang logika setBounds di sini)
    }
});
        
        jLabel1.setBounds(0, 0, getWidth(), getHeight());
        
        String pathLogo = "/images/Lambang_Kota_Tanjungpinang.png";
        int lebarLogo = 100; 
        int tinggiLogo = 120; 
        
        tampilkanGambar(Logo_Tanjungpinang, pathLogo, lebarLogo, tinggiLogo);
        this.setSize(1300, 750);   // Mengatur ukuran aplikasi
        this.setLocationRelativeTo(null); // Supaya aplikasi muncul di tengah layar
        this.setResizable(false); // Supaya user tidak dapat meresize aplikasi
    
    int currentYear = java.time.Year.now().getValue();
    for (int i = currentYear; i <= currentYear + 10; i++) {
        combotahun.addItem(String.valueOf(i));
    }

    }
    
private void styleButton(javax.swing.JButton btn, java.awt.Color bg) {
    btn.setBackground(bg);
    btn.setForeground(java.awt.Color.WHITE);
    btn.setFocusPainted(false);
    btn.setBorderPainted(false);
    btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

    btn.putClientProperty(
        "FlatLaf.style",
        "arc:18; font:bold"
    );
}

private Map<String, Integer> pangkatMap = new HashMap<>();
    

private void loadPangkatComboBox() {
    // Load isi dari tabel pangkat untuk ditampilkan di combobox
    try {
        Connection conn = new koneksi().connect();
        PreparedStatement stmt = conn.prepareStatement("SELECT id_pangkat, pangkat FROM pangkat ORDER BY pangkat");
        ResultSet rs = stmt.executeQuery();

        comboboxpangkat.removeAllItems();
        comboboxpangkat.addItem("--Pilih Pangkat--");

        pangkatMap.clear(); // kosongkan map

        while (rs.next()) {
            int idPangkat = rs.getInt("id_pangkat");
            String namaPangkat = rs.getString("pangkat");

            comboboxpangkat.addItem(namaPangkat);   // tampilkan hanya nama
            pangkatMap.put(namaPangkat, idPangkat); // simpan mapping nama ke id
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, "Gagal load data pangkat: " + ex.getMessage());
    }
}

    private void tampilkanGambar(JLabel label, String pathGambar, int lebar, int tinggi) {
        // Menampilkan gambar logo
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
        comboboxpangkat = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        combobulan = new javax.swing.JComboBox<>();
        combotahun = new javax.swing.JComboBox<>();
        jabatan_field = new javax.swing.JTextField();
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
        jLabel5.setText("Tambah Data");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Nama Pegawai");

        nama_pegawaifield.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("NIP");

        nip_field.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("Pangkat");

        comboboxpangkat.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        comboboxpangkat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Pilih Pangkat--", "Pembina Utama Muda / IVc", "Pembina Tk.I / IVb", "Pembina / IVa", "Penata Tk.I / IIId", "Penata / IIIc", "Penata Muda Tk. I / IIIb", "Penata Muda / IIIa", "Pengatur Tk. I / IId", "Pengatur / IIc", "IX", "VII", "V" }));
        comboboxpangkat.setMinimumSize(new java.awt.Dimension(111, 28));
        comboboxpangkat.setPreferredSize(new java.awt.Dimension(111, 28));
        comboboxpangkat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboboxpangkatActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setText("Jabatan");

        jButton1.setBackground(java.awt.Color.black);
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jButton1.setForeground(java.awt.Color.white);
        jButton1.setText("Tambah Data");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setText("Bulan Kenaikan Gaji");

        combobulan.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        combobulan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Pilih Bulan--", "Januari", "Februari ", "Maret", "April", "Mei", "Juni", "Juli", "Agustus", "September", "Oktober", "November", "Desember" }));

        combotahun.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        combotahun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combotahunActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nip_field)
                    .addComponent(nama_pegawaifield)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(combobulan, javax.swing.GroupLayout.Alignment.LEADING, 0, 280, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboboxpangkat, javax.swing.GroupLayout.Alignment.LEADING, 0, 280, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(combotahun, 0, 280, Short.MAX_VALUE)
                            .addComponent(jabatan_field))))
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
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jabatan_field)
                    .addComponent(comboboxpangkat, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(combobulan, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combotahun, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap())
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 220, 630, 430));

        jButton3.setBackground(java.awt.Color.red);
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton3.setText("Kembali");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 620, -1, -1));

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

    private void comboboxpangkatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboboxpangkatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboboxpangkatActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
    // Pindah ke halaman tabel pegawai
        new formtabelpegawai().setVisible(true);
            dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
                                       

int tanggal = 1;
String bulanStr = combobulan.getSelectedItem().toString();
    
    if (bulanStr.equals("--Pilih Bulan--")) {
        JOptionPane.showMessageDialog(null, "Silakan pilih bulan terlebih dahulu!");
        return; // Menghentikan proses insert
    }

    String pangkatStr = comboboxpangkat.getSelectedItem().toString();
    if (pangkatStr.equals("--Pilih Pangkat--")) {
        JOptionPane.showMessageDialog(this, "Silakan pilih pangkat terlebih dahulu!");
        return;
    }
    int idPangkat = pangkatMap.get(pangkatStr); // ambil id dari map

        int bulan = 0;
        switch (bulanStr) {
            case "Januari": bulan = 1; break;
            case "Februari": bulan = 2; break;
            case "Maret": bulan = 3; break;
            case "April": bulan = 4; break;
            case "Mei": bulan = 5; break;
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

    try {
        Connection conn = new koneksi().connect();

        // Menyimpan pegawai jika belum ada
        PreparedStatement checkPegawai = conn.prepareStatement(
            "SELECT nip FROM pegawai WHERE nip = ?"
        );
        checkPegawai.setString(1, nip_field.getText());
        ResultSet rs = checkPegawai.executeQuery();

        if (!rs.next()) { // Insert jika belum ada
            PreparedStatement stmtPegawai = conn.prepareStatement(
                "INSERT INTO pegawai (nip, nama, jabatan) VALUES (?, ?, ?)"
            );
            stmtPegawai.setString(1, nip_field.getText());
            stmtPegawai.setString(2, nama_pegawaifield.getText());
            stmtPegawai.setString(3, jabatan_field.getText());
            stmtPegawai.executeUpdate();
        }

        // Menyimpan data kedalam tabel gaji
        PreparedStatement stmtGaji = conn.prepareStatement(
            "INSERT INTO gaji (nip_pegawai, id_pangkat, kenaikan) VALUES (?, ?, ?)"
        );
        stmtGaji.setString(1, nip_field.getText());
        stmtGaji.setInt(2, idPangkat);
        stmtGaji.setDate(3, java.sql.Date.valueOf(date));
        stmtGaji.executeUpdate();

        JOptionPane.showMessageDialog(this, "Data Berhasil Disimpan", "Pesan", JOptionPane.INFORMATION_MESSAGE);

        new formtabelpegawai().setVisible(true);
        dispose();

    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, "Data Gagal Disimpan: " + ex.getMessage(), "Pesan", JOptionPane.ERROR_MESSAGE);
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Terjadi error: " + e.getMessage(), "Pesan", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void combotahunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combotahunActionPerformed

    }//GEN-LAST:event_combotahunActionPerformed
    
    public static class PangkatItem {
        public final int idPangkat;
        public final String pangkat;

    public PangkatItem(int idPangkat, String pangkat) {
        this.idPangkat = idPangkat;
        this.pangkat = pangkat;
    }

    @Override
    public String toString() {
        return pangkat; // hanya tampilkan nama pangkat di combobox
    }
}
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
    com.formdev.flatlaf.FlatLightLaf.setup();

    java.awt.EventQueue.invokeLater(() -> {
        new formtambahdata().setVisible(true);
    });
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Logo_Tanjungpinang;
    private javax.swing.JComboBox<String> comboboxpangkat;
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
    private javax.swing.JTextField jabatan_field;
    private javax.swing.JTextField nama_pegawaifield;
    private javax.swing.JTextField nip_field;
    // End of variables declaration//GEN-END:variables
}
