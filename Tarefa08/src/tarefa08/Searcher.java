/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarefa08;

import java.util.concurrent.Callable;

/**
 *
 * @author Elaine
 */
public class Searcher implements Callable<Integer> {

    private final int posInit;
    private final int posFinal;
    private final Integer[] ve;

    public Searcher(int posInit, int posFinal, Integer[] ve) {
        this.posInit = posInit;
        this.posFinal = posFinal;
        this.ve = ve;
    }

    @Override
    public Integer call() {
        Integer maxValue = 0;
        for (int i = posInit; i < posFinal; i++) {
            if (ve[i] > maxValue) {
                maxValue = ve[i];
            }
        }
        return maxValue;
    }
}
