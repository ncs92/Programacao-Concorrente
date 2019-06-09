/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atividades1.exerc2;

import java.util.Scanner;

/**
 *
 * @author Elaine
 */
public class HelloRunnable implements Runnable{

    @Override
    public void run() {
        System.out.println("Hello from a runnable thread!");
    }
    
    public static void main(String args[]) {
        System.out.printf("Informe um número de threads: ");
        Scanner ler = new Scanner(System.in);
        int total = ler.nextInt();
        for (int i = 0; i < total; i++) {
            new Thread(new HelloRunnable()).start();
        }
    }
    
}
