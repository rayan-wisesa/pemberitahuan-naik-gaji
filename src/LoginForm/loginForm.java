package LoginForm;

import javax.swing.ImageIcon;
import java.awt.Image; 
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import tabelpegawai.formtabelpegawai;

public class loginForm extends javax.swing.JFrame {

    String password = "setdakotanpin";
    String username = "bagianumum";
    
    public loginForm() {
        initComponents();

        String path1 = "/images/Lambang_Kota_Tanjungpinang.png";
        int lebar1 = 100; 
        int tinggi1 = 170; 
        
        tampilkanGambar(lblGambar, path1, lebar1, tinggi1); 
        
        String path2 = "/images/kantorwalikota.jpeg"; 
        int lebar2 = 1000; 
        int tinggi2 = 801;
        
        tampilkanGambar(lblGambarKedua, path2, lebar2, tinggi2);
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        WELCOME = new javax.swing.JLabel();
        PASSWORD = new javax.swing.JLabel();
        jusernamefield = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        lblGambar = new javax.swing.JLabel();
        lblGambarKedua = new javax.swing.JLabel();
        USERNAME = new javax.swing.JLabel();
        jpasswordfield = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Bookman Old Style", 1, 36)); // NOI18N
        jLabel1.setText("PEMERINTAHAN KOTA");

        jLabel2.setFont(new java.awt.Font("Franklin Gothic Medium", 3, 48)); // NOI18N
        jLabel2.setText("TANJUNGPINANG");

        WELCOME.setFont(new java.awt.Font("Bookman Old Style", 1, 28)); // NOI18N
        WELCOME.setText("WELCOME");

        PASSWORD.setFont(new java.awt.Font("Microsoft YaHei", 1, 16)); // NOI18N
        PASSWORD.setText("PASSWORD");

        jusernamefield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jusernamefieldActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(51, 255, 51));
        jButton1.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(51, 51, 51));
        jButton1.setText("LOGIN");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        lblGambar.setPreferredSize(new java.awt.Dimension(100, 150));

        USERNAME.setFont(new java.awt.Font("Microsoft YaHei", 1, 16)); // NOI18N
        USERNAME.setText("USERNAME");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(lblGambar, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(197, 197, 197)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(PASSWORD)
                            .addComponent(jusernamefield, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
                            .addComponent(USERNAME)
                            .addComponent(jpasswordfield)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(242, 242, 242)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(282, 282, 282)
                        .addComponent(WELCOME)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblGambarKedua, javax.swing.GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2))
                    .addComponent(lblGambar, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                .addComponent(WELCOME)
                .addGap(29, 29, 29)
                .addComponent(USERNAME)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jusernamefield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addComponent(PASSWORD)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpasswordfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(262, 262, 262))
            .addComponent(lblGambarKedua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jusernamefieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jusernamefieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jusernamefieldActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
 // TODO add your handling code here:
        if(jpasswordfield.getText().equals(password)&&jusernamefield.getText().equals(username)){
            JOptionPane.showMessageDialog(null,"Password Anda Benar","Pesan",JOptionPane.INFORMATION_MESSAGE);
            new formtabelpegawai().setVisible(true);
            dispose();
        }else{
            JOptionPane.showMessageDialog(null,"Password Anda Salah","Pesan",JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(loginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(loginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(loginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(loginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new loginForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel PASSWORD;
    private javax.swing.JLabel USERNAME;
    private javax.swing.JLabel WELCOME;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPasswordField jpasswordfield;
    private javax.swing.JTextField jusernamefield;
    private javax.swing.JLabel lblGambar;
    private javax.swing.JLabel lblGambarKedua;
    // End of variables declaration//GEN-END:variables
}
