/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lt.dovile.warehouseinfosystem.consoleaction;

import java.util.Scanner;

/**
 *
 * @author Dovile Barkauskaite <barkauskaite.dovile@gmail.com>
 */
public class RequestResponseConsole {

    private static final ActionByRequest STOCK_ACTION = new ActionByRequest();
/**
 * 
 * @return action number which choose
 */
    private static String inputTxt() {
        Scanner mainActionChoose = new Scanner(System.in);
        System.out.println("------------");
        System.out.println("ACTION");
        System.out.println("------------");
        System.out.println("1. Check Items quantities in stock, by quantity");
        System.out.println("2. Check Items, which Expiration Date goes to the end ");
        System.out.println("3. Exit");
        System.out.println("------------");
        System.out.println("Choose number of action");

        String chooseNumber = mainActionChoose.next();
        return chooseNumber;
    }

    /**
     * Main method, which execute all actions
     *
     * @throws ClassNotFoundException, NumberFormatException
     */
    public static void chooseAction() throws ClassNotFoundException {
        String choose = inputTxt();
        System.out.println("Choose: " + choose);
        try {
            String nextAction;
            int chooseNumber = Integer.parseInt(choose);

            switch (chooseNumber) {
                case 1:
                    STOCK_ACTION.wantingQuqntities();
                    chooseAction();
                    break;
                case 2:
                    STOCK_ACTION.oldestExpirationDate();
                    chooseAction();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("There isn't the number please choose one more time");
                    chooseAction();
            }
        } catch (NumberFormatException e) {
            System.out.println("Bad action number, try again");
            chooseAction();
        }
    }
}
