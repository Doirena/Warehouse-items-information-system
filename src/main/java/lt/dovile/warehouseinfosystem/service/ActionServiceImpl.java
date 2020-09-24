/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lt.dovile.warehouseinfosystem.service;

import lt.dovile.warehouseinfosystem.data.Item;
import lt.dovile.warehouseinfosystem.readfile.DataReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Dovile Barkauskaite <barkauskaite.dovile@gmail.com>
 */
public class ActionServiceImpl implements ActionService {

    private static final List<Item> FULL_ITEMS_LIST = new DataReader().readStockFile();

    public List<Item> requestItemsList = new ArrayList<>();

    /**
     *
     * @param requestQuantity
     * @return new Items list when items quantities are less than request
     * quantity. If request is error or there isn't any items with this request
     * return empty list.
     */
    public List<Item> getLessItemsByQuantity(String requestQuantity) {
        int quantity;
        try {
            quantity = Integer.parseInt(requestQuantity);
        } catch (Exception ex) {
            return requestItemsList;
        }
        for (Item item : FULL_ITEMS_LIST) {
            if (item.getQuantity() < quantity) {
                requestItemsList.add(item);
            }
        }
        return requestItemsList;
    }

    /**
     *
     * @param requestDate
     * @return return New Items list which expiration Date are older than
     * request date. If request is error or there isn't any items with this
     * request return empty list.
     */
    public List<Item> getLessItemsByDate(String requestDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date;
        try {
            date = sdf.parse(requestDate);
        } catch (ParseException ex) {
            return requestItemsList;
        }
        for (Item item : FULL_ITEMS_LIST) {
            if (item.getExpirationDate().compareTo(date) < 0) {
                requestItemsList.add(item);
            }
        }
        return requestItemsList;
    }
}
