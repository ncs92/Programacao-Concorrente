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
public class InsertionSort implements Callable {

    Integer[] vect;

    InsertionSort(Integer[] vect) {
        this.vect = vect;
    }

    @Override
    public Object call() throws Exception {
        int j;
        int key;
        int i;

        for (j = 1; j < vect.length; j++) {
            key = vect[j];
            for (i = j - 1; (i >= 0) && (vect[i] > key); i--) {
                vect[i + 1] = vect[i];
            }
            vect[i + 1] = key;
        }

        return new ResultSave("InsertionSort", vect);
    }
}
