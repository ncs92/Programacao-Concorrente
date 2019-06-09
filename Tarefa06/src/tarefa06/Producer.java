package tarefa06;

/**
 *
 * @author Elaine
 */
class Producer extends Thread {

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
