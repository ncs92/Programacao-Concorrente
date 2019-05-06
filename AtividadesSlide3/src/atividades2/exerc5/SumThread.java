/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atividades2.exerc5;

/**
 *
 * @author Elaine
 */
public class SumThread extends Thread {
    int somaTotal;
    int[] numeros;
    int qtdNumeros;
    
    SumThread(int[] nums, int qtd, int soma){
        this.numeros = nums;
        this.qtdNumeros = qtd;
        this.somaTotal = soma;
    }
    
    public void run(){
        for (int i = 0; i < qtdNumeros; i++) {
            somaTotal += numeros[i];
        }
        System.out.println("Soma: " + somaTotal);
    }
}
