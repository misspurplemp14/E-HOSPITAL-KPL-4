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
        LoginControl test = new LoginControl(null);
        
        boolean expect = true;
        boolean real = test.isFindDataTrue("rana@gmail.com","ranaa");
        
        assertEquals(expect, real);
    }
    @Test
    public void testIsLoginEmpty(){
       LoginControl test = new LoginControl(null);
       LoginGUI loginForm = new LoginGUI();
       
       boolean expect = false;
       boolean real = test.isLoginEmpty(loginForm);
       
       assertEquals(expect, real);
   }
}