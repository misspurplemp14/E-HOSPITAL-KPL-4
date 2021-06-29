
package Database;

import static Database.KoneksiDatabaseDokter.conn;
import MODEL.Dokter_Model;
import MODEL.JadwalDokter_Model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class KoneksiDatabasePesan {
    static final String DB_URL = "jdbc:mysql://localhost/E-HOSPITAL";
    static final String DB_USER = "root";
    static final String DB_PASS = "";
    static Connection conn;
    static Statement stmt;
    static ResultSet rs;

    public static List<JadwalDokter_Model> GetData(){
        try{
            ArrayList<JadwalDokter_Model> pesanDokter = new ArrayList<JadwalDokter_Model>();
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            stmt = conn.createStatement();

            String sql = "SELECT * FROM jadwal";
            rs = stmt.executeQuery(sql);


            while(rs.next()){
                pesanDokter.add(new JadwalDokter_Model(rs.getString("id_Jadwal"), rs.getString("id_Pasien"), rs.getString("id_Dokter")
                                ,rs.getString("Nama_Dokter"),rs.getString("waktu"),rs.getString("jam"), rs.getInt("No_Antrian")));
            }

            stmt.close();
            conn.close();

            return pesanDokter;

        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
        
    }
    
    public static void insertPesanDokter(String id_Jadwal,String id_Dokter,String id_pasien, String Nama_Dokter, String waktu, String jam, int No_Antrian){
        try{
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            stmt = conn.createStatement();
            
            String sql = "INSERT INTO jadwal (id_jadwal,id_Pasien,id_dokter,Nama_Dokter,waktu, jam, No_Antrian)VALUES('"+id_Jadwal+"','"+id_pasien+"','"+id_Dokter+"','"+Nama_Dokter+"','"+waktu+"','"+jam+"', '"+No_Antrian+"')";
            stmt.execute(sql);
            stmt.close();
            conn.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
