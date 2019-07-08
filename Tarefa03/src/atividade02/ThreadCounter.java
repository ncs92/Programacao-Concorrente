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
public class ThreadCounter extends Thread{
    Counter count;

    public ThreadCounter(Counter count) {
        this.count = count;
    }
    
    @Override
    public void run() {
        while(true) {
            count.sleepUntil();
        }
    }
    
    public void sleep(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {}
    }
}
