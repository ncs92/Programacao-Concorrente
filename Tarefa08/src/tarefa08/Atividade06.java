/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 /*
Faça um programa que execute tres algoritmos de ordenação para um conjunto de valores
e exiba o resultado apenas do algorithm que finalizar primeiro (use invokeAny ).
 */
package tarefa08;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author Elaine
 */
public class Atividade06 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        int size = 100000;

        Integer[] vect1 = new Integer[size];
        Integer[] vect2 = new Integer[size];
        Integer[] vect3 = new Integer[size];

        Random generatorRadom = new Random();

        for (int i = 0; i < size; i++) {
            int sorted = generatorRadom.nextInt(size);
            vect1[i] = vect2[i] = vect3[i] = sorted;
        }

        Set<Callable<ResultSave>> callables = new HashSet<Callable<ResultSave>>();
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        callables.add(new SelectionSort(vect3));
        callables.add(new BubbleSort(vect1));
        callables.add(new InsertionSort(vect2));

        ResultSave result = executorService.invokeAny(callables);
        executorService.shutdownNow();

        for (Integer value : result.vect) {
            System.out.println(value);
        }

        System.out.println("Melhor algoritmo: " + result.algorithm);
    }
}
