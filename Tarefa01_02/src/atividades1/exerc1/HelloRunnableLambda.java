/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atividades1.exerc1;

import atividades1.exerc2.*;

/**
 *
 * @author Elaine
 */
public class HelloRunnableLambda {
    public static void main(String args[]){
        new Thread(() -> {
            System.out.println("Hello from a Thread LAMBDA");
        }).start();
    }
}