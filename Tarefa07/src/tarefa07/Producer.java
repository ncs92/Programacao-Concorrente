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
public class Producer extends Thread {

    SharedFifoQueue fifo;

    Producer(SharedFifoQueue fifo) {
        this.fifo = fifo;
    }

    @Override
    public void run() {
        while (true) {
            fifo.production();
        }
    }
}
