/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atividade04;

/**
 *
 * @author Elaine
 */
public class ClientThread extends Thread{
    Barbearia barb;

    public ClientThread(Barbearia barb) {
        this.barb = barb;
    }
    
    @Override
    public void run () {
        while(true) {
            this.barb.insertClient();
            System.out.println("Arrived costumer");
        }
    }
    
    public void sleep(int time) throws InterruptedException {
        System.out.println("Customer dismissed...");
        Thread.sleep(time);
    }
}
