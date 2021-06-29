/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROL;

import Database.KoneksiDatabaseDokter;
import Database.KoneksiDatabasePesan;
import MODEL.Dokter_Model;
import MODEL.JadwalDokter_Model;
import VIEW.PesanDokter_GUI;
import VIEW.MenuUtama_GUI;
import java.text.DateFormat;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class PesanDokter_Control {
    PesanDokter_GUI pesan;
    MenuUtama_GUI home;
    public List <Dokter_Model> dokter;
    public List <JadwalDokter_Model> jadwal;
    
    public PesanDokter_Control(PesanDokter_GUI pesanD){
        dokter = KoneksiDatabaseDokter.GetData();
        jadwal = KoneksiDatabasePesan.GetData();
        this.pesan = pesanD;
    }
    
    public void getDataDokter(PesanDokter_GUI dataDokter) {
        try{
           dataDokter.modelTable.getDataVector().removeAllElements();
           dataDokter.modelTable.fireTableDataChanged();
           Object[] obj = new Object[5];
           for (int i = 0 ; i < dokter.size();i++){
                   obj[0] = dokter.get(i).getIdDokter();
                   obj[1] = dokter.get(i).getNamaDokter();
                   obj[2] = dokter.get(i).getSpesialis();
                   obj[3] = dokter.get(i).getJamPraktek();
                   obj[4] = dokter.get(i).getKeterangan();
                   dataDokter.modelTable.addRow(obj); //memasukkan dta data ke tabel gui
           }
        }catch(Exception e){
            System.out.println("Data Kosong dan belum masuk");
            JOptionPane.showMessageDialog(null, "Data Kosong",
                "warning",JOptionPane.INFORMATION_MESSAGE);
        }
    }
    public void CariKeterangan(String keterangan, PesanDokter_GUI dataDokter){
        try{
            dataDokter.modelTable.getDataVector().removeAllElements();
            dataDokter.modelTable.fireTableDataChanged();
            Object[] obj = new Object[5];
            for (int i = 0 ; i < dokter.size();i++){
                if (keterangan.intern()==dokter.get(i).getKeterangan().intern()){
                       obj[0] = dokter.get(i).getIdDokter();
                       obj[1] = dokter.get(i).getNamaDokter();
                       obj[2] = dokter.get(i).getSpesialis();
                       obj[3] = dokter.get(i).getJamPraktek();
                       obj[4] = dokter.get(i).getKeterangan();
                       dataDokter.modelTable.addRow(obj);
                }
            }
        }catch(Exception e){
            System.out.println("Data Kosong dan belum masuk");
            JOptionPane.showMessageDialog(null, "Data Kosong",
                "warning",JOptionPane.INFORMATION_MESSAGE);
        }
    }
    public String inputKodeJadwal (String kodeJadwal){
        if (jadwal == null) {
            kodeJadwal = "JAD01";
        }else {
            String currentData = jadwal.get(jadwal.size()-1).getId_Jadwal();
        int hitung = 1 + Integer.parseInt(currentData.substring(4));
        kodeJadwal = "JAD0" + String.valueOf(hitung);
        }
        return kodeJadwal;
        
    }
    
    public int cariAlamat (String idDokter) {
        int index = 0;
        boolean ketemu = false;
        
        while (ketemu == false && index < dokter.size()) {
            if (idDokter.intern() == dokter.get(index).getIdDokter()) {
                ketemu = true;
            }
            index++;
        }
        
        return index;
    }
    
    public void isiData (PesanDokter_GUI pesan){
        String kodeJadwal = "";
        System.out.println("kode : " + inputKodeJadwal(kodeJadwal));
        int index = cariAlamat(pesan.getDokterCombo()) - 1;
        String id_dokter = dokter.get(index).getIdDokter();
        String jam = dokter.get(index).getJamPraktek();
        String Nama_Dokter = dokter.get(index).getNamaDokter();
        String id_pasien = pesan.getPasienTxt();
        String calender = DateFormat.getDateInstance().format(pesan.getKalender());

        
        KoneksiDatabaseDokter.insertPesanDokter(inputKodeJadwal(kodeJadwal), id_dokter, id_pasien,calender, jam, Nama_Dokter);
        
    }
}
