/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lt.dovile.warehouseinfosystem.consoleaction;

import lt.dovile.warehouseinfosystem.data.Item;
import lt.dovile.warehouseinfosystem.service.ActionServiceImpl;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Dovile Barkauskaite <barkauskaite.dovile@gmail.com>
 */
public class ActionByRequest {

    /**
     *
     * @param consoleText Get String, after action number, next step
     * @return request
     */
    private String getStringTxt(String consoleText) {
        Scanner scant = new Scanner(System.in);
        System.out.println(consoleText);
        String text = scant.nextLine();
        return text;
    }

    /**
     * use {@link lt.dovile.warehouseinfosystem.service.ActionServiceImpl} class which has
     * getLessItemsByQuantity method and return list when items quantities are
     * less than request quantity, this method print result to console
     */
    public void wantingQuqntities() {
        List<Item> items = new ActionServiceImpl().getLessItemsByQuantity(getStringTxt("Enter quantity:"));
        if (items.isEmpty()) {
            System.out.println("No Items with this request!");
        } else {
            for (Item item : items) {
                System.out.println(item);
            }
        }
    }

    /**
     * use {@link lt.dovile.warehouseinfosystem.service.ActionServiceImpl} class which has
     * getLessItemsByDate method and return list when items date are
     * oldest than request date, this method print result to console
     */
    public void oldestExpirationDate() {
        List<Item> items = new ActionServiceImpl().getLessItemsByDate(getStringTxt("Enter date, example: '2017-01-01'"));
        if (items.isEmpty()) {
            System.out.println("No Items with this request!");
        } else {
            for (Item item : items) {
                System.out.println(item);
            }
        }
    }
}
