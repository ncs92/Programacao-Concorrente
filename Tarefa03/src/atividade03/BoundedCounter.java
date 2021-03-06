/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atividade03;

/**
 *
 * @author Elaine
 */
public class BoundedCounter {
    int valueMin = 0;
    int valueMax = 1000;
    int value = 100;    
    Producer prod;
    Consumer cons;
    
    public BoundedCounter() {
        prod = new Producer(this);
        cons = new Consumer(this);
        
        prod.start();
        cons.start();
    }
    
    public synchronized boolean increment(){
        this.value++;
        return (value == valueMin || value == valueMax);
    } 
    
    public synchronized boolean decrement(){
        this.value--;
        return (value == valueMin || value == valueMax);
    }
    
    public static void main(String[] args) {
        new BoundedCounter();
    }
}
