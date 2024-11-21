package kelompok4.fishmarket.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class baseDAO {
    private static final String URL = "jdbc:mysql://localhost:3307/fishmarket"; // Ubah "fishmarket" sesuai nama database Anda
    private static final String USER = "root"; // Ubah sesuai dengan username MySQL Anda
    private static final String PASSWORD = "adminxt"; // Ubah sesuai dengan password MySQL Anda

    // Method untuk mendapatkan koneksi
    public static Connection getConnection() {
        Connection connection = null;
        try {
            // Inisialisasi koneksi
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Database connected!");
        } catch (SQLException e) {
            System.out.println("Connection failed: " + e.getMessage());
        }
        return connection;
    }
}
