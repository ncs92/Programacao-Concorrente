/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atividades3.exerc2;

/**
 *
 * @author Elaine
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        ThreadGroup base = new ThreadGroup("Base");
        Thread[] lista = new Thread[3];
        
        ThreadGroup group1 = new ThreadGroup(base, "Grupo1");
        Thread t1 = new Thread(group1, "Thread1");
        Thread t2 = new Thread(group1, "Thread2");
        Thread t3 = new Thread(group1, "Thread3");
        
        t1.start();
        t2.start();
        t3.start();
        
        ThreadGroup group2 = new ThreadGroup(base, "Grupo2");
        Thread t4 = new Thread(group2, "Thread4");
        Thread t5 = new Thread(group2, "Thread5");
        
        t4.start();
        t5.start();
        
        System.out.println("Total de grupos ativos: " + base.activeGroupCount());
        
        System.out.println("Total de Threads ativas do grupo 1: " + group1.activeCount());
        System.out.println("Total de Threads ativas do grupo 2: " + group2.activeCount());
        
        group1.setMaxPriority(Thread.MAX_PRIORITY);
        group2.setMaxPriority(Thread.MIN_PRIORITY);
        
        System.out.println("Priodidade do grupo 1: " + group1.getMaxPriority());
        System.out.println("Priodidade do grupo 2: " + group2.getMaxPriority());
        
        group1.enumerate(lista);
        
        System.out.println("Copiado a o grupo 1 de threads para o grupo 1 de thread, o array contem: " + lista.length);
        
        System.out.println("Destruindo o grupo 1 ....");
        group1.destroy();
        
        System.out.println("Total de grupos ativos: " + base.activeGroupCount());
     
    }
    
}
