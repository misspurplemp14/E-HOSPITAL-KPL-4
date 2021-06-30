package model;

public class UserModel {
    private String nama;
    private String email;
    private String kataSandi;
    private String jenisKelamin;
    private String noHp;
    private String idPasien;
    
    public UserModel(String idPasien, String nama, String email, String kataSandi, String jenisKelamin, String noHp) {
        this.idPasien = idPasien;
        this.nama = nama;
        this.email = email;
        this.kataSandi = kataSandi;
        this.jenisKelamin = jenisKelamin;
        this.noHp = noHp;
    }

    public String getIdPasien() {
        return idPasien;
    }

    public void setIdPasien(String idPasien) {
        this.idPasien = idPasien;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return kataSandi;
    }

    public void setPassword(String kataSandi) {
        this.kataSandi = kataSandi;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public String getNoHp() {
        return noHp;
    }

    public void setNoHp(String noHp) {
        this.noHp = noHp;
    }
}
