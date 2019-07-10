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
public class SumLine implements Callable<Integer> {

    private final Integer[][] matrix;
    private final int line;
    private final int size;

    public SumLine(Integer[][] matrix, int line, int size) {
        this.matrix = matrix;
        this.line = line;
        this.size = size;
    }

    @Override
    public Integer call() {
        Integer sum = 0;
        for (int i = 0; i < size; i++) {
            sum += matrix[line][i];
        }
        return sum;
    }
}
