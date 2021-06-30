package control;

import database.ConnectionDatabaseUser;
import model.UserModel;
import view.LoginGUI;
import view.MainMenuGUI;
import java.util.List;
import javax.swing.JOptionPane;

public class LoginControl {
    LoginGUI login;
    MainMenuGUI menu;
    public List <UserModel> pengguna;
    
    public LoginControl(LoginGUI loginForm){
        pengguna = ConnectionDatabaseUser.GetData();
        this.login = loginForm;
    }
    
    public void findDataUser (String email, String password, LoginGUI login){
        if (isLoginEmpty()) {
           JOptionPane.showMessageDialog(null, "Email dan Password tidak terisi", "Warning",JOptionPane.WARNING_MESSAGE);
        } else if (isEmailEmpty()) {
           JOptionPane.showMessageDialog(null, "Email tidak terisi", "Warning",JOptionPane.WARNING_MESSAGE);
        } else if (isPasswordEmpty()) {
           JOptionPane.showMessageDialog(null, "Password tidak terisi", "Warning",JOptionPane.WARNING_MESSAGE);
        } else {
            boolean ketemu = isFindDataTrue(email, password);
            whenFindData(ketemu);
        }
    }
    
    // Function dan procedure cari data.
    public boolean isFindDataTrue(String email, String password) {
        boolean ketemu = false;
        int index = 0;
        while (ketemu == false & index < pengguna.size()){
            if (email.intern() == pengguna.get(index).getEmail().intern() && password.intern() == pengguna.get(index).getPassword().intern()){
                ketemu = true;
            }
            index = index + 1;
        }
        return true;
    }
    
    public void whenFindData(boolean ketemu) {
        if (ketemu == true ) {
            JOptionPane.showMessageDialog(null, "Sukses Login",
                "Sukses",JOptionPane.INFORMATION_MESSAGE);
            login.dispose();
            MainMenuGUI menuHome = new MainMenuGUI();
            menuHome.show();
        } else {
            JOptionPane.showMessageDialog(null, "Data tidak ditemukan",
            "Warning",JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public boolean isLoginEmpty() {
        if (login.getTxtEmail().intern() == " " && login.getTxtPassword().intern() == " "){
            return true;
        }else {
            return false;
        }
    }
    public boolean isLoginEmpty(LoginGUI loginForm) {
        if (loginForm.getTxtEmail().intern() == " " && loginForm.getTxtPassword().intern() == " "){
            return true;
        }else {
            return false;
        }
    }
     
    public boolean isEmailEmpty() {
        if (login.getTxtEmail().intern() == " "){
            return true;
        }else {
            return false;
        }
    }
    
    public boolean isPasswordEmpty() {
        if (login.getTxtEmail().intern() == " "){
            return true;
        }else {
            return false;
        }
    }
}