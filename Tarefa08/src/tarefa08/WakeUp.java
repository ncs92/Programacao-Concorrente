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
public class WakeUp implements Callable {

    @Override
    public Object call() throws Exception {
        System.out.println("Wake up!");
        return null;
    }
}
