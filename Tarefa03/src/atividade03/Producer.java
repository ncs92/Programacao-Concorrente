/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atividade03;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Elaine
 */
public class Producer extends Thread {
    BoundedCounter bc;

    public Producer(BoundedCounter bc) {
        this.bc = bc;
    }
    
    @Override
    public void run() {
        while(true){
            System.out.println("Increment...");
            if (bc.increment()) {
                try {
                    this.wait();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
