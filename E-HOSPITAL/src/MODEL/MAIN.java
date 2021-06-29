/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;

import Database.KoneksiDatabaseDokter;
import Database.KoneksiDatabaseUser;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class MAIN {
    public static void main(String[] args) {
        // TODO code application logic here
        
        List<Dokter_Model> myObj = new ArrayList<Dokter_Model>();
        
        myObj =  KoneksiDatabaseDokter.GetData();
        
        for(Dokter_Model Item : myObj){
            System.out.println("Id Dokter       : " + Item.getIdDokter());
            System.out.println("Nama Dokter     : " + Item.getNamaDokter());
            System.out.println("Spesialis       : " + Item.getSpesialis());
        }
        
    }
}
