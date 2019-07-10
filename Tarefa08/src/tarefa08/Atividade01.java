/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 /*
Faça um programa que localize o maior valor em um vetor. Divida o programa em tarefas
que localizam o maior valor em um segmento do vetor. O programa deve possibilitar
especificar o número de tarefas e o número de threads para resolver o problema.
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
public class Atividade01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int lengthVet = 10000;
        int countTask = 90;
        int factor = lengthVet / countTask;
        Random generatorRandon = new Random();
        Integer[] vet = new Integer[lengthVet];

        for (int i = 0; i < lengthVet; i++) {
            vet[i] = generatorRandon.nextInt() % 500;
            System.out.println(vet[i]);
        }

        ExecutorService threads = Executors.newFixedThreadPool(countTask);
        Future<Integer> futures[] = new Future[countTask];

        for (int i = 0; i < countTask; i++) {
            futures[i] = threads.submit(new Searcher(i * factor, (i + 1) * factor, vet));
        }

        threads.shutdown();
        try {
            threads.awaitTermination(50000, TimeUnit.DAYS);
        } catch (InterruptedException ex) {
            System.out.println("Error: " + ex);
        }

        try {
            Integer bigger = 0;
            for (Future i : futures) {
                if ((Integer) i.get() > bigger) {
                    bigger = (Integer) i.get();
                }
            }
            System.out.println("Valor Maior: " + bigger);
        } catch (Exception ex) {
            System.out.println("Error: " + ex);
        }
    }

}
