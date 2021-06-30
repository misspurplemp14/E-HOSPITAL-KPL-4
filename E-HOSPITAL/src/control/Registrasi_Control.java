package control;

import database.ConnectionDatabaseUser;
import model.User_Model;
import view.LoginGUI;
import view.Register_GUI;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Registrasi_Control {
    List<User_Model> user;
    Register_GUI regis;
    
    
    public Registrasi_Control (Register_GUI regis){
        user = ConnectionDatabaseUser.GetData();
        this.regis = regis;
    }
    
    public void isiData(String idPasien, String nama, String email, String password, String jenisKelamin, String noHp, Register_GUI regis){
        if (regis.getNamaTxtField().isEmpty()&& regis.getEmailTxtField().isEmpty()&&regis.getPassTxtField().isEmpty()&&regis.getNohpTxtField().isEmpty()){
            JOptionPane.showMessageDialog(null, "Ada field yang belum terisi", "Warning",JOptionPane.WARNING_MESSAGE);
            
        }else if(regis.getNamaTxtField().isEmpty()|| regis.getEmailTxtField().isEmpty()||regis.getPassTxtField().isEmpty()||regis.getNohpTxtField().isEmpty()){
            JOptionPane.showMessageDialog(null, "Ada field yang belum terisi", "Warning",JOptionPane.WARNING_MESSAGE);
        }else {
           insertDataUser(nama);
        }
    }
    
    public void insertDataUser(String nama){
        ConnectionDatabaseUser.InsertDataPasien(regis.getIdPasien1(), regis.getNamaTxtField(), regis.getEmailTxtField(),
                regis.getPassTxtField(), regis.getJeniskelaminTxtField(), regis.getNohpTxtField());
        LoginGUI login = new LoginGUI();
        login.show();
        regis.dispose();
        JOptionPane.showMessageDialog(null, "sukses memasukan " + nama, "Sukses",JOptionPane.INFORMATION_MESSAGE);
    }
}
