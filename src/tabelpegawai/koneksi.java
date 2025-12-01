package tabelpegawai;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class koneksi {

public Connection koneksi;

public Connection connect(){
    try{
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Berhasil Koneksi Ke JDBC Driver MySQL");
    }catch (ClassNotFoundException ex) {
        System.out.println("Tidak Berhasil Koneksi Ke JDBC Driver MySQL");
    }
    
    try {
        String url="jdbc:mysql://localhost:3306/naikgaji";
        koneksi= DriverManager.getConnection(url,"root","");
        System.out.println("Berhasil Koneksi Ke Database");
    }catch(SQLException e){
        System.out.println("Tidak Berhasil Koneksi Ke Database:");
    }
    return koneksi;
}

public static void main(String[]args){
    java.sql.Connection conn = new koneksi().connect();
    }
}