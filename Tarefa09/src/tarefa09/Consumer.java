/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarefa09;

import java.util.concurrent.BlockingQueue;

/**
 *
 * @author Elaine
 */
public class Consumer implements Runnable {

    BlockingQueue queue;
    private final int qtd;
    Counter counter;

    Consumer(BlockingQueue queue, int qtd, Counter counter) {
        this.queue = queue;
        this.qtd = qtd;
        this.counter = counter;
    }

    @Override
    public void run() {
        try {
            while (counter.value(0) != qtd) {
                Thread.sleep(5000);
            }

            for (int i = 0; i < 3; i++) {
                Card c = (Card) queue.take();
                System.out.println("Getting card " + c.number + "-" + c.naipe);
                Thread.sleep(500);
            }

            Thread.sleep(1000);
            counter.value(2);
        } catch (Exception ex) {
            System.out.println("Error on consuming: " + ex);
        }
    }
}
