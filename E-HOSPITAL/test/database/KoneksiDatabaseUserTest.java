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
        
        String expect = "PAS01";
        String reality = "" ;
        
        for (int i = 0 ; i < uji.size();i++) {
            if (expect.intern() == uji.get(i).getIdPasien().intern()) {
                reality = uji.get(i).getIdPasien();
            }
        }
        assertEquals(expect, reality);    
    }
    
    @Test
    public void testInsertDataPasien() {
        ConnectionDatabaseUser.InsertDataPasien("PAS11", "Sandi", "sandi@gmail.com", "sandii", "Perempuan", "081234");
        List<UserModel> uji = ConnectionDatabaseUser.GetData();
        
        String expect = "PAS11";
        String reality = "" ;
        
        for (int i = 0 ; i < uji.size();i++) {
            if (expect.intern() == uji.get(i).getIdPasien().intern()) {
                reality = uji.get(i).getIdPasien();
            }
        }
        assertEquals(expect, reality);    
    }
}