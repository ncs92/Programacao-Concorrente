/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atividades2.exerc5;

import java.util.Scanner;

/**
 *
 * @author Elaine
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        System.out.printf("Informe uma quantidade de numeros: ");
        Scanner ler = new Scanner(System.in);
        int soma = 0;
        int total = ler.nextInt();
        int[] numeros = new int[total];
        for (int i = 0; i < total; i++) {
            System.out.println("Informe o numero: ");
            numeros[i] = ler.nextInt();
        }
        Thread t1 = new SumThread(numeros, total, soma);
        Thread t2 = new SumThread(numeros, total, soma);
        
        t1.start();
        t1.join(5000);
        
        t2.start();
        t2.join(5000);
    }
    
}
