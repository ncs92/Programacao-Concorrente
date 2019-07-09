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
public class Barbearia {
    int totalChair = 10;
    int totalClients = 0;
    BarbeiroThread bt;
    ClientThread ct;

    public Barbearia() {
        this.bt = new BarbeiroThread(this);
        this.ct = new ClientThread(this);
        this.bt.start();
        this.ct.start();
    }   
    
    public synchronized void removeClient() throws InterruptedException {
        while (totalClients <= 0) {
            this.bt.sleep(1000);
            try {                
                System.out.println("Barbearia is empty...");
                wait();
            } catch (InterruptedException e) {}
        }
        notifyAll();
        this.totalClients--;
        this.bt.cutHair();
    }
    
    public synchronized void insertClient() {
        while(totalClients <= totalChair) {
            try {
                System.out.println("Barbearia is full...");
                wait();
            } catch (InterruptedException e) {}
        }
        notifyAll();
    }
    
    public static void main(String[] args) {
        new Barbearia();
    }
}
