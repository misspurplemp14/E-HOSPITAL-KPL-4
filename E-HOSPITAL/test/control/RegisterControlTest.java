/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import org.junit.Test;
import static org.junit.Assert.*;
import view.RegisterGUI;

/**
 *
 * @author acer
 */
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
