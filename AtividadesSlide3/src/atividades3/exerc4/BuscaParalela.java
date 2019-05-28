/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atividades3.exerc4;

import java.util.ArrayList;

/**
 *
 * @author Elaine
 */
public class BuscaParalela extends Thread{
    int inteiros[];
    int valorProcurado;
    
    public BuscaParalela(int inteiros[], int valor) {
        this.inteiros = inteiros;
        this.valorProcurado = valor;
    }
    
    public void run() {
        for (int item: inteiros) {
            if (item == valorProcurado) {
                System.out.println("Encontrou valor: " + item);
            }
        }
    }
   
}
