package test;

import controller.LoginController;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class LoginTest {

    @Test
    public void testLoginWithValidCredentials() {
        LoginController loginController = new LoginController();

        // Pastikan Anda memiliki username/password yang valid di database
        boolean result = loginController.loginUser("validUsername", "validPassword");
        assertTrue(result, "Login dengan kredensial valid harus berhasil.");
    }

    @Test
    public void testLoginWithInvalidCredentials() {
        LoginController loginController = new LoginController();

        // Gunakan username/password yang salah
        boolean result = loginController.loginUser("invalidUsername", "invalidPassword");
        assertFalse(result, "Login dengan kredensial tidak valid harus gagal.");
    }
}
