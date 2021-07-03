package control;

import org.junit.Test;
import static org.junit.Assert.*;
import view.RegisterGUI;

public class RegisterControlTest {
    
    @Test
    public void testIsAllFieldEmpty() {
        RegisterControl test = new RegisterControl(null);
        RegisterGUI form = new RegisterGUI();
        
        boolean expect = false;
        boolean reality = test.isAllFieldEmpty(form);
        
        assertEquals(expect, reality);
    }

    @Test
    public void testIsFieldEmpty() {
        RegisterControl test = new RegisterControl(null);
        RegisterGUI form = new RegisterGUI();
        
        boolean expect = false;
        boolean reality = test.isFieldEmpty(form);
        
        assertEquals(expect, reality);
    }
    
}
