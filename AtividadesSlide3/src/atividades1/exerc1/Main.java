/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atividades1.exerc1;

import atividades1.exerc2.*;
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
        Scanner ler = new Scanner(System.in);
        System.out.println("Informe o número de Threads...");
        int n = ler.nextInt();
        
        HelloRunnableLambda hl = new HelloRunnableLambda();
    }
    
}
