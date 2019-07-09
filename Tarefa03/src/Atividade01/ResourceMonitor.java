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
public class ResourceMonitor {
    private CircularBuffer buffer;

    public ResourceMonitor() {
        Producer prod = new Producer(this);
        Consumer con = new Consumer(this);
        buffer = new CircularBuffer(10);
        
        prod.start();
        con.start();
    }
    
    public synchronized int remove() {
        int pos = -1;
        while (buffer.isEmpty()) {
            try {
                wait();
                System.out.println("Empty buffer");
            } catch (InterruptedException e) {}
        }
        pos = buffer.remove();
        notifyAll();
        return pos;
    }
    
    public synchronized void put(int code) {
        while(buffer.isBufferFull()) {
            try {
                wait();
                System.out.println("Sem espaço no buffer");
            } catch (InterruptedException e) {}
        }
        this.buffer.insert(code);
        notifyAll();
    }
    
     public static void main(String[] args) {
         new ResourceMonitor();
    }
}
