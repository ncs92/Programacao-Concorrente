/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

 /*
Faça uma classe ArrayListThreadSafe usando ReadWriteLock.
Teste usando threads que realizam leitura e escrita para essa
estrutura.
 */
package tarefa07;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 *
 * @author Elaine
 */
public class Lock3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
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
