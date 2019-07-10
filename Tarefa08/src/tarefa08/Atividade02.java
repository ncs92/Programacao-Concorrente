/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

 /*
 Faça um programa que calcule a soma dos elementos de uma matriz
MxN. Divida o programa em tarefas que somam as linhas. O programa
deve possibilitar especificar o nímero de threads para resolver o problema.
 */
package tarefa08;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Elaine
 */
public class Atividade02 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int lengthX = 100;
        int lengthY = 100;

        int qtdTask = lengthY;

        Random generatorRandom = new Random();
        Integer[][] matrix = new Integer[lengthX][lengthY];

        for (int i = 0; i < lengthX; i++) {
            for (int j = 0; j < lengthY; j++) {
                matrix[i][j] = generatorRandom.nextInt() % 100;
            }
        }

        ExecutorService threads = Executors.newFixedThreadPool(qtdTask);
        Future<Integer>[] futures = new Future[qtdTask];

        for (int i = 0; i < lengthY; i++) {
            futures[i] = threads.submit(new SumLine(matrix, i, lengthY));
        }

        threads.shutdown();
        try {
            threads.awaitTermination(50000, TimeUnit.DAYS);
        } catch (InterruptedException ex) {
            System.out.println("Error: " + ex);
        }

        try {
            Integer sum = 0;
            for (Future f : futures) {
                sum += (Integer) f.get();
            }

            System.out.println("Soma de todos valores: " + sum);
        } catch (Exception ex) {
            System.out.println("Error: " + ex);
        }
    }
}
