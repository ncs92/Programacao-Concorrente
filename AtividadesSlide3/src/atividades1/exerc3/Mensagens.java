/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atividades1.exerc3;

import java.util.Collection;

/**
 *
 * @author Elaine
 */

public class Mensagens implements Runnable {
    private int total;
    private Collection<String> mensagens;

    public Mensagens(int total, Collection<String> mensagens) {
        this.total = total; 
        this.mensagens = mensagens;
    }

    public void run() {
        for (int i = 0; i < total; i++) {
            mensagens.add("Mensagem " + i);
        }
    }
}