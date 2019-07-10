/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 /*
Faça um programa usando Lock para simular a atualizacão de um contador que é acessado
por multiplas threads. O contador pode diminuir e aumentar.

 */
package tarefa07;

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
