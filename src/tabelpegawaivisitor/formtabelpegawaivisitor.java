package tabelpegawaivisitor;

import tabelpegawai.*;
import javax.swing.ImageIcon;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.table.JTableHeader;
import javax.swing.table.DefaultTableCellRenderer;

public class formtabelpegawaivisitor extends javax.swing.JFrame {
    
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
    tabel_gajiform.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

    
    TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(tabel_gaji);
    tabel_gajiform.setRowSorter(sorter);

    // Mengambil data dari database dan ditampilkan ke tabel dengan SQL
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

public formtabelpegawaivisitor() {
    initComponents();

    setTitle("Data Kenaikan Gaji Pegawai");
    setSize(1245, 690);
    setLocationRelativeTo(null);
    setResizable(false);

    tampilkanGambar(
        Logo_Tanjungpinang,
        "/images/Lambang_Kota_Tanjungpinang.png",
        80,
        100
    );

    konfigurasiTabel();     // styling + behavior tabel
    konfigurasiPencarian(); // search
    nonEditableTable();     // read-only

    tampilData("");

}

private void nonEditableTable() {
    tabel_gajiform.setDefaultEditor(Object.class, null);
}

private void konfigurasiPencarian() {
    fieldcari.putClientProperty("JTextField.placeholderText", "Cari nama pegawai...");
    fieldcari.putClientProperty("FlatLaf.style", "arc:14");

    fieldcari.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
        public void insertUpdate(javax.swing.event.DocumentEvent e) { cari(); }
        public void removeUpdate(javax.swing.event.DocumentEvent e) { cari(); }
        public void changedUpdate(javax.swing.event.DocumentEvent e) { cari(); }

        private void cari() {
            tampilData(fieldcari.getText().trim());
        }
    });
}

private void konfigurasiTabel() {

    // warna
    Color hijauHeader = new Color(22, 101, 52);   // Header
    Color putihLaut = new Color(240, 249, 255);  // Background
    Color toska     = new Color(20, 184, 166);   // Selection
    Color grid      = new Color(203, 213, 225);  // Grid

    // tabel
    tabel_gajiform.setRowHeight(36);
    tabel_gajiform.setFont(new Font("Segoe UI", Font.PLAIN, 15));
    tabel_gajiform.setBackground(putihLaut);
    tabel_gajiform.setForeground(Color.BLACK);

    tabel_gajiform.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    tabel_gajiform.setCellSelectionEnabled(false);
    tabel_gajiform.setColumnSelectionAllowed(false);
    tabel_gajiform.setRowSelectionAllowed(true);
    tabel_gajiform.setFocusable(false);

    // Warna seleksi
    tabel_gajiform.setSelectionBackground(toska);
    tabel_gajiform.setSelectionForeground(Color.WHITE);

    // Grid
    tabel_gajiform.setShowVerticalLines(false);
    tabel_gajiform.setShowHorizontalLines(true);
    tabel_gajiform.setGridColor(grid);

    // header
    JTableHeader header = tabel_gajiform.getTableHeader();
    header.setFont(new Font("Segoe UI Semibold", Font.BOLD, 15));
    header.setBackground(hijauHeader);
    header.setForeground(Color.WHITE);
    header.setPreferredSize(new Dimension(header.getWidth(), 42));
    header.setReorderingAllowed(false);

    ((DefaultTableCellRenderer) header.getDefaultRenderer())
            .setHorizontalAlignment(JLabel.CENTER);

    // baris selang seling
    tabel_gajiform.setDefaultRenderer(Object.class,
        new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(
                    JTable table, Object value,
                    boolean isSelected, boolean hasFocus,
                    int row, int column) {

                Component c = super.getTableCellRendererComponent(
                        table, value, isSelected, hasFocus, row, column);

                if (!isSelected) {
                    c.setBackground(
                        row % 2 == 0 ? putihLaut : Color.WHITE
                    );
                }
                return c;
            }
        });
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
        fieldcari = new javax.swing.JTextField();
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

        fieldcari.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        fieldcari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldcariActionPerformed(evt);
            }
        });
        getContentPane().add(fieldcari, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 250, 200, -1));

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

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        tampilData("");
    }//GEN-LAST:event_formWindowOpened


    private void tabel_gajiformMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_gajiformMouseClicked

    }//GEN-LAST:event_tabel_gajiformMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
    com.formdev.flatlaf.FlatLightLaf.setup();

    java.awt.EventQueue.invokeLater(() -> {
        new formtabelpegawaivisitor().setVisible(true);
    });
}


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Logo_Tanjungpinang;
    private javax.swing.JTextField fieldcari;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabel_gajiform;
    // End of variables declaration//GEN-END:variables
}
