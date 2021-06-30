package control;

import database.ConnectionDatabaseUser;
import model.UserModel;
import view.LoginGUI;
import view.RegisterGUI;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class RegisterControl {
    List<UserModel> pengguna;
    RegisterGUI registrasi;
    
    public RegisterControl (RegisterGUI registrasi){
        pengguna = ConnectionDatabaseUser.GetData();
        this.registrasi = registrasi;
    }
    
    public void fillData(String idPasien, String nama, String email, String kataSandi, String jenisKelamin, String noHp, RegisterGUI registrasi){
        if (registrasi.getNamaTxtField().isEmpty()&& registrasi.getEmailTxtField().isEmpty()&&registrasi.getPassTxtField().isEmpty()&&registrasi.getNohpTxtField().isEmpty()){
            JOptionPane.showMessageDialog(null, "Ada field yang belum terisi", "Warning",JOptionPane.WARNING_MESSAGE);
        }else if(registrasi.getNamaTxtField().isEmpty()|| registrasi.getEmailTxtField().isEmpty()||registrasi.getPassTxtField().isEmpty()||registrasi.getNohpTxtField().isEmpty()){
            JOptionPane.showMessageDialog(null, "Ada field yang belum terisi", "Warning",JOptionPane.WARNING_MESSAGE);
        }else {
           insertDataUser(nama);
        }
    }
    
    public void insertDataUser(String nama){
        ConnectionDatabaseUser.InsertDataPasien(registrasi.getIdPasien1(), registrasi.getNamaTxtField(), registrasi.getEmailTxtField(),
                registrasi.getPassTxtField(), registrasi.getJeniskelaminTxtField(), registrasi.getNohpTxtField());
        LoginGUI login = new LoginGUI();
        login.show();
        registrasi.dispose();
        JOptionPane.showMessageDialog(null, "sukses memasukan " + nama, "Sukses",JOptionPane.INFORMATION_MESSAGE);
    }
}
