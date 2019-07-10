/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

 /*
Crie uma classe SharedFifoQueue e use Conditions para controlar se a fila est ́a vazia ou cheia.
Teste usando threads produtoras e consumidoras
 */
package tarefa07;

/**
 *
 * @author Elaine
 */
public class Lock2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SharedFifoQueue fifo = new SharedFifoQueue(7);

        new Consumer(fifo).start();
        new Consumer(fifo).start();
        new Producer(fifo).start();
        new Producer(fifo).start();
        new Consumer(fifo).start();
        new Consumer(fifo).start();
        new Consumer(fifo).start();
        new Producer(fifo).start();
        new Consumer(fifo).start();
        new Consumer(fifo).start();
        new Producer(fifo).start();
        new Consumer(fifo).start();
        new Producer(fifo).start();
    }

}
