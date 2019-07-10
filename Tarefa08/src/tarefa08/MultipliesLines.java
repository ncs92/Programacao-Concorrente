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
public class MultipliesLines implements Callable<Integer> {

    private final Integer[][] matrix1;
    private final Integer[][] matrix2;
    private final int line;
    private final int sizeX;
    private final int coluna;

    public MultipliesLines(Integer[][] matrix1, Integer[][] matrix2, int line, int colum, int sizeX, int sizeY) {
        this.matrix1 = matrix1;
        this.matrix2 = matrix2;
        this.line = line;
        this.coluna = colum;
        this.sizeX = sizeX;
    }

    @Override
    public Integer call() {
        int soma = 0;
        for (int i = 0; i < sizeX; i++) {
            soma += matrix1[line][i] * matrix2[i][coluna];
        }
        return soma;
    }
}
