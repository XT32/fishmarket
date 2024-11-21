package test;

import kelompok4.fishmarket.dao.baseDAO;
import org.junit.jupiter.api.Test;
import java.sql.Connection;
import java.sql.PreparedStatement;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RegisterTest {

    @Test
    public void testRegisterUser() {
        try (Connection connection = baseDAO.getConnection()) {
            String sql = "INSERT INTO users (username, password) VALUES (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            // Masukkan data untuk test
            preparedStatement.setString(1, "testUser");
            preparedStatement.setString(2, "testPassword");

            int rowsInserted = preparedStatement.executeUpdate();
            assertTrue(rowsInserted > 0, "User baru harus berhasil didaftarkan ke database.");
        } catch (Exception e) {
            throw new RuntimeException("Pendaftaran user gagal: " + e.getMessage());
        }
    }
}
