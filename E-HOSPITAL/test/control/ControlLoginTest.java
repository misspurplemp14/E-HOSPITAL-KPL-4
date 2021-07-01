
package control;

import org.junit.Test;
import static org.junit.Assert.*;
import view.LoginGUI;
import view.MainMenuGUI;

public class ControlLoginTest {
    
    public ControlLoginTest() {
    }

    @Test
    public void testIsFindDataTrue() {
        LoginControl test = new LoginControl(null);
        
        boolean expect = true;
        boolean reality = test.isFindDataTrue("rana@gmail.com","ranaa");
        
        assertEquals(expect, reality);
    }
    
    @Test
    public void testIsLoginEmpty(){
       LoginControl test = new LoginControl(null);
       LoginGUI loginForm = new LoginGUI();
       
       boolean expect = false;
       boolean reality = test.isLoginEmpty(loginForm);
       
       assertEquals(expect, reality);
   }
    
    @Test
    public void testWhenFindData() {
        LoginControl test = new LoginControl(null);
        MainMenuGUI form = new MainMenuGUI();
        LoginGUI loginForm = new LoginGUI();
        test.whenFindData(true, form, loginForm);
    }
    
    @Test
    public void testIsEmailEmpty() {
        LoginControl test = new LoginControl(null);
        LoginGUI loginForm = new LoginGUI();
        boolean expect = true;
        boolean reality = test.isEmailEmpty(loginForm);
        assertEquals(expect, reality); 
    }
    
    @Test
    public void testIsPasswordEmpty() {
        LoginControl test = new LoginControl(null);
        LoginGUI loginForm = new LoginGUI();
        boolean expect = true;
        boolean reality = test.isPasswordEmpty(loginForm);
        assertEquals(expect, reality); 
    }
}
