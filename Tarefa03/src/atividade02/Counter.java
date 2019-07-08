/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atividade02;

/**
 *
 * @author Elaine
 */
public class Counter {
    ThreadCounter tc;
    int time = 500;
    int value = 0;
    
    public synchronized void increment() {
        this.value++;
    }    
    
    public void sleepUntil() {
        while (value < time) {
            tc.sleep(time);
            increment();
            System.out.println("Thread sleeping...");
        }
        System.out.println("Thread wake up...");
        value = 0;
    }
    
     public void main() {
        tc = new ThreadCounter(this);
        tc.start();
    }
}
