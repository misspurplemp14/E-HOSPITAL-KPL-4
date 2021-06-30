package database;

import database.ConnectionDatabaseUser;
import model.UserModel;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

public class KoneksiDatabaseUserTest {
    
    public KoneksiDatabaseUserTest() {
    }

    @Test
    public void testGetData() {
        List<UserModel> test = ConnectionDatabaseUser.GetData();
        
        String expect = "PAS01";
        String real = "" ;
        
        for (int i = 0 ; i < test.size();i++) {
            if (expect.intern() == test.get(i).getIdPasien().intern()) {
                real = test.get(i).getIdPasien();
            }
        }
        assertEquals(expect, real);    
    }
}