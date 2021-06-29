/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;
import MODEL.User_Model;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author User
 */
public class KoneksiDatabaseUser {
    static final String DB_URL = "jdbc:mysql://localhost/E-HOSPITAL";
    static final String DB_USER = "root";
    static final String DB_PASS = "";
    static Connection conn;
    static Statement stmt;
    static ResultSet rs;

    public static void InsertDataPasien(String idPasien, String nama, String email, String password, String jenisKelamin, String noHp){
        try{
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            stmt = conn.createStatement();

            String sql = "INSERT INTO pasien(ID_PASIEN, NAMA_PASIEN, EMAIL_PASIEN, PASSWORD_PASIEN, JENIS_KELAMIN, NO_HP) VALUES ('"+idPasien+"','"+nama+"','"+email+"','"+password+"','"+jenisKelamin+"','"+noHp+"')";
            stmt.execute(sql);
            stmt.close();
            conn.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static List<User_Model> GetData(){
        try{
            ArrayList<User_Model> userList = new ArrayList<User_Model>();
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            stmt = conn.createStatement();

            String sql = "SELECT * FROM pasien";
            rs = stmt.executeQuery(sql);


            while(rs.next()){
                userList.add(new User_Model(rs.getString("ID_PASIEN"), rs.getString("NAMA_PASIEN"), rs.getString("EMAIL_PASIEN")
                                ,rs.getString("PASSWORD_PASIEN"),rs.getString("JENIS_KELAMIN"),rs.getString("NO_HP")));
            }

            stmt.close();
            conn.close();

            return userList;

        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
