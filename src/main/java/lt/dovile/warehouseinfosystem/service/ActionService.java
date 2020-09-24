/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lt.dovile.warehouseinfosystem.service;


import lt.dovile.warehouseinfosystem.data.Item;
import java.util.List;

/**
 *
 * @author Dovile Barkauskaite <barkauskaite.dovile@gmail.com>
 */
public interface ActionService {
    
    /**
     * 
     * @param quantity
     * @return New Items list which quantities are less than request quantity 
     */
    List<Item> getLessItemsByQuantity(String requestQuantity);
    
    /**
     * 
     * @param date
     * @return New Items list which expiration Dates are older than request date
     */
    List<Item> getLessItemsByDate(String requestDate);
}
