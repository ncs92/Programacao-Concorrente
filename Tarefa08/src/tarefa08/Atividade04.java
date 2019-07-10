/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 /*
Faca um programa que periodicamente monitore mudanças em um conjunto
de arquivos especificados. Se ocorreram mudanças, o programa deve registrá-las em um arquivo de log
 */
package tarefa08;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Elaine
 */
public class Atividade04 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        File files = new File("C:\\Users\\Nani\\GitHub\\ProgramacaoConcorrente\\Tarefa08\\src\\files");
        int qtdArquivos = files.list().length;

        ExecutorService threads = Executors.newFixedThreadPool(qtdArquivos);

        System.out.println("Checking files in:" + files.getCanonicalPath());
        for (String file : files.list()) {
            threads.execute(new VerifyFile("./files/" + file));
        }

        threads.shutdown();
        try {
            threads.awaitTermination(365, TimeUnit.DAYS);
        } catch (Exception ex) {
            System.out.println("Error: " + ex);
        }
    }
}
