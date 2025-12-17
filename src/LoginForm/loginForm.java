package LoginForm;

import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.ImageIcon;
import java.awt.Image;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.sql.PreparedStatement;
import tabelpegawai.formtabelpegawai;
import tabelpegawai.koneksi;
import tabelpegawaivisitor.formtabelpegawaivisitor;

public class loginForm extends javax.swing.JFrame {
    
    private String SQL;
    
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

    public loginForm() {
        initComponents();
        
    // Enter untuk Login
       getRootPane().setDefaultButton(Login);
        
        // Style FlatLaf
        Login.putClientProperty(
        "FlatLaf.style",
        "arc:18; font:$h3.font"
    );

    jusernamefield.putClientProperty(
        "FlatLaf.style", "arc:14"
    );

    jpasswordfield.putClientProperty(
        "FlatLaf.style", "arc:14"
    );

    // Placeholder 
    jusernamefield.putClientProperty(
    "JTextField.placeholderText", "Masukkan Username"
    );
    jpasswordfield.putClientProperty(
        "JTextField.placeholderText", "Masukkan Password"
    );
      
        efekHover(Login);

        getRootPane().putClientProperty("JComponent.arc", 20);
        
        setLocationRelativeTo(null);  // tengah layar
        
        getRootPane().setBorder(
        javax.swing.BorderFactory.createEmptyBorder(12, 12, 12, 12)
        );
        
        jusernamefield.putClientProperty("JComponent.roundRect", true);
        jpasswordfield.putClientProperty("JComponent.roundRect", true);

        Login.setText("MASUK");
        Login.setFont(new java.awt.Font("Segoe UI Semibold", 0, 20));
        Login.setBackground(new java.awt.Color(22, 163, 74)); 
        Login.setForeground(java.awt.Color.WHITE);
        Login.setFocusPainted(false);
        Login.setBorderPainted(false);
        Login.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));


        // Load gambar logo
        String path1 = "/images/Lambang_Kota_Tanjungpinang.png";
        tampilkanGambar(lblGambar, path1, 105, 123);

        // Load gambar background
        String path2 = "/images/kantorwalikota.jpeg";
        tampilkanGambar(lblGambarKedua, path2, 1000, 801);
        
        lblGambarKedua.setOpaque(true);
        lblGambarKedua.setBackground(new java.awt.Color(0, 0, 0, 70));

        jpasswordfield.addActionListener(e -> Login.doClick());


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
        Login = new javax.swing.JButton();
        lblGambar = new javax.swing.JLabel();
        lblGambarKedua = new javax.swing.JLabel();
        USERNAME = new javax.swing.JLabel();
        jpasswordfield = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 36)); // NOI18N
        jLabel1.setText("PEMERINTAHAN KOTA");

        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 1, 48)); // NOI18N
        jLabel2.setText("TANJUNGPINANG");

        WELCOME.setFont(new java.awt.Font("Segoe UI Semibold", 1, 28)); // NOI18N
        WELCOME.setText("WELCOME");

        PASSWORD.setFont(new java.awt.Font("Microsoft YaHei", 1, 16)); // NOI18N
        PASSWORD.setText("PASSWORD");

        jusernamefield.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jusernamefield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jusernamefieldActionPerformed(evt);
            }
        });

        Login.setBackground(new java.awt.Color(51, 255, 51));
        Login.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        Login.setForeground(new java.awt.Color(51, 51, 51));
        Login.setText("LOGIN");
        Login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginActionPerformed(evt);
            }
        });

        lblGambar.setPreferredSize(new java.awt.Dimension(100, 150));

        USERNAME.setFont(new java.awt.Font("Microsoft YaHei", 1, 16)); // NOI18N
        USERNAME.setText("USERNAME");

        jpasswordfield.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                        .addGap(242, 242, 242)
                        .addComponent(Login, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(282, 282, 282)
                        .addComponent(WELCOME))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(lblGambar, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))))
                .addGap(31, 31, 31)
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
                .addComponent(Login, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(262, 262, 262))
            .addComponent(lblGambarKedua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jusernamefieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jusernamefieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jusernamefieldActionPerformed

    private void LoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginActionPerformed
 // TODO add your handling code here:
        String username = jusernamefield.getText();
        String password = new String(jpasswordfield.getPassword());
        java.sql.Connection conn = new koneksi().connect();
        
        try {
            String sql = "SELECT role FROM users WHERE username=? AND password=?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, username);
            pst.setString(2, password);

            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                String role = rs.getString("role");
                if (role.equals("admin")) {
                    JOptionPane.showMessageDialog(this, "Login sebagai Admin");
                    new formtabelpegawai().setVisible(true);
                    dispose();
                } else if (role.equals("user")) {
                    JOptionPane.showMessageDialog(this, "Login sebagai User");
                    new formtabelpegawaivisitor().setVisible(true);
                    dispose();
                }
            } else {
                JOptionPane.showMessageDialog(this, "Username/Password salah!");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }

    }//GEN-LAST:event_LoginActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
    FlatLightLaf.setup();

    java.awt.EventQueue.invokeLater(() -> {
        new loginForm().setVisible(true);
    });
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Login;
    private javax.swing.JLabel PASSWORD;
    private javax.swing.JLabel USERNAME;
    private javax.swing.JLabel WELCOME;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPasswordField jpasswordfield;
    private javax.swing.JTextField jusernamefield;
    private javax.swing.JLabel lblGambar;
    private javax.swing.JLabel lblGambarKedua;
    // End of variables declaration//GEN-END:variables
}
