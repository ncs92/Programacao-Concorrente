/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarefa07;

/**
 *
 * @author Elaine
 */
public class Writer extends Thread {

    ArrayListThreadSafe array;

    Writer(ArrayListThreadSafe array) {
        this.array = array;
    }

    @Override
    public void run() {
        while (true) {
            array.write();
        }
    }
}
