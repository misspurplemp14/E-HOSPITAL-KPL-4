package control;

import control.LoginControl;
import view.LoginGUI;
import org.junit.Test;
import static org.junit.Assert.*;

public class Login_ControlTest {
    
    public Login_ControlTest() {
    }

    @Test
    public void testIsFindDataTrue() {
        LoginControl uji = new LoginControl(null);
        
        boolean perkiraan = true;
        boolean realita = uji.isFindDataTrue("rana@gmail.com","ranaa");
        
        assertEquals(perkiraan, realita);
    }
    
    @Test
    public void testIsLoginEmpty(){
       LoginControl uji = new LoginControl(null);
       LoginGUI loginForm = new LoginGUI();
       
       boolean perkiraan = false;
       boolean realita = uji.isLoginEmpty(loginForm);
       
       assertEquals(perkiraan, realita);
   }
}