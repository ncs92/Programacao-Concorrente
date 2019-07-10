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
public class ProcessLine implements Runnable {

    Reader reader;
    ConcurrentMap<String, Integer> map;

    ProcessLine(Reader reader, ConcurrentMap<String, Integer> map) {
        this.reader = reader;
        this.map = map;
    }

    private void processLine() {
        String line;
        do {
            line = reader.getNextLine();
            String[] words = line.split(" ");

            for (String word : words) {
                word = word.replace(",", "");
                word = word.replace(".", "");

                Integer qtd = 1;
                qtd += map.getOrDefault(word, 0);
                map.put(word, qtd);

            }
        } while (!line.equals("-1"));
    }

    @Override
    public void run() {
        processLine();
    }
}
