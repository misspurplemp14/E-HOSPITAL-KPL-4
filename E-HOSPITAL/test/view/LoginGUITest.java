package view;

import org.junit.Test;
import static org.junit.Assert.*;

public class LoginGUITest {
    
    public LoginGUITest() {
    }

    @Test
    public void testNewFormRegister() {
        LoginGUI test = new LoginGUI();
        test.newFormRegister();
    }

    @Test
    public void testGetTxtEmail() {
        LoginGUI test = new LoginGUI();
        
        boolean expect = false;
        boolean reality = test.getTxtEmail().isEmpty();
        
        assertEquals(expect, reality);
    }

    @Test
    public void testGetTxtPassword() {
         LoginGUI test = new LoginGUI();
        
        boolean expect = true;
        boolean reality = test.getTxtPassword().isEmpty();
        
        assertEquals(expect, reality);
    }
}