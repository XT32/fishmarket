package model;

public class Ikan {
    private int id;
    private String nama;
    private double harga;
    private String gambarIkan;
    private int stok;
    private int idNelayan;

    public Ikan(int id, String nama, double harga, String gambarIkan, int stok, int idNelayan) {
        this.id = id;
        this.nama = nama;
        this.harga = harga;
        this.gambarIkan = gambarIkan;
        this.stok = stok;
        this.idNelayan = idNelayan;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    public String getGambarIkan() {
        return gambarIkan;
    }

    public void setGambarIkan(String gambarIkan) {
        this.gambarIkan = gambarIkan;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    public int getIdNelayan() {
        return idNelayan;
    }

    public void setIdNelayan(int idNelayan) {
        this.idNelayan = idNelayan;
    }
}
