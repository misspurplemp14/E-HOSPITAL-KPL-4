/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;

/**
 *
 * @author User
 */
public class JadwalDokter_Model {
    private String id_Jadwal;
    private String id_Pasien;
    private String id_Dokter;
    private String waktu;
    private String jam;
    private String Nama_Dokter;
    private int No_Antrian;
    
    public JadwalDokter_Model(String id_Jadwal, String id_Pasien, String id_Dokter, String Nama_Dokter, String waktu, String jam, int No_Antrian) {
        this.id_Jadwal = id_Jadwal;
        this.id_Pasien = id_Pasien;
        this.id_Dokter = id_Dokter;
        this.waktu = waktu;
        this.jam = jam;
        this.Nama_Dokter = Nama_Dokter;
        this.No_Antrian = No_Antrian;
    }

    public String getId_Jadwal() {
        return id_Jadwal;
    }

    public void setId_Jadwal(String id_Jadwal) {
        this.id_Jadwal = id_Jadwal;
    }

    public String getId_Pasien() {
        return id_Pasien;
    }

    public void setId_Pasien(String id_Pasien) {
        this.id_Pasien = id_Pasien;
    }

    public String getId_Dokter() {
        return id_Dokter;
    }

    public void setId_Dokter(String id_Dokter) {
        this.id_Dokter = id_Dokter;
    }

    public String getWaktu() {
        return waktu;
    }

    public int getNo_Antrian() {
        return No_Antrian;
    }

    public void setNo_Antrian(int No_Antrian) {
        this.No_Antrian = No_Antrian;
    }
    
    public void setWaktu(String waktu) {
        this.waktu = waktu;
    }

    public String getJam() {
        return jam;
    }

    public void setJam(String jam) {
        this.jam = jam;
    }

    public String getNama_Dokter() {
        return Nama_Dokter;
    }

    public void setNama_Dokter(String Nama_Dokter) {
        this.Nama_Dokter = Nama_Dokter;
    }

}
