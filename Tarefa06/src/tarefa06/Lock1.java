/*
Faça um programa usando Lock para simular a atualizaçao de
um contador que  ́e acessado por multiplas threads. O contador pode diminuir e aumentar.
*/

package tarefa06;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author Elaine
 */

public class Lock1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        new Count(lock, 1000).start();
        new Count(lock, 1000).start();
        new Count(lock, 1000).start();
        new Count(lock, 1000).start();
        new Count(lock, 1000).start();
        new Count(lock, 1000).start();
    }
    
}
