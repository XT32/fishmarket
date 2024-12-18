package service;

import dao.UserDAO;
import model.User;

/**
 * UserService bertindak sebagai lapisan layanan untuk mengelola
 * operasi login dan registrasi pengguna.
 */
public class UserService {

    private final UserDAO userDAO = new UserDAO(); // Menggunakan DAO untuk operasi database

    /**
     * Login pengguna berdasarkan username dan password.
     * 
     * @param username Username pengguna
     * @param password Password pengguna
     * @return Objek User jika login berhasil, null jika gagal
     */
    public User loginUser(String username, String password) {
        // Validasi input (opsional)
        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            System.err.println("Username dan password tidak boleh kosong.");
            return null;
        }

        // Memanggil DAO untuk melakukan login
        return userDAO.loginUser(username, password);
    }

    /**
     * Registrasi pengguna baru.
     * 
     * @param user Objek User yang berisi data pengguna
     * @return true jika registrasi berhasil, false jika gagal
     */
    public boolean registerUser(User user) {
        // Validasi input (opsional)
        if (user == null ||
            user.getNamaLengkap() == null || user.getNamaLengkap().isEmpty() ||
            user.getUsername() == null || user.getUsername().isEmpty() ||
            user.getAlamat() == null || user.getAlamat().isEmpty() ||
            user.getEmail() == null || user.getEmail().isEmpty() ||
            user.getPassword() == null || user.getPassword().isEmpty()) {
            System.err.println("Semua data harus diisi.");
            return false;
        }

        // Memanggil DAO untuk menyimpan data pengguna ke database
        return userDAO.registerUser(user);
    }
}
