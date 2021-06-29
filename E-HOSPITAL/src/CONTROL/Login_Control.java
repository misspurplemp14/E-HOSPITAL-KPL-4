
package CONTROL;
import Database.KoneksiDatabaseUser;
import MODEL.User_Model;
import VIEW.Login_GUI;
import VIEW.MenuUtama_GUI;
import java.util.List;
import javax.swing.JOptionPane;

public class Login_Control {
    Login_GUI login;
    MenuUtama_GUI home;
    public List <User_Model> user;
    
    public Login_Control(Login_GUI loginForm){
        user = KoneksiDatabaseUser.GetData();
        this.login = loginForm;
    }
    
    public void findDataUser (String email, String password, Login_GUI login){
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
        while (ketemu == false & index < user.size()){
            if (email.intern() == user.get(index).getEmail().intern() && password.intern() == user.get(index).getPassword().intern()){
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
            MenuUtama_GUI menuHome = new MenuUtama_GUI();
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