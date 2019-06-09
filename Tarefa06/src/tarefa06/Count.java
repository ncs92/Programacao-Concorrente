package tarefa06;

import java.util.Random;
import java.util.concurrent.locks.Lock;

/**
 *
 * @author Elaine
 */
class Count extends Thread {

    int value;
    Lock lock;
    private final int maxValue;

    public Count(Lock lock, int maxValue) {
        this.lock = lock;
        this.maxValue = maxValue;
    }

    @Override
    public void run() {
        Random randonGenerator = new Random();

        while(true) {
            try {

                if(randonGenerator.nextInt(2) == 1)
                    increment();
                else
                    decrement();

                Thread.sleep(1000);
            } catch (Exception ex) {
                System.out.println("Err: " + ex);
                return;
            }
        }
    }

    public void increment() {
        System.out.println("Incrementing");
        lock.lock();
        try{
            value ++;
        } finally {
            lock.unlock();
        }
    }

    public void decrement() {
        System.out.println("Decremeting");
        lock.lock();
        try{
            value --;
        } finally {
            lock.unlock();
        }
    }
}
