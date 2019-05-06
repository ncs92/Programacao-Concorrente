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
public class Monitorathread extends Thread{
    int id;
    
    Monitorathread(int id) {
        this.id = id;
    }
    
    public void run() {
        while(true) {
            if (Thread.interrupted()) {
                System.out.println("A thread : " + this.id + " foi interrompida.");
            }
        }
    }
    
}
