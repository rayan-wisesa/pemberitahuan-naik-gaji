package tabelpegawai;
import javax.swing.*;
import java.awt.Image; 
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import tabelpegawai.koneksi;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.Map;
import java.util.HashMap;

public class formtambahadmin extends javax.swing.JFrame {

    private String SQL;
    
    public formtambahadmin() {
        initComponents();
        
    // Placeholder
    usernameField.putClientProperty(
    "JTextField.placeholderText", "Masukkan username"
);

    passwordField.putClientProperty(
    "JTextField.placeholderText", "Masukkan password"
);

    jPanel1.putClientProperty(
    "FlatLaf.style",
    "arc:25; background:#ffffff"
);
    jPanel1.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
    
    usernameField.putClientProperty(
    "JTextField.placeholderText", "Masukkan username admin"
);
    passwordField.putClientProperty(
    "JTextField.placeholderText", "Masukkan password"
);
    
    // Label
    jLabel6.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
    jLabel7.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));

    // Input
    usernameField.setFont(new Font("Segoe UI", Font.PLAIN, 16));
    passwordField.setFont(new Font("Segoe UI", Font.PLAIN, 16));


    usernameField.putClientProperty("FlatLaf.style", "arc:14");
    passwordField.putClientProperty("FlatLaf.style", "arc:14");

    styleButton(jButton1, new Color(22, 163, 74)); 
    jButton1.setText("SIMPAN ADMIN");
    styleButton(jButton3, new Color(239, 68, 68)); 
    jButton3.setText("KEMBALI");

        
        jLabel1.setBounds(0, 0, getWidth(), getHeight());
        
        String pathLogo = "/images/Lambang_Kota_Tanjungpinang.png";
        int lebarLogo = 100; 
        int tinggiLogo = 120; 
        
        tampilkanGambar(Logo_Tanjungpinang, pathLogo, lebarLogo, tinggiLogo);
        this.setSize(1300, 750);   // sesuaikan dengan ukuran desain
        this.setLocationRelativeTo(null); // agar muncul di tengah layar
        this.setResizable(false);
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
        usernameField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        passwordField = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Logo_Tanjungpinang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Lambang_Kota_Tanjungpinang.png"))); // NOI18N
        getContentPane().add(Logo_Tanjungpinang, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 0, 130, 140));

        jPanel1.setBackground(java.awt.Color.white);
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel5.setFont(new java.awt.Font("Segoe UI Semibold", 1, 28));
        jLabel5.setForeground(new Color(22, 163, 74));
        jLabel5.setText("Tambah Admin");

        jLabel6.setText("USERNAME");

        jLabel7.setText("PASSWORD");

        jButton1.setBackground(java.awt.Color.black);
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jButton1.setForeground(java.awt.Color.white);
        jButton1.setText("Tambah Data");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
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
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(0, 513, Short.MAX_VALUE))
                    .addComponent(usernameField)
                    .addComponent(passwordField, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(215, 215, 215))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(27, 27, 27)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addGap(26, 26, 26)
                .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(68, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 210, 630, 400));

        jButton3.setBackground(java.awt.Color.red);
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton3.setText("Kembali");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 550, -1, -1));

        jLabel4.setFont(new java.awt.Font("Nirmala UI", 1, 30)); // NOI18N
        jLabel4.setText("TANJUNGPINANG");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 160, -1, -1));

        jLabel2.setFont(new java.awt.Font("Nirmala UI", 0, 36)); // NOI18N
        jLabel2.setText("Pemerintahan Kota");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 130, -1, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bg_putih.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
    new tabelpegawaiadmin.formtabelpegawaiadmin().setVisible(true);
            dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    String username = usernameField.getText().trim();
    String password = passwordField.getText().trim();

    // validasi
    if (username.isEmpty() || password.isEmpty()) {
        JOptionPane.showMessageDialog(
            this,
            "Username dan Password tidak boleh kosong!",
            "Peringatan",
            JOptionPane.WARNING_MESSAGE
        );
        return;
    }

    try {
        Connection conn = new koneksi().connect();

        // cek username sudah ada atau belum
        String cekSql = "SELECT * FROM users WHERE username=?";
        PreparedStatement cekStmt = conn.prepareStatement(cekSql);
        cekStmt.setString(1, username);
        ResultSet rs = cekStmt.executeQuery();

        if (rs.next()) {
            JOptionPane.showMessageDialog(
                this,
                "Username sudah digunakan!",
                "Gagal",
                JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        // simpan admin
        String sql = "INSERT INTO users (username, password, role) VALUES (?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, username);
        stmt.setString(2, password); // (nanti bisa di-hash)
        stmt.setString(3, "admin");

        stmt.executeUpdate();

        JOptionPane.showMessageDialog(
            this,
            "Admin berhasil ditambahkan!",
            "Sukses",
            JOptionPane.INFORMATION_MESSAGE
        );

        // reset field
        usernameField.setText("");
        passwordField.setText("");

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(
            this,
            "Gagal menyimpan admin: " + e.getMessage(),
            "Error",
            JOptionPane.ERROR_MESSAGE
        );
    }
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
    com.formdev.flatlaf.FlatLightLaf.setup();

    java.awt.EventQueue.invokeLater(() -> {
        new formtambahadmin().setVisible(true);
    });
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Logo_Tanjungpinang;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField passwordField;
    private javax.swing.JTextField usernameField;
    // End of variables declaration//GEN-END:variables
}
