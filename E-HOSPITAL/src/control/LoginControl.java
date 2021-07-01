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
    public List <UserModel> user;
    
    public LoginControl(LoginGUI loginForm){
        user = ConnectionDatabaseUser.GetData();
        this.login = loginForm;
    }
    
    public void findDataUser (String email, String password, LoginGUI login, MainMenuGUI menuHome){
        if (isLoginEmpty()) {
           JOptionPane.showMessageDialog(null, "Email dan Password tidak terisi", "Warning",JOptionPane.WARNING_MESSAGE);
        } else if (isEmailEmpty(login)) {
           JOptionPane.showMessageDialog(null, "Email tidak terisi", "Warning",JOptionPane.WARNING_MESSAGE);
        } else if (isPasswordEmpty(login)) {
           JOptionPane.showMessageDialog(null, "Password tidak terisi", "Warning",JOptionPane.WARNING_MESSAGE);
        } else {
            boolean find = isFindDataTrue(email, password);
            whenFindData(find, menuHome, login);
        }
    }
    
    // Function dan procedure cari data.
    public boolean isFindDataTrue(String email, String password) {
        boolean find = false;
        int index = 0;
        while (find == false & index < user.size()){
            if (email.intern() == user.get(index).getEmail().intern() && password.intern() == user.get(index).getPassword().intern()){
                find = true;
            }
            index = index + 1;
        }
        return true;
    }
    
    public void whenFindData(boolean find, MainMenuGUI menuHome, LoginGUI loginForm) {
        if (find == true ) {
            JOptionPane.showMessageDialog(null, "Sukses Login",
                "Sukses",JOptionPane.INFORMATION_MESSAGE);
            loginForm.dispose();
            menuHome = new MainMenuGUI();
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
     
    public boolean isEmailEmpty(LoginGUI loginForm) {
        if (loginForm.getTxtEmail().intern() == " "){
            return true;
        }else {
            return false;
        }
    }
    
    public boolean isPasswordEmpty(LoginGUI loginForm) {
        if (loginForm.getTxtEmail().intern() == " "){
            return true;
        }else {
            return false;
        }
    }
}