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
public class SelectionSort implements Callable {

    Integer[] vect;

    SelectionSort(Integer[] vect) {
        this.vect = vect;
    }

    @Override
    public Object call() throws Exception {
        for (int k = 0; k < vect.length - 1; k++) {
            int low = k;
            for (int i = low + 1; i < vect.length; i++) {
                if (vect[i] < vect[low]) {
                    low = i;
                }
            }
            if (low != k) {
                int t = vect[k];
                vect[k] = vect[low];
                vect[low] = t;
            }
        }
        return new ResultSave("SelectionSort", vect);
    }
}
