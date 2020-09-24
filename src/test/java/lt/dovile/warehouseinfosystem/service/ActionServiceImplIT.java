/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lt.dovile.warehouseinfosystem.service;

import java.util.ArrayList;
import java.util.List;
import lt.dovile.warehouseinfosystem.data.Item;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Dovile Barkauskaite <barkauskaite.dovile@gmail.com>
 */
public class ActionServiceImplIT {

    /**
     * Test of getLessItemsByQuantity method, of class ActionServiceImpl.
     */
    @Test
    public void testGetLessItemsByQuantity() {
        String requestQuantity = "4";
        ActionServiceImpl instance = new ActionServiceImpl();
        String expResult = "Apples";
        List<Item> result = instance.getLessItemsByQuantity(requestQuantity);
        assertEquals(expResult, result.get(0).getName());
        assertEquals(4, result.size());
    }

    @Test
    public void testGetLessItemsByQuantity_bad_request_return_emptyList() {
        String requestQuantity = "kkkk";
        ActionServiceImpl instance = new ActionServiceImpl();
        List<Item> result = instance.getLessItemsByQuantity(requestQuantity);
        assertEquals(new ArrayList<>(), result);
    }

    /**
     * Test of getLessItemsByDate method, of class ActionServiceImpl.
     */
    @Test
    public void testGetLessItemsByDate() {
        String requestDate = "2018-12-31";
        ActionServiceImpl instance = new ActionServiceImpl();
        String expResult = "Banana";
        List<Item> result = instance.getLessItemsByDate(requestDate);
        assertEquals(9, result.size());
        assertEquals(expResult, result.get(2).getName());
    }

    @Test
    public void testGetLessItemsByDate_bad_request_return_emptyList() {
        String requestDate = "2018-12222222";
        ActionServiceImpl instance = new ActionServiceImpl();
        List<Item> result = instance.getLessItemsByDate(requestDate);

        assertEquals(new ArrayList<>(), result);
    }

}
