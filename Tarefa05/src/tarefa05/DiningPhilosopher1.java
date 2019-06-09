package Tarefa05;

/*
Introduzir assimetria: obrigar um filosofo a pegar em diferente ordem.
*/

import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 *
 * @author Elaine
 */
class DiningPhilosopher1 implements Resource {

    int n = 0;
    Semaphore[] fork = null;
    Random ordem;

    public DiningPhilosopher1(int initN) {
        n = initN;
        fork = new Semaphore[n];
        for (int i = 0; i < n; i++) {
            fork[i] = new Semaphore(1);
        }

        ordem = new Random();
    }

    @Override
    public void pickup(int i) throws InterruptedException {

        int first;
        int second;

        if(ordem.nextInt(2) == 0) {
            first = i;
            second = (i + 1) % n;
        } else {
            first = (i + i) % n;
            second = i;
        }

        fork[first].acquire();
        fork[second].acquire();
    }

    @Override
    public void drop(int i) throws InterruptedException {
        fork[i].release();
        fork[(i + 1) % n].release();
    }

    public static void main(String[] args) {
        DiningPhilosopher1 philosopher = new DiningPhilosopher1(5);
        for (int i = 0; i < 5; i++) {
            new Thread(new Philosopher(i, philosopher, 1)).start();
        }
    }
}
