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
        List<UserModel> uji = ConnectionDatabaseUser.GetData();
        
        String perkiraan = "PAS01";
        String realita = "" ;
        
        for (int i = 0 ; i < uji.size();i++) {
            if (perkiraan.intern() == uji.get(i).getIdPasien().intern()) {
                realita = uji.get(i).getIdPasien();
            }
        }
        assertEquals(perkiraan, realita);    
    }
}