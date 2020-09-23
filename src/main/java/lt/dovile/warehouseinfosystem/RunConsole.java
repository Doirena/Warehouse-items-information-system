/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lt.dovile.warehouseinfosystem;

import lt.dovile.warehouseinfosystem.consoleaction.RequestResponseConsole;

/**
 *
 * @author Dovile Barkauskaite <barkauskaite.dovile@gmail.com>
 */
public class RunConsole {
    public static void main(String[] args) throws ClassNotFoundException {

        RequestResponseConsole.chooseAction();
    }
}
