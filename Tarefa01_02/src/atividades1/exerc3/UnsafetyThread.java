/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atividades1.exerc3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

/**
 *
 * @author Elaine
 */


public class UnsafetyThread  {
    
    public static void main(String[] args) throws InterruptedException {
       Collection<String> mensagens = new ArrayList<String>();

       Thread t1 = new Thread(new Mensagens(1800, mensagens));
       Thread t2 = new Thread(new Mensagens(4500, mensagens));
       Thread t3 = new Thread(new Mensagens(3000, mensagens));

       t1.start();
       t2.start();
       t3.start();

       t1.join();
       t2.join();
       t3.join();

       // verifica se guardou tudo
       for (int i = 0; i < 15000; i++) {
           if (!mensagens.contains("Mensagem " + i)) {
               throw new IllegalStateException("Não foi encontrado a mensagem: " + i);
           }
       }

       // verifica se há alguma mensagem nula
       if (mensagens.contains(null)) {
           throw new IllegalStateException("Achou um null!");
       }

       System.out.println("Fim da execucao com sucesso");
    }
    
}
