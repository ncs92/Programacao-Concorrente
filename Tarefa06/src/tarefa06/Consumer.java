package tarefa06;

/**
 *
 * @author Elaine
 */
class Consumer extends Thread {

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
