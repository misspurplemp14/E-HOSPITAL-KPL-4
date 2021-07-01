package control;

import database.ConnectionDatabaseUser;
import model.UserModel;
import view.LoginGUI;
import view.RegisterGUI;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class RegisterControl {
    List<UserModel> user;
    RegisterGUI register;
    
    public RegisterControl (RegisterGUI register){
        user = ConnectionDatabaseUser.GetData();
        this.register = register;
    }
    
    public void fillData(RegisterGUI register){
        if (isAllFieldEmpty(register)){
            JOptionPane.showMessageDialog(null, "Semua field belum terisi", "Warning",JOptionPane.WARNING_MESSAGE);
        }else if(isFieldEmpty(register)){
            JOptionPane.showMessageDialog(null, "Ada field yang belum terisi", "Warning",JOptionPane.WARNING_MESSAGE);
        }else {
           insertDataUser(register);
        }
    }
    
    public void insertDataUser(RegisterGUI input){
        ConnectionDatabaseUser.InsertDataPasien(input.getIdUser(), input.getNameTxtField(), input.getEmailTxtField(),
                input.getPassTxtField(), input.getGenderTxtField(), input.getNohpTxtField());
        LoginGUI login = new LoginGUI();
        login.show();
        input.dispose();
        JOptionPane.showMessageDialog(null, "sukses memasukan " + input.getNameTxtField(), "Sukses",JOptionPane.INFORMATION_MESSAGE);
    }
    
    public boolean isAllFieldEmpty(RegisterGUI input){
        return input.getNameTxtField().isEmpty()&& input.getEmailTxtField().isEmpty()&&input.getPassTxtField().isEmpty()&&input.getNohpTxtField().isEmpty();
    }
    
    public boolean isFieldEmpty(RegisterGUI input){
        return input.getNameTxtField().isEmpty()|| input.getEmailTxtField().isEmpty()||input.getPassTxtField().isEmpty()||input.getNohpTxtField().isEmpty();
    }
}

