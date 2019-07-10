/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarefa09;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

/**
 *
 * @author Elaine
 */
public class ProductorCard implements Runnable {

    BlockingQueue queue;
    private final Random generator;
    private final int qtd;
    Counter counter;

    ProductorCard(BlockingQueue queue, int qtd, Counter counter) {
        this.generator = new Random();
        this.queue = queue;
        this.qtd = qtd;
        this.counter = counter;
    }

    private int getNumber() {
        return generator.nextInt(13) + 1;
    }

    private String getNaipe() {
        switch (generator.nextInt(3)) {
            case 0:
                return "gold";
            case 1:
                return "cups";
            default:
                return "swords";
        }
    }

    @Override
    public void run() {
        try {
            while (counter.value(0) != 0) {
                Thread.sleep(3000);
            }

            for (int i = 0; i < 5; i++) {
                int number = getNumber();
                String naipe = getNaipe();
                Card c = new Card(number, -1, naipe);
                queue.add(c);
                System.out.println("Making card " + c.number + "-" + c.naipe);
                Thread.sleep(500);
            }

            Thread.sleep(1000);
            counter.value(1);
        } catch (Exception ex) {
            System.out.println("Error on production: " + ex);
        }
    }
}
