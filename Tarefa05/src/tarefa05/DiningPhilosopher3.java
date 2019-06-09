package Tarefa05;

/*
Temporizacao para pegar qualquer garfo: no maximo numero
de filosofos - 1 devem esperar um tempo.
*/

import java.util.concurrent.Semaphore;


/**
 *
 * @author Elaine
 */
class DiningPhilosopher3 implements Resource {

    int n = 0;
    Semaphore[] fork = null;

    public DiningPhilosopher3(int initN) {
        n = initN;
        fork = new Semaphore[n];
        for (int i = 0; i < n; i++) {
            fork[i] = new Semaphore(1);
        }
    }

    @Override
    public void pickup(int i) throws InterruptedException {
        try {

            while(!fork[i].tryAcquire()) {
                Thread.sleep(5000);
            }

            while(!fork[(i + 1) % n].tryAcquire()) {
                Thread.sleep(5000);
            }

        } catch (InterruptedException ex) {
            fork[i].release();
            fork[(i+1)%n].release();
            throw new InterruptedException();
        }
    }

    @Override
    public void drop(int i) throws InterruptedException {
        fork[i].release();
        fork[(i + 1) % n].release();
    }

    public static void main(String[] args) {
        DiningPhilosopher3 philosopher = new DiningPhilosopher3(5);
        for (int i = 0; i < 5; i++) {
            new Thread(new Philosopher(i, philosopher, 3)).start();
        }
    }
}
