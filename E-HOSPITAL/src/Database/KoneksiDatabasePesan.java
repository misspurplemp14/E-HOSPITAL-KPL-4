
package Database;

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
                                ,rs.getString("Nama_Dokter"),rs.getString("waktu"),rs.getString("jam")));
            }

            stmt.close();
            conn.close();

            return pesanDokter;

        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
