/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarefa09;

import java.util.Comparator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;

/**
 *
 * @author Elaine
 */
public class Tarefa09 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int qtd = 2;

        Comparator comparator = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Card c1 = (Card) o1;
                Card c2 = (Card) o2;

                return c1.number > c2.number ? -1 : c1.number == c2.number ? 0 : 1;
            }
        };

        BlockingQueue<Card> blockingQueue = new PriorityBlockingQueue(1000, comparator);

        Counter counter = new Counter();

        ExecutorService consumers = Executors.newFixedThreadPool(2);
        ExecutorService producers = Executors.newFixedThreadPool(2);

        for (int i = 0; i < qtd; i++) {
            producers.execute(new ProductorCard(blockingQueue, qtd, counter));
            consumers.execute(new Consumer(blockingQueue, qtd, counter));
        }
    }
}
