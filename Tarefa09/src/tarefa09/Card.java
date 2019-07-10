/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarefa09;

/**
 *
 * @author Elaine
 */
public class Card {

    final int number;
    final int simbol;
    final String naipe;

    /**
     * @param number refere ao número da carta. Este value vai de 1 - Ás - até
     * 13 - rei.
     * @param simbol é uma value inteiro que eu não faço ideia do que significa
     * @param naipe string referindo ao naipe da carta: ouros, copas e espadas
     */
    Card(int number, int simble, String naipe) {
        this.number = number;
        this.simbol = simble;
        this.naipe = naipe;
    }
}
