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
        
        boolean expect = true;
        boolean reality = uji.isFindDataTrue("rana@gmail.com","ranaa");
        
        assertEquals(expect, reality);
    }
    
    @Test
    public void testIsLoginEmpty(){
       LoginControl uji = new LoginControl(null);
       LoginGUI loginForm = new LoginGUI();
       
       boolean expect = false;
       boolean reality = uji.isLoginEmpty(loginForm);
       
       assertEquals(expect, reality);
   }
}