/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarefa10;

import java.util.concurrent.ConcurrentMap;

/**
 *
 * @author Elaine
 */
public class Letters extends Thread {

    Reader reader;
    ConcurrentMap<String, Integer> map;

    Letters(Reader reader, ConcurrentMap<String, Integer> map) {
        this.reader = reader;
        this.map = map;
    }
}
