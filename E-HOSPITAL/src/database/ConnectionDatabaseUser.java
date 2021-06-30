package database;

import model.UserModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ConnectionDatabaseUser {
    static final String DB_URL = "jdbc:mysql://localhost/E-HOSPITAL";
    static final String DB_USER = "root";
    static final String DB_PASS = "";
    static Connection connect;
    static Statement stetment;
    static ResultSet result;

    public static void InsertDataPasien(String idPasien, String nama, String email, String password, String jenisKelamin, String noHp){
        try{
            connect = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            stetment = connect.createStatement();

            String sql = "INSERT INTO pasien(ID_PASIEN, NAMA_PASIEN, EMAIL_PASIEN, PASSWORD_PASIEN, JENIS_KELAMIN, NO_HP) VALUES ('"+idPasien+"','"+nama+"','"+email+"','"+password+"','"+jenisKelamin+"','"+noHp+"')";
            stetment.execute(sql);
            stetment.close();
            connect.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static List<UserModel> GetData(){
        try{
            ArrayList<UserModel> userList = new ArrayList<UserModel>();
            connect = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            stetment = connect.createStatement();

            String sql = "SELECT * FROM pasien";
            result = stetment.executeQuery(sql);


            while(result.next()){
                userList.add(new UserModel(result.getString("ID_PASIEN"), result.getString("NAMA_PASIEN"), result.getString("EMAIL_PASIEN")
                                ,result.getString("PASSWORD_PASIEN"),result.getString("JENIS_KELAMIN"),result.getString("NO_HP")));
            }

            stetment.close();
            connect.close();

            return userList;

        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
}