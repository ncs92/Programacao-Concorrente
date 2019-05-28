/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atividades3.exerc4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Elaine
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner ler = new Scanner(System.in);
        System.out.printf("Informe um número de threads: ");
        int n = ler.nextInt();
        
        int valores[] = new int [40];
        
        for(int i = 0; i < 40; i++) {
            valores[i] = i;
        }
        
        int qtdPorThread = 40 / n;
        int posInicio = 0;
        int posFinal = qtdPorThread - 1;
        
        for (int i = 0; i < n; i++) {
            System.out.println("pos inicio: "+ posInicio);
            System.out.println("pos final: "+ posFinal);
            System.out.println("-------------");
            int subarray[] = Arrays.copyOfRange(valores, posInicio, posFinal);
            Thread t = new BuscaParalela(subarray, 20);
            t.start();
            posInicio = posFinal + 1;
            posFinal = posInicio + qtdPorThread - 1;            
        }
    }
    
}
