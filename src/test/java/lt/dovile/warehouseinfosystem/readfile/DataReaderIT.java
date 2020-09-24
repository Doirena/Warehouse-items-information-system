/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lt.dovile.warehouseinfosystem.readfile;

import java.util.List;
import lt.dovile.warehouseinfosystem.data.Item;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Dovile Barkauskaite <barkauskaite.dovile@gmail.com>
 */
public class DataReaderIT {
    
    /**
     * Test of readStockFile method, of class DataReader.
     */
    @Test
    public void testReadStockFile() {
        DataReader instance = new DataReader();
        int expResult = 17;
        List<Item> result = instance.readStockFile();
        assertEquals(expResult, result.size());
    }
}
