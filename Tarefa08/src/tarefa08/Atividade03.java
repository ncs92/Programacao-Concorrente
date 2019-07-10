/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 /*
Faça um programa concorrente para multiplicar duas matrizes
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
public class Atividade03 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int lengthX = 100;
        int lengthY = 100;

        int qtdTask = lengthY;

        Random generatorRandom = new Random();
        Integer[][] matrix1 = new Integer[lengthX][lengthY];
        Integer[][] matrix2 = new Integer[lengthX][lengthY];

        for (int i = 0; i < lengthX; i++) {
            for (int j = 0; j < lengthY; j++) {
                matrix1[i][i] = generatorRandom.nextInt() % 100;
                matrix2[i][i] = generatorRandom.nextInt() % 100;
            }
        }

        ExecutorService threads = Executors.newFixedThreadPool(lengthX * lengthY);
        Future<Integer>[][] futures = new Future[lengthX][lengthY];

        for (int i = 0; i < lengthX; i++) {
            for (int j = 0; j < lengthY; j++) {
                futures[i][j] = threads.submit(new MultipliesLines(matrix1, matrix2, i, j, lengthX, lengthY));
            }
        }

        threads.shutdown();
        try {
            threads.awaitTermination(60000, TimeUnit.DAYS);
        } catch (InterruptedException ex) {
            System.out.println("Error: " + ex);
        }
    }
}
