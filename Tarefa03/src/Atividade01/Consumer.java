/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Atividade01;

/**
 *
 * @author Elaine
 */
public class Consumer extends Thread{
    ResourceMonitor rm;

    public Consumer(ResourceMonitor rm) {
        this.rm = rm;
    }
    
    @Override
    public void run() {
        while(true){
            System.out.println("Consumer removing first...");
            int pos = rm.remove();
        }
    }
    
}
