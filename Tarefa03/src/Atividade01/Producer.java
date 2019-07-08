/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Atividade01;

import java.util.Random;

/**
 *
 * @author Elaine
 */
public class Producer extends Thread {
    ResourceMonitor rm;

    public Producer(ResourceMonitor rm) {
        this.rm = rm;
    }
    
    @Override
    public void run() {
        while(true){
            Random rand = new Random();
            int value = rand.nextInt();
            System.out.println("Producer add value: " + value);
            rm.put(value);
        }
    }
}
