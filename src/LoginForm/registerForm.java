package LoginForm;

import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Color;
import java.awt.Cursor;
import LoginForm.loginForm;
import javax.swing.ImageIcon;
import java.awt.Image;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import tabelpegawai.formtabelpegawai;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.*;
import tabelpegawai.koneksi;

public class registerForm extends javax.swing.JFrame {
    
    private String SQL;
    
    private String hashPassword(String password) {
    try {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hashedBytes = md.digest(password.getBytes());

        // ubah byte ke hex string
        StringBuilder sb = new StringBuilder();
        for (byte b : hashedBytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    } catch (NoSuchAlgorithmException e) {
        throw new RuntimeException("Error hashing password", e);
    }
}

    
    private void efekHover(javax.swing.JButton btn) {
    java.awt.Color normal = btn.getBackground();
    java.awt.Color hover  = new java.awt.Color(21, 128, 61);

    btn.setOpaque(true);

    btn.addMouseListener(new java.awt.event.MouseAdapter() {
        @Override
        public void mouseEntered(java.awt.event.MouseEvent e) {
            btn.setBackground(hover);
        }

        @Override
        public void mouseExited(java.awt.event.MouseEvent e) {
            btn.setBackground(normal);
        }
    });
}

    public registerForm() {
        initComponents();
        
    // Enter untuk register
       getRootPane().setDefaultButton(Register);
       Register.setText("DAFTAR");
        
        // Style FlatLaf
        Register.putClientProperty(
        "FlatLaf.style",
        "arc:18; font:$h3.font"
    );

    jusernamefield.putClientProperty(
        "FlatLaf.style", "arc:14"
    );

    jpasswordfield.putClientProperty(
        "FlatLaf.style", "arc:14"
    );
    
    // Pengganti welcome
    WELCOME.setText("REGISTER AKUN");
    WELCOME.setForeground(new Color(22, 163, 74));

    
    // link loginForm
    lblLogin.setText("<html>Sudah punya akun? <u>Login disini</u></html>");
    lblLogin.setFont(new java.awt.Font("Segoe UI", 0, 14));
    lblLogin.setForeground(new Color(59, 130, 246));
    lblLogin.setCursor(new Cursor(Cursor.HAND_CURSOR));

    lblLogin.addMouseListener(new java.awt.event.MouseAdapter() {
        @Override
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            lblLoginMouseClicked(evt);
    }

        @Override
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            lblLogin.setForeground(new Color(239, 68, 68));
            lblLogin.setCursor(new Cursor(Cursor.HAND_CURSOR));
            lblLogin.setFont(new java.awt.Font("Segoe UI", 0, 14));
    }

        @Override
        public void mouseExited(java.awt.event.MouseEvent evt) {
            lblLogin.setForeground(new Color(59, 130, 246));
    }
});

    // Placeholder 
    jusernamefield.putClientProperty(
    "JTextField.placeholderText", "Masukkan Username"
    );
    jpasswordfield.putClientProperty(
        "JTextField.placeholderText", "Masukkan Password"
    );
      
        efekHover(Register);

        getRootPane().putClientProperty("JComponent.arc", 20);
        
        setLocationRelativeTo(null);  // tengah layar
        
        getRootPane().setBorder(
        javax.swing.BorderFactory.createEmptyBorder(12, 12, 12, 12)
        );
        
        jusernamefield.putClientProperty("JComponent.roundRect", true);
        jpasswordfield.putClientProperty("JComponent.roundRect", true);

        Register.setText("MASUK");
        Register.setFont(new java.awt.Font("Segoe UI Semibold", 0, 20));
        Register.setBackground(new java.awt.Color(22, 163, 74)); 
        Register.setForeground(java.awt.Color.WHITE);
        Register.setFocusPainted(false);
        Register.setBorderPainted(false);
        Register.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));


        // Load gambar logo
        String path1 = "/images/Lambang_Kota_Tanjungpinang.png";
        tampilkanGambar(lblGambar, path1, 105, 123);

        // Load gambar background
        String path2 = "/images/kantorwalikota.jpeg";
        tampilkanGambar(lblGambarKedua, path2, 1000, 801);
        
        lblGambarKedua.setOpaque(true);
        lblGambarKedua.setBackground(new java.awt.Color(0, 0, 0, 70));

        jpasswordfield.addActionListener(e -> Register.doClick());


        setLocationRelativeTo(null); // Tengah layar
        
        jusernamefield.requestFocusInWindow(); // Auto ke username

    }

    private void tampilkanGambar(JLabel label, String pathGambar, int lebar, int tinggi) {
        try {
            java.net.URL imageUrl = getClass().getResource(pathGambar);
            if (imageUrl != null) {
                ImageIcon icon = new ImageIcon(imageUrl);
                Image img = icon.getImage().getScaledInstance(
                        lebar, tinggi, Image.SCALE_SMOOTH);
                label.setIcon(new ImageIcon(img));
                label.setText("");
            }
        } catch (Exception e) {
            System.err.println("Gagal load gambar: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        WELCOME = new javax.swing.JLabel();
        PASSWORD = new javax.swing.JLabel();
        jusernamefield = new javax.swing.JTextField();
        Register = new javax.swing.JButton();
        lblGambar = new javax.swing.JLabel();
        lblGambarKedua = new javax.swing.JLabel();
        USERNAME = new javax.swing.JLabel();
        jpasswordfield = new javax.swing.JPasswordField();
        lblLogin = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 36)); // NOI18N
        jLabel1.setText("PEMERINTAHAN KOTA");

        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 1, 48)); // NOI18N
        jLabel2.setText("TANJUNGPINANG");

        WELCOME.setFont(new java.awt.Font("Segoe UI Semibold", 1, 28)); // NOI18N
        WELCOME.setText("REGISTER AKUN");

        PASSWORD.setFont(new java.awt.Font("Microsoft YaHei", 1, 16)); // NOI18N
        PASSWORD.setText("PASSWORD");

        jusernamefield.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jusernamefield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jusernamefieldActionPerformed(evt);
            }
        });

        Register.setBackground(new java.awt.Color(51, 255, 51));
        Register.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        Register.setForeground(new java.awt.Color(51, 51, 51));
        Register.setText("MASUK");
        Register.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegisterActionPerformed(evt);
            }
        });

        lblGambar.setPreferredSize(new java.awt.Dimension(100, 150));

        USERNAME.setFont(new java.awt.Font("Microsoft YaHei", 1, 16)); // NOI18N
        USERNAME.setText("USERNAME");

        jpasswordfield.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N

        lblLogin.setText("<html>Sudah punya akun? <u>Login disini</u></html>");
        lblLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblLoginMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(197, 197, 197)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(PASSWORD)
                                    .addComponent(jusernamefield, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
                                    .addComponent(USERNAME)
                                    .addComponent(jpasswordfield, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(lblGambar, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(242, 242, 242)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Register, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(31, 31, 31))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(WELCOME)
                        .addGap(163, 163, 163)))
                .addComponent(lblGambarKedua, javax.swing.GroupLayout.DEFAULT_SIZE, 447, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2))
                    .addComponent(lblGambar, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
                .addComponent(WELCOME)
                .addGap(29, 29, 29)
                .addComponent(USERNAME)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jusernamefield, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addComponent(PASSWORD)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpasswordfield, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Register, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(233, 233, 233))
            .addComponent(lblGambarKedua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jusernamefieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jusernamefieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jusernamefieldActionPerformed

    private void RegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegisterActionPerformed
    String user = jusernamefield.getText().trim();
    String pass = new String(jpasswordfield.getPassword()).trim();
    java.sql.Connection conn = new koneksi().connect();
    
    if (user.isEmpty() || pass.isEmpty()) {
        JOptionPane.showMessageDialog(this,
            "Username dan Password wajib diisi",
            "Peringatan",
            JOptionPane.WARNING_MESSAGE);
        return;
    }

    // Hash password sebelum disimpan
    String hashedPass = hashPassword(pass);

    PreparedStatement pst = null;

    try {
        String sql = "INSERT INTO users (username, password, role) VALUES (?, ?, 'user')";
        pst = conn.prepareStatement(sql);
        pst.setString(1, user);
        pst.setString(2, hashedPass);
        
        int rows = pst.executeUpdate();
        if (rows > 0) {
            JOptionPane.showMessageDialog(this,
                "Registrasi berhasil!\nSilakan login.",
                "Informasi",
                JOptionPane.INFORMATION_MESSAGE);

            new loginForm().setVisible(true);
            dispose();
        }

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this,
            "Terjadi kesalahan: " + e.getMessage(),
            "Error",
            JOptionPane.ERROR_MESSAGE);
    } finally {
        try {
            if (pst != null) pst.close();
            if (conn != null) conn.close();
        } catch (Exception ex) {
            // abaikan
        }
    }

    }//GEN-LAST:event_RegisterActionPerformed

    private void lblLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLoginMouseClicked
        new loginForm().setVisible(true);
            dispose(); // tutup registerForm
    }//GEN-LAST:event_lblLoginMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
    FlatLightLaf.setup();

    java.awt.EventQueue.invokeLater(() -> {
        new registerForm().setVisible(true);
    });
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel PASSWORD;
    private javax.swing.JButton Register;
    private javax.swing.JLabel USERNAME;
    private javax.swing.JLabel WELCOME;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPasswordField jpasswordfield;
    private javax.swing.JTextField jusernamefield;
    private javax.swing.JLabel lblGambar;
    private javax.swing.JLabel lblGambarKedua;
    private javax.swing.JLabel lblLogin;
    // End of variables declaration//GEN-END:variables
}
