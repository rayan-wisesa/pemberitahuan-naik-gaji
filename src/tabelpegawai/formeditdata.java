package tabelpegawai;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.awt.Image;
import java.awt.Color;
import java.awt.Cursor;
import java.sql.Connection;
import java.sql.ResultSet;

import java.time.LocalDate;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;


public class formeditdata extends javax.swing.JFrame {     
       
public formeditdata() {
    initComponents();
    loadPangkatComboBox();
    
    setSize(1300, 750); // Mengatur ukuran aplikasi
    setLocationRelativeTo(null); // Supaya aplikasi muncul di tengah layar
    setResizable(false); // Supaya user tidak dapat meresize aplikasi

    int currentYear = java.time.Year.now().getValue();
    for (int i = currentYear; i <= currentYear + 10; i++) {
        combotahun.addItem(String.valueOf(i));
    }

    tampilkanGambar(
        Logo_Tanjungpinang,
        "/images/Lambang_Kota_Tanjungpinang.png",
        100,
        120
    );

    styleButton(jButton1, new Color(34,197,94));
    styleButton(jButton3, new Color(239,68,68));
}

public formeditdata(String nama, String nip, String pangkat,
                    String jabatan, String bulan, String tahun) {

    this(); // panggil constructor kosong dulu

    nama_pegawaifield.setText(nama);
    nip_field.setText(nip);
    comboboxpangkat.setSelectedItem(pangkat);
    jabatan_field.setText(jabatan);
    combobulan.setSelectedItem(bulan);
    combotahun.setSelectedItem(tahun);
}

private void styleButton(JButton btn, Color bg) {
    btn.setBackground(bg);
    btn.setForeground(Color.WHITE);
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
            pangkatMap.put(namaPangkat, idPangkat); // simpan mapping nama → id
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, "Gagal load data pangkat: " + ex.getMessage());
    }
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
        comboboxpangkat = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        combobulan = new javax.swing.JComboBox<>();
        combotahun = new javax.swing.JComboBox<>();
        jabatan_field = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
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
        jLabel8.setText("Pangkat");

        comboboxpangkat.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        comboboxpangkat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Pilih Pangkat--", "Pembina Utama Muda / IVc", "Pembina Tk.I / IVb", "Pembina / IVa", "Penata Tk.I / IIId", "Penata / IIIc", "Penata Muda Tk. I / IIIb", "Penata Muda / IIIa", "Pengatur Tk. I / IId", "Pengatur / IIc", "IX", "VII", "V" }));
        comboboxpangkat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboboxpangkatActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setText("Jabatan");

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

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setText("Tahun Kenaikan Gaji");

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
                    .addComponent(nip_field)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel6)
                                .addComponent(jLabel5)
                                .addComponent(jLabel7)
                                .addComponent(jLabel8)
                                .addComponent(comboboxpangkat, 0, 280, Short.MAX_VALUE)
                                .addComponent(combobulan, 0, 280, Short.MAX_VALUE))
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel9)
                                .addComponent(combotahun, 0, 280, Short.MAX_VALUE)
                                .addComponent(jabatan_field)))))
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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboboxpangkat, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jabatan_field, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(combobulan, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combotahun, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 220, 630, 420));

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

    private void comboboxpangkatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboboxpangkatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboboxpangkatActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
    new formtabelpegawai().setVisible(true);
            dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    // Mengambil data yang ada di form
    if (nama_pegawaifield.getText().trim().isEmpty()) {
    JOptionPane.showMessageDialog(this, "Nama tidak boleh kosong");
    return;
}

    if (nip_field.getText().trim().isEmpty()) {
    JOptionPane.showMessageDialog(this, "NIP tidak boleh kosong");
    return;
}

    if (jabatan_field.getText().trim().isEmpty()) {
    JOptionPane.showMessageDialog(this, "Jabatan tidak boleh kosong");
    return;
}

    int tanggal = 1;
    String bulanStr = combobulan.getSelectedItem().toString();
    String pangkatStr = comboboxpangkat.getSelectedItem().toString();
    
    if (bulanStr.equals("--Pilih Bulan--")) {
        JOptionPane.showMessageDialog(null, "Silakan pilih bulan terlebih dahulu!");
        return; // hentikan proses insert
    }
    
    if (pangkatStr.equals("--Pilih Pangkat--")) {
        JOptionPane.showMessageDialog(null, "Silakan pilih pangkat terlebih dahulu!");
        return; // hentikan proses insert
    }
    
    // Mengonversi angka menjadi bulan
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

    int idPangkat = pangkatMap.get(pangkatStr); // ambil id dari map
    
    // gabungkan jadi LocalDate
    LocalDate date = LocalDate.of(tahun, bulan, tanggal);

        java.sql.Connection conn = new koneksi().connect();
    try {

    // Mengupdate data pegawai
    PreparedStatement stmtPegawai = conn.prepareStatement(
        "UPDATE pegawai SET nama=?, jabatan=? WHERE nip=?"
    );
    stmtPegawai.setString(1, nama_pegawaifield.getText());
    stmtPegawai.setString(2, jabatan_field.getText());
    stmtPegawai.setString(3, nip_field.getText());
    stmtPegawai.executeUpdate();

    PreparedStatement stmtGaji = conn.prepareStatement(
        "UPDATE gaji SET id_pangkat=?, kenaikan=? WHERE nip_pegawai=?"
    );
    stmtGaji.setInt(1, idPangkat);
    stmtGaji.setDate(2, java.sql.Date.valueOf(date)); // date dari input bulan/tahun
    stmtGaji.setString(3, nip_field.getText());
    stmtGaji.executeUpdate();

    // 4. Pesan sukses dan buka tabel pegawai
    JOptionPane.showMessageDialog(this, "Data Berhasil diupdate", "Pesan", JOptionPane.INFORMATION_MESSAGE);
    new formtabelpegawai().setVisible(true);
    dispose();

} catch (SQLException ex) {
    JOptionPane.showMessageDialog(this, "Data Gagal diupdate: " + ex.getMessage(), "Pesan", JOptionPane.ERROR_MESSAGE);
}catch(Exception e){

    }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void combotahunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combotahunActionPerformed

    }//GEN-LAST:event_combotahunActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
    com.formdev.flatlaf.FlatLightLaf.setup();

    java.awt.EventQueue.invokeLater(() -> {
        new formeditdata().setVisible(true);
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
    private javax.swing.JLabel jLabel11;
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
