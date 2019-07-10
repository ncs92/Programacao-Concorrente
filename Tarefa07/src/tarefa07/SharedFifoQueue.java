/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarefa07;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author Elaine
 */
public class SharedFifoQueue {

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
            System.out.println("Consuming...");
            position--;
            fifo[position] = -1;
            Thread.sleep(1000);
            notEmpty.signal();
        } catch (Exception ex) {
            System.out.println("Error consuming: " + ex);
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
            System.out.println("Producing...");
            fifo[position] = position;
            position++;
            Thread.sleep(1000);
            notFull.signal();
        } catch (Exception ex) {
            System.out.println("Error production: " + ex);
        } finally {
            lock.unlock();
        }
    }
}
