/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atividades2.exerc3;

import atividades2.exerc1.OneThread;
import atividades2.exerc2.LerTextoThread;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Elaine
 */

public class InterrupcaoThread extends Thread {
    
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new OneThread();
        Thread t2 = new LerTextoThread();

        t1.start();
        t1.join();
        t2.start();
        t2.join();

        t1.interrupt();
        t2.interrupt();
    }
}
