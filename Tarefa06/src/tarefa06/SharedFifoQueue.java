package tarefa06;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author Elaine
 */
class SharedFifoQueue {

    final int size;
    int position;
    Lock lock;
    Integer[] fifo;
    final Condition notFull;
    final Condition notEmpty;

    SharedFifoQueue(int size) {
        lock = new ReentrantLock();
        fifo = new Integer[size];
        this.size = size;
        this.position = 0;

        notFull = lock.newCondition();
        notEmpty = lock.newCondition();

        for (int i = 0; i < size; i++) {
            fifo[i] = -1;
        }
    }

    public void consumer() {
        try {
            lock.lock();
            while (fifo[0] == -1) {
                notFull.await();
            }

            System.out.println("consuming");

            position--;
            fifo[position] = -1;

            Thread.sleep(1000);
            notEmpty.signal();
        } catch (Exception ex) {
            System.out.println("Err consumir: " + ex);
        } finally {
            lock.unlock();
        }
    }

    public void production() {
        try {
            lock.lock();
            while (fifo[size - 1] != -1) {
                notEmpty.await();
            }

            System.out.println("producing");

            fifo[position] = position;
            position++;

            Thread.sleep(1000);
            notFull.signal();
        } catch (Exception ex) {
            System.out.println("Err production: " + ex);
        } finally {
            lock.unlock();
        }
    }
}
