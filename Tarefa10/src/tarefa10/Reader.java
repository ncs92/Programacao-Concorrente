/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarefa10;

import java.util.Scanner;
import java.util.concurrent.Semaphore;

/**
 *
 * @author Elaine
 */
public class Reader {

    Scanner scanner;
    Semaphore semaphore;
    int pointerInFile;

    Reader(Scanner scanner) {
        this.scanner = scanner;
        semaphore = new Semaphore(1);
    }

    String getNextLine() {
        String line = "-1";
        try {
            semaphore.acquire();
            if (scanner.hasNext()) {
                line = scanner.nextLine();
            }
        } catch (Exception ex) {
            System.out.println("Error getNextLine: " + ex);
        } finally {
            semaphore.release();
        }
        return line;
    }

}
