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
public class BubbleSort implements Callable {

    Integer[] vect;

    BubbleSort(Integer[] vect) {
        this.vect = vect;
    }

    @Override
    public Object call() throws Exception {
        boolean change = true;
        int aux;
        while (change) {
            change = false;
            for (int i = 0; i < vect.length - 1; i++) {
                if (vect[i] > vect[i + 1]) {
                    aux = vect[i];
                    vect[i] = vect[i + 1];
                    vect[i + 1] = aux;
                    change = true;
                }
            }
        }
        return new ResultSave("BubbleSort", vect);
    }
}
