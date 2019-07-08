/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atividade04;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Elaine
 */
public class BarbeiroThread extends Thread {

    Barbearia barb;

    public BarbeiroThread(Barbearia barb) {
        this.barb = barb;
    }
    
    @Override
    public void run() {
        while (true) {
            try {
                this.barb.removeClient();
            } catch (InterruptedException ex) {
                Logger.getLogger(BarbeiroThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void sleep(int time) throws InterruptedException {
        System.out.println("Barbeiro sleeping...");
        Thread.sleep(time);
    }

    public void cutHair() throws InterruptedException {
        System.out.println("Barbeiro cut hair...");
        Thread.sleep(1000);
    }

    

}
