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
     * call {@link lt.dovile.warehouseinfosystem.service.ActionServiceImpl} class with
     * getLessItemsByQuantity method which return list with items when quantities are
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
     * call {@link lt.dovile.warehouseinfosystem.service.ActionServiceImpl} class with
     * getLessItemsByDate method which return list when items date are
     * older than request date, this method print result to console
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
