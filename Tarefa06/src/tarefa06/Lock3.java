/*
Faça uma classe ArrayListThreadSafe usando ReadWriteLock.
Teste usando threads que realizam leitura e escrita para essa
estrutura.
 */

package tarefa06;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 *
 * @author Elaine
 */
public class Lock3 {

    public static void main(String []args) {

        ArrayListThreadSafe array = new ArrayListThreadSafe(new ReentrantReadWriteLock(true));

        new Reader(array).start();
        new Writer(array).start();
        new Reader(array).start();
        new Writer(array).start();
        new Reader(array).start();
        new Reader(array).start();
        new Reader(array).start();
    }
}
