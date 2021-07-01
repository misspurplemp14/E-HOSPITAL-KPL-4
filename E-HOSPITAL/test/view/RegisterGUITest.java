package view;

import view.RegisterGUI;
import org.junit.Test;
import static org.junit.Assert.*;

public class RegisterGUITest {
    
    public RegisterGUITest() {
    }

    @Test
    public void testNewFormMenu() {
        RegisterGUI test = new RegisterGUI();
        test.newFormMenu();
    }

    @Test
    public void testGetIdUser() {
    }

    @Test
    public void testGetEmailTxtField() {
        RegisterGUI test = new RegisterGUI();
        
        boolean expect = false;
        boolean reality = test.getEmailTxtField().isEmpty();
        
        assertEquals(expect, reality);
    }

    @Test
    public void testGetGenderTxtField() {
        RegisterGUI test = new RegisterGUI();
        
        boolean expect = false;
        boolean reality = test.getGenderTxtField().isEmpty();
        
        assertEquals(expect, reality);
    }

    @Test
    public void testGetNameTxtField() {
        RegisterGUI test = new RegisterGUI();
        
        boolean expect = false;
        boolean reality = test.getNameTxtField().isEmpty();
        
        assertEquals(expect, reality);
    }

    @Test
    public void testGetNohpTxtField() {
        RegisterGUI test = new RegisterGUI();
        
        boolean expect = false;
        boolean reality = test.getNohpTxtField().isEmpty();
        
        assertEquals(expect, reality);
    }

    @Test
    public void testGetPassTxtField() {
        RegisterGUI test = new RegisterGUI();
        
        boolean expect = false;
        boolean reality = test.getPassTxtField().isEmpty();
        
        assertEquals(expect, reality);
    }

    @Test
    public void testMain() {
    }
    
}
