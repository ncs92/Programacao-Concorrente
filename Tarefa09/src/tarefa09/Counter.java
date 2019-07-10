/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarefa09;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Elaine
 */
public class Counter {

    Semaphore semaphore;
    int value;

    Counter() {
        this.semaphore = new Semaphore(1);
        this.value = 0;
    }

    // 0 - retorna o value
    // 1 - incrementa
    // 2 - decrementa
    public int value(int operacao) {
        try {
            semaphore.acquire();

            switch (operacao) {
                case 0:
                    return this.value;
                case 1:
                    this.value++;
                    break;
                case 2:
                    this.value--;
                    break;
            }
        } catch (Exception ex) {
            System.out.println("Error value: " + ex);
        } finally {
            semaphore.release();
        }
        return -1;
    }
}
