package Tarefa05;

/* atomicamente garantir que um filosofo
pega os dois garfos simultaneamente.
*/

import java.util.concurrent.Semaphore;


/**
 *
 * @author Elaine
 */
class DiningPhilosopher2 implements Resource {

    int n = 0;
    Semaphore[] fork = null;

    public DiningPhilosopher2(int initN) {
        n = initN;
        fork = new Semaphore[n];
        for (int i = 0; i < n; i++) {
            fork[i] = new Semaphore(1);
        }
    }

    @Override
    public void pickup(int i) throws InterruptedException {
        try {

            if(!fork[i].tryAcquire()) {             
                throw new InterruptedException(); 
            }

            if(!fork[(i + 1) % n].tryAcquire()) {
                throw new InterruptedException();
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
        DiningPhilosopher2 philosopher = new DiningPhilosopher2(5);
        for (int i = 0; i < 5; i++) {
            new Thread(new Philosopher(i, philosopher, 2)).start();
        }
    }
}
