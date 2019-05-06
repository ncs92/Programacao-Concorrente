/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atividades2.exerc1;

import atividades1.exerc2.*;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Elaine
 */
public class OneThread extends Thread {
    @Override
    public void run(){
        Random r = new Random();
        try {
            Thread.sleep(r.nextInt(1000));
        } catch (InterruptedException ex) {
            Logger.getLogger(OneThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String args[]) {
        for (int i = 0; i < 3; i++) {
            new OneThread().start();
        }
    }
    
}
