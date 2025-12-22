package tabeladmin;

import tabelpegawai.*;
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

public class formtabeladmin extends javax.swing.JFrame {
    
    private JTextField field_cari;
    private DefaultTableModel tabel_users;
    private String SQL;
    
public void tampilData(String keyword) {

    tabel_users = new DefaultTableModel();
    tabel_users.addColumn("No");
    tabel_users.addColumn("Username");
    tabel_adminform.setModel(tabel_users);

    Connection conn = new koneksi().connect();
    
    // Mengambil data dari database menggunakan SQL, dimana akan menampilkan data dari table users yang memiliki role admin
try {
    String sql = "SELECT username FROM users WHERE role = 'admin'";
    PreparedStatement pst = conn.prepareStatement(sql);
    ResultSet rs = pst.executeQuery();

    int no = 1;
    while (rs.next()) {
        tabel_users.addRow(new Object[]{
            no++,
            rs.getString("username")
        });
    }

} catch (Exception e) {
    JOptionPane.showMessageDialog(this, e.getMessage());
}

}

    public formtabeladmin() {
    initComponents();
    
    getContentPane().setComponentZOrder(jLabel1, getContentPane().getComponentCount()-1);
    jButton3.addActionListener(evt -> jButton3ActionPerformed(evt));

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
        "Cari admin..."
    );
    fieldcari.putClientProperty(
        "FlatLaf.style",
        "arc:14"
    );
    
    jLabel1.addMouseListener(new MouseAdapter() {
    @Override
    public void mousePressed(MouseEvent e) {
        int row = tabel_adminform.rowAtPoint(e.getPoint());
        if (row == -1) {
            tabel_adminform.clearSelection();
        }
    }
});

    // tombol  
    styleButton(jButton1, new Color(34,197,94));
    styleButton(jButton3, new Color(22, 101, 52));
    styleButton(jButton4, new Color(239,68,68)); 

    // tabel
    styleTable();
    nonEditableTable();          
    konfigurasiSeleksiTabel();   
    konfigurasiKolom();        
    
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
    
private void konfigurasiSeleksiTabel() {
    tabel_adminform.setDragEnabled(false);
    tabel_adminform.setCellSelectionEnabled(false);
    tabel_adminform.setRowSelectionAllowed(true);
    tabel_adminform.setColumnSelectionAllowed(false);
    tabel_adminform.setFocusable(true);
    tabel_adminform.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

}

private void konfigurasiKolom() {
    tabel_adminform.getColumnModel().getColumn(0).setPreferredWidth(60);   // No
    tabel_adminform.getColumnModel().getColumn(1).setPreferredWidth(300);  // Username
}

// Tidak bisa edit tabel di dalam tabel
private void nonEditableTable() {
    tabel_adminform.setDefaultEditor(Object.class, null);
}

// Warna Tabel
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

    // Font & tinggi baris
    tabel_adminform.setRowHeight(38);
    tabel_adminform.setFont(new Font("Segoe UI", Font.PLAIN, 15));
    tabel_adminform.setBackground(Color.WHITE);

    // warna seleksi
    tabel_adminform.setSelectionBackground(new Color(14, 165, 233));
    tabel_adminform.setSelectionForeground(Color.WHITE);

    // grid
    tabel_adminform.setShowGrid(true);
    tabel_adminform.setGridColor(new Color(220, 230, 240));

    // header
    JTableHeader header = tabel_adminform.getTableHeader();
    header.setFont(new Font("Segoe UI Semibold", Font.BOLD, 15));
    header.setBackground(new Color(22, 101, 52));
    header.setForeground(Color.WHITE);
    header.setPreferredSize(new Dimension(header.getWidth(), 42));
    header.setReorderingAllowed(false);

    // Header rata tengah
    ((DefaultTableCellRenderer) header.getDefaultRenderer())
            .setHorizontalAlignment(JLabel.CENTER);

    // isi tabel
    DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
    centerRenderer.setHorizontalAlignment(JLabel.CENTER);

    DefaultTableCellRenderer zebraRenderer = new DefaultTableCellRenderer() {
        @Override
        public Component getTableCellRendererComponent(
                JTable table, Object value, boolean isSelected,
                boolean hasFocus, int row, int column) {

            Component c = super.getTableCellRendererComponent(
                    table, value, isSelected, hasFocus, row, column);

            if (!isSelected) {
                if (row % 2 == 0) {
                    c.setBackground(new Color(240, 249, 255));
                } else {
                    c.setBackground(Color.WHITE);
                }
                c.setForeground(Color.BLACK);
            }

            setHorizontalAlignment(JLabel.CENTER);
            return c;
        }
    };

    // Terapkan renderer ke semua kolom
    for (int i = 0; i < tabel_adminform.getColumnCount(); i++) {
        tabel_adminform.getColumnModel().getColumn(i).setCellRenderer(zebraRenderer);
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
                jLabel1.setText("");
                
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
        tabel_adminform = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
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
        jLabel4.setText("Data Pegawai Admin");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 190, -1, -1));

        tabel_adminform.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tabel_adminform.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "No.", "Username"
            }
        ));
        tabel_adminform.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_adminformMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabel_adminform);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 280, 610, 250));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setText("Kembali");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 540, 120, -1));

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton3.setText("Tambah Admin");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 540, -1, -1));

        fieldcari.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        fieldcari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldcariActionPerformed(evt);
            }
        });
        getContentPane().add(fieldcari, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 240, 200, -1));

        jButton4.setBackground(new java.awt.Color(255, 0, 0));
        jButton4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton4.setText("Hapus Admin");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 540, 170, -1));

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
        new formtabelpegawai().setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        tampilData("");
    }//GEN-LAST:event_formWindowOpened

    private void tabel_adminformMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_adminformMouseClicked

    }//GEN-LAST:event_tabel_adminformMouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
    java.sql.Connection conn = new koneksi().connect();
    int row = tabel_adminform.getSelectedRow();

if (row == -1) {
    JOptionPane.showMessageDialog(
        this,
        "Pilih data yang ingin dihapus!",
        "Peringatan",
        JOptionPane.WARNING_MESSAGE
    );
    return;
}
    UIManager.put("OptionPane.messageFont", new Font("Segoe UI", Font.PLAIN, 14));
    UIManager.put("OptionPane.buttonFont", new Font("Segoe UI", Font.BOLD, 13));

    int ok = JOptionPane.showConfirmDialog(
        this,
        "Yakin ingin menghapus data admin?",
        "Konfirmasi",
        JOptionPane.YES_NO_OPTION,
        JOptionPane.WARNING_MESSAGE
    );

    if(ok==0){
        try{
            SQL="delete from users where username='"+tabel_adminform.getValueAt(row, 1).toString()+"'";
            java.sql.PreparedStatement stmt = conn.prepareStatement(SQL);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null,"Data Berhasil di Hapus");
            tampilData("");
            tabel_adminform.clearSelection();

        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Data Gagal Di Hapus");
        }
    }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
    new formtambahadmin().setVisible(true);
    dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
    com.formdev.flatlaf.FlatLightLaf.setup();

    java.awt.EventQueue.invokeLater(() -> {
        new formtabeladmin().setVisible(true);
    });
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Logo_Tanjungpinang;
    private javax.swing.JTextField fieldcari;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabel_adminform;
    // End of variables declaration//GEN-END:variables

    private void tampilData() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
