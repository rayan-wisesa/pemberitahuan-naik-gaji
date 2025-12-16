package tabelpegawai;

import javax.swing.ImageIcon;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.time.LocalDate;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.table.JTableHeader;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableCellRenderer;

public class formtabelpegawai extends javax.swing.JFrame {
    
    private JTextField field_cari;
    private DefaultTableModel tabel_gaji;
    private String SQL;
    
     public void tampilData(String keyword) {
         
    tabel_gaji = new DefaultTableModel();
    tabel_gaji.addColumn("No");
    tabel_gaji.addColumn("Nama");
    tabel_gaji.addColumn("NIP");
    tabel_gaji.addColumn("Pangkat");
    tabel_gaji.addColumn("Jabatan");
    tabel_gaji.addColumn("Bulan Kenaikan");
    tabel_gajiform.setModel(tabel_gaji);
    
    TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(tabel_gaji);
    tabel_gajiform.setRowSorter(sorter);

    java.sql.Connection conn = new koneksi().connect();
    try{
        String sql;
        PreparedStatement stmt;
        if (keyword.isEmpty()) {
                sql = "SELECT pegawai.nama, pegawai.nip, pangkat.pangkat, pegawai.jabatan, gaji.kenaikan AS bulan_kenaikan " +
                  "FROM gaji " +
                  "JOIN pegawai ON gaji.nip_pegawai = pegawai.nip " +
                  "JOIN pangkat ON gaji.id_pangkat = pangkat.id_pangkat";

                stmt = conn.prepareStatement(sql);
            } else {
                sql = "SELECT pegawai.nama, pegawai.nip, pangkat.pangkat, pegawai.jabatan, gaji.kenaikan AS bulan_kenaikan " +
                  "FROM gaji " +
                  "JOIN pegawai ON gaji.nip_pegawai = pegawai.nip " +
                  "JOIN pangkat ON gaji.id_pangkat = pangkat.id_pangkat " +
                  "WHERE pegawai.nama LIKE ?";

;
                stmt = conn.prepareStatement(sql);
                stmt.setString(1, "%" + keyword + "%");
            }

            ResultSet res = stmt.executeQuery();
            int no = 1;
            while (res.next()) {
                tabel_gaji.addRow(new Object[]{
                no++,
                res.getString("nama"),
                res.getString("nip"),
                res.getString("pangkat"),
                res.getString("jabatan"),
                res.getString("bulan_kenaikan")
                });
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Database error: " + ex.getMessage());
        }
     }

    public formtabelpegawai() {
    initComponents();

    // frame
    setTitle("Data Kenaikan Gaji Pegawai");
    setSize(1245, 690);
    setLocationRelativeTo(null);
    setResizable(false);

    // logo
    tampilkanGambar(
        Logo_Tanjungpinang,
        "/images/Lambang_Kota_Tanjungpinang.png",
        80,
        100
    );

    // field pencarian
    fieldcari.putClientProperty(
        "JTextField.placeholderText",
        "Cari nama pegawai..."
    );
    fieldcari.putClientProperty(
        "FlatLaf.style",
        "arc:14"
    );

    // tombol
    styleButton(btncari, new Color(59,130,246));   // Biru
    styleButton(jButton1, new Color(34,197,94));   // Hijau
    styleButton(jButton2, new Color(234,179,8));   // Kuning
    styleButton(jButton4, new Color(239,68,68));   // Merah

    // tabel
    styleTable();
    addTableHoverEffect();

    // fitur enter untuk cari
    fieldcari.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
    public void insertUpdate(javax.swing.event.DocumentEvent e) { search(); }
    public void removeUpdate(javax.swing.event.DocumentEvent e) { search(); }
    public void changedUpdate(javax.swing.event.DocumentEvent e) { search(); }

    private void search() {
        tampilData(fieldcari.getText().trim());
    }
});


    tampilData("");
}
    
private void styleButton(JButton btn, Color color) {
    btn.setBackground(color);
    btn.setForeground(Color.WHITE);
    btn.setFocusPainted(false);
    btn.setBorderPainted(false);
    btn.setCursor(new Cursor(Cursor.HAND_CURSOR));

    btn.putClientProperty(
        "FlatLaf.style",
        "arc:18; font:bold"
    );
}

private void styleTable() {
    tabel_gajiform.setRowHeight(36);
    tabel_gajiform.setFont(new Font("Segoe UI", Font.PLAIN, 15));

    tabel_gajiform.setShowVerticalLines(false);
    tabel_gajiform.setShowHorizontalLines(true);
    tabel_gajiform.setGridColor(new Color(230,230,230));

    tabel_gajiform.setSelectionBackground(new Color(59,130,246));
    tabel_gajiform.setSelectionForeground(Color.WHITE);

    JTableHeader header = tabel_gajiform.getTableHeader();
    header.setFont(new Font("Segoe UI Semibold", Font.BOLD, 15));
    header.setBackground(new Color(243,244,246));
    header.setForeground(Color.BLACK);
    header.setPreferredSize(new Dimension(header.getWidth(), 40));

    // Rata tengah header
    ((DefaultTableCellRenderer) header.getDefaultRenderer())
        .setHorizontalAlignment(JLabel.CENTER);
}

private void addTableHoverEffect() {
    tabel_gajiform.addMouseMotionListener(new MouseMotionAdapter() {
        @Override
        public void mouseMoved(MouseEvent e) {
            int row = tabel_gajiform.rowAtPoint(e.getPoint());
            tabel_gajiform.setRowSelectionInterval(row, row);
        }
    });
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
                jLabel1.setText("");
                jLabel1.setBounds(0, 0, getWidth(), getHeight());
                
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

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel_gajiform = new javax.swing.JTable();
        btncari = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        fieldcari = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        Logo_Tanjungpinang = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Nirmala UI", 0, 36)); // NOI18N
        jLabel2.setText("Pemerintah Kota");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 130, -1, 30));

        jLabel3.setFont(new java.awt.Font("Nirmala UI", 1, 30)); // NOI18N
        jLabel3.setText("TANJUNGPINANG");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 160, -1, -1));

        jLabel4.setFont(new java.awt.Font("Nirmala UI", 0, 24)); // NOI18N
        jLabel4.setText("Data Kenaikan Gaji");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 190, -1, -1));

        tabel_gajiform.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tabel_gajiform.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "No.", "Nama", "NIP", "Jabatan", "Unit Kerja", "Bulan Kenaikan Gaji"
            }
        ));
        tabel_gajiform.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_gajiformMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabel_gajiform);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 290, 930, 250));

        btncari.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btncari.setText("Cari");
        btncari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncariActionPerformed(evt);
            }
        });
        getContentPane().add(btncari, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 260, -1, 30));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setText("Tambah Data");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 550, -1, -1));

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton2.setText("Edit Data");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 550, 130, -1));

        fieldcari.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        fieldcari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldcariActionPerformed(evt);
            }
        });
        getContentPane().add(fieldcari, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 260, 160, -1));

        jButton4.setBackground(new java.awt.Color(255, 0, 0));
        jButton4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton4.setText("Hapus");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 550, 130, -1));

        Logo_Tanjungpinang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Lambang_Kota_Tanjungpinang.png"))); // NOI18N
        getContentPane().add(Logo_Tanjungpinang, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 20, 100, 110));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bg_putih.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fieldcariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldcariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldcariActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new formtambahdata().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        tampilData("");
    }//GEN-LAST:event_formWindowOpened

    private void btncariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncariActionPerformed
        String keyword = fieldcari.getText().trim();
        tampilData(keyword);

    }//GEN-LAST:event_btncariActionPerformed


    private void tabel_gajiformMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_gajiformMouseClicked

    }//GEN-LAST:event_tabel_gajiformMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
int row = tabel_gajiform.getSelectedRow();
if (row != -1) {
    String nama = tabel_gajiform.getValueAt(row, 1).toString();
    String nip = tabel_gajiform.getValueAt(row, 2).toString();
    String pangkat = tabel_gajiform.getValueAt(row, 3).toString();
    String jabatan = tabel_gajiform.getValueAt(row, 4).toString();

    // ambil kolom bulan_kenaikan (format DATE dari database)
    String tanggalStr = tabel_gajiform.getValueAt(row, 5).toString(); // contoh: "2025-12-01"

    // parsing ke LocalDate
    LocalDate date = LocalDate.parse(tanggalStr); 
    int bulan = date.getMonthValue(); // 1–12
    int tahun = date.getYear();

    // konversi angka bulan ke nama bulan
    String bulanStr = "";
    switch (bulan) {
        case 1: bulanStr = "Januari"; break;
        case 2: bulanStr = "Februari"; break;
        case 3: bulanStr = "Maret"; break;
        case 4: bulanStr = "April"; break;
        case 5: bulanStr = "Mei"; break;
        case 6: bulanStr = "Juni"; break;
        case 7: bulanStr = "Juli"; break;
        case 8: bulanStr = "Agustus"; break;
        case 9: bulanStr = "September"; break;
        case 10: bulanStr = "Oktober"; break;
        case 11: bulanStr = "November"; break;
        case 12: bulanStr = "Desember"; break;
    }

    // kirim ke form edit
    formeditdata editForm = new formeditdata(nama, nip, pangkat, jabatan, bulanStr, String.valueOf(tahun));
    editForm.setVisible(true);
}

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
    java.sql.Connection conn = new koneksi().connect();
    int row = tabel_gajiform.getSelectedRow();
    UIManager.put("OptionPane.messageFont", new Font("Segoe UI", Font.PLAIN, 14));
    UIManager.put("OptionPane.buttonFont", new Font("Segoe UI", Font.BOLD, 13));

    int ok = JOptionPane.showConfirmDialog(
        this,
        "Yakin ingin menghapus data pegawai?",
        "Konfirmasi",
        JOptionPane.YES_NO_OPTION,
        JOptionPane.WARNING_MESSAGE
    );

    if(ok==0){
        try{
            SQL="delete from kenaikan_gaji where nip_pegawai='"+tabel_gajiform.getValueAt(row, 2).toString()+"'";
            java.sql.PreparedStatement stmt = conn.prepareStatement(SQL);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null,"Data Berhasil di Hapus");
            tampilData("");
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Data Gagal Di Hapus");
        }
    }
    }//GEN-LAST:event_jButton4ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
    com.formdev.flatlaf.FlatLightLaf.setup();

    java.awt.EventQueue.invokeLater(() -> {
        new formtabelpegawai().setVisible(true);
    });
}


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Logo_Tanjungpinang;
    private javax.swing.JButton btncari;
    private javax.swing.JTextField fieldcari;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabel_gajiform;
    // End of variables declaration//GEN-END:variables
}
