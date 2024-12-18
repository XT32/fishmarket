package model;

public class User {

    private String namaLengkap;
    private String username;
    private String alamat;
    private String email;
    private String password;

    // Constructor
    public User(String namaLengkap, String username, String alamat, String email, String password) {
        this.namaLengkap = namaLengkap;
        this.username = username;
        this.alamat = alamat;
        this.email = email;
        this.password = password;
    }

    // Getter and Setter methods
    public String getNamaLengkap() {
        return namaLengkap;
    }

    public void setNamaLengkap(String namaLengkap) {
        this.namaLengkap = namaLengkap;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{"
                + "namaLengkap='" + namaLengkap + '\''
                + ", username='" + username + '\''
                + ", alamat='" + alamat + '\''
                + ", email='" + email + '\''
                + '}';
    }

    public boolean isPasswordValid() {
        return this.password != null && this.password.length() >= 6;
    }
}
