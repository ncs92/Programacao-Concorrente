/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarefa07;

/**
 *
 * @author Elaine
 */
public class Consumer extends Thread {

    SharedFifoQueue fifo;

    Consumer(SharedFifoQueue fifo) {
        this.fifo = fifo;
    }

    @Override
    public void run() {
        while (true) {
            fifo.consumer();
        }
    }
}
