/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarefa10;

import java.io.FileReader;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Elaine
 */
public class Tarefa10 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(new FileReader("C:\\Users\\Nani\\GitHub\\ProgramacaoConcorrente\\Tarefa10\\src\\tarefa10\\texto01.txt"));

            int qtdThread = 100;
            ExecutorService threads = Executors.newFixedThreadPool(qtdThread);

            ConcurrentMap<String, Integer> mapa = new ConcurrentHashMap<>();
            Reader scanner = new Reader(in);

            for (int i = 0; i < qtdThread; i++) {
                threads.execute(new ProcessLine(scanner, mapa));
            }

            threads.shutdown();
            threads.awaitTermination(1000, TimeUnit.DAYS);

            String palavra = "Maecenas";
            System.out.println("A palavra: " + palavra + " apareceu " + mapa.getOrDefault(palavra, 0) + " vezes no texto.");

        } catch (Exception ex) {
            System.out.println("Erro: " + ex);
        }
    }

}
