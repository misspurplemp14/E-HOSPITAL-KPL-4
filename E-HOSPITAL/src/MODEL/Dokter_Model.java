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
public class Dokter_Model {
    private String idDokter;
    private String namaDokter;
    private String spesialis;
    private String jamPraktek;
    private String keterangan;

    public Dokter_Model(String idDokter, String namaDokter, String spesialis, String jamPraktek, String keterangan) {
        this.idDokter = idDokter;
        this.namaDokter = namaDokter;
        this.spesialis = spesialis;
        this.jamPraktek = jamPraktek;
        this.keterangan = keterangan;
    }
    
    public String getIdDokter() {
        return idDokter;
    }

    public void setIdDokter(String idDokter) {
        this.idDokter = idDokter;
    }

    public String getNamaDokter() {
        return namaDokter;
    }

    public void setNamaDokter(String namaDokter) {
        this.namaDokter = namaDokter;
    }

    public String getSpesialis() {
        return spesialis;
    }

    public void setSpesialis(String spesialis) {
        this.spesialis = spesialis;
    }

    public String getJamPraktek() {
        return jamPraktek;
    }

    public void setJamPraktek(String jamPraktek) {
        this.jamPraktek = jamPraktek;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }


}
