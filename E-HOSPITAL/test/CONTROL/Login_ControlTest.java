package CONTROL;

import VIEW.Login_GUI;
import org.junit.Test;
import static org.junit.Assert.*;

public class Login_ControlTest {
    
    public Login_ControlTest() {
    }

    @Test
    public void testIsFindDataTrue() {
        Login_Control test = new Login_Control(null);
        
        boolean expect = true;
        boolean real = test.isFindDataTrue("rana@gmail.com","ranaa");
        
        assertEquals(expect, real);
    }
    @Test
    public void testIsLoginEmpty(){
       Login_Control test = new Login_Control(null);
       Login_GUI loginForm = new Login_GUI();
       
       boolean expect = false;
       boolean real = test.isLoginEmpty(loginForm);
       
       assertEquals(expect, real);
   }
}