/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atividades2.exerc4;

/**
 *
 * @author Elaine
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Thread t1 = new Monitorathread(1);
        Thread t2 = new Monitorathread(2);

        t1.start();
        t2.start();

        t1.interrupt();
    }
    
}
