/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 /*
Faça um programa que possibilite agendar uma tarefa para ser executada em um horário específico.
 */
package tarefa08;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Elaine
 */
public class Atividade05 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int qtdHours = 5;
        ScheduledExecutorService threads = Executors.newScheduledThreadPool(qtdHours);
        try {
            for (int i = 0; i < qtdHours; i++) {
                threads.schedule(new WakeUp(), 5, TimeUnit.SECONDS);
                Thread.sleep(200 + (800 * i));
            }
        } catch (Exception ex) {
            System.out.println("Error: " + ex);
        }
        threads.shutdown();
    }
}
