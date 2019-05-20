/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atividades3.exerc1;
import java.lang.ThreadGroup;

/**
 *
 * @author Elaine
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        ThreadGroup threads = new ThreadGroup("Grupo1");
        Thread t1 = new Thread(threads, "Thread1");
        Thread t2 = new Thread(threads, "Thread2");
        Thread t3 = new Thread(threads, "Thread3");
        
        t1.start();
        t2.start();
        
        while(true) {
           System.out.println("Estado da thread 1: " + t1.getState());
           System.out.println("Estado da thread 2: " + t2.getState());
           System.out.println("Estado da thread 3: " + t3.getState());
           
           t1.join(9000);
        }
       
    }
    
}
