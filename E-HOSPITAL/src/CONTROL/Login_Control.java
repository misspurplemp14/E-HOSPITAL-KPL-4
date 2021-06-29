/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROL;
import Database.KoneksiDatabaseUser;
import MODEL.User_Model;
import VIEW.Login_GUI;
import VIEW.MenuUtama_GUI;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class Login_Control {
    Login_GUI login;
    MenuUtama_GUI home;
    public List <User_Model> user;
    
    public Login_Control(Login_GUI loginForm){
        user = KoneksiDatabaseUser.GetData();
        this.login = loginForm;
    }
    
    public void findDataUser (String email, String password, Login_GUI login){
        if (login.getTxtEmail().intern() == " " && login.getTxtPassword().intern() == " ") {
           JOptionPane.showMessageDialog(null, "Email dan Password tidak terisi", "Warning",JOptionPane.WARNING_MESSAGE);
        } else if (login.getTxtEmail().intern() == " ") {
           JOptionPane.showMessageDialog(null, "Email tidak terisi", "Warning",JOptionPane.WARNING_MESSAGE);
        } else if (login.getTxtPassword().intern() == " ") {
           JOptionPane.showMessageDialog(null, "Password tidak terisi", "Warning",JOptionPane.WARNING_MESSAGE);
        } else {
           boolean ketemu = false;
            int index = 0;
            while (ketemu == false & index < user.size()){
                if (email.intern() == user.get(index).getEmail().intern() && password.intern() == user.get(index).getPassword().intern()){
                    ketemu = true;
                }
                index = index + 1;
            }
            if (ketemu == true ) {
                JOptionPane.showMessageDialog(null, "sukses Login",
                        "Suskses",JOptionPane.INFORMATION_MESSAGE);
                login.dispose();
                MenuUtama_GUI menuHome = new MenuUtama_GUI();
                menuHome.show();
            } else {
                JOptionPane.showMessageDialog(null, "Data tidak ditemukan",
                "Warning",JOptionPane.WARNING_MESSAGE);
                /*for(int i=0; i<user.size(); i++) {
                    System.out.println(user.get(i).getEmail());
                }*/
            }
       }
        
       /*/ if (login.getTxtEmail().isEmpty()){
            JOptionPane.showMessageDialog(null, "Email tidak terisi", "Warning",JOptionPane.WARNING_MESSAGE);
        
        }else if (login.getTxtPassword().isEmpty()){
            JOptionPane.showMessageDialog(null, "Password tidak terisi", "Warning",JOptionPane.WARNING_MESSAGE);
        
        }else if (login.getTxtEmail().isEmpty() && login.getTxtPassword().isEmpty()){
            JOptionPane.showMessageDialog(null, "Email dan Password tidak terisi", "Warning",JOptionPane.WARNING_MESSAGE);
        
        }else{
            int index = 0;
            boolean kebenaran = false;
            while(user.size()>index && user.get(index).getEmail().intern()!= email.intern() && user.get(index).getPassword().intern()!= password.intern()){
                if( user.get(index).getEmail().intern()== email.intern() && user.get(index).getPassword().intern() == password.intern()){
                    kebenaran = true;
                }
                index++;
            }
            
            if (kebenaran== true ) {
                JOptionPane.showMessageDialog(null, "sukses Login ","Suskses",JOptionPane.INFORMATION_MESSAGE);
                login.dispose();
                MenuUtama_GUI home = new MenuUtama_GUI();
                home.show();
                
            } else {
                JOptionPane.showMessageDialog(null, "Data tidak ditemukan","Warning",JOptionPane.WARNING_MESSAGE);
                
            }/*/
        }
    }