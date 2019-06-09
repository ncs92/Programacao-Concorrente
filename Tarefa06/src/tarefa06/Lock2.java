/*
Crie uma classe SharedFifoQueue e use Conditions para
controlar se a fila est ́a vazia ou cheia.  Teste usando threads
produtoras e consumidoras
 */
package tarefa06;

/**
 *
 * @author Elaine
 */
public class Lock2 {

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
