/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarefa08;

import java.io.File;
import java.util.Date;

/**
 *
 * @author Elaine
 */
public class VerifyFile implements Runnable {

    private long timeStamp;
    private File file;

    public VerifyFile(String fileName) {
        this.file = new File(fileName);
        this.timeStamp = file.lastModified();
    }

    public final void run() {
        try {
            while (true) {
                long timeStamp = file.lastModified();
                if (this.timeStamp != timeStamp) {
                    this.timeStamp = timeStamp;
                    onChange(file);
                }
                Thread.sleep(1000);
            }
        } catch (Exception ex) {
            System.out.println("Error: " + ex);
        }
    }

    void onChange(File file) {
        System.out.println("File " + file.getAbsolutePath() + " changed in: " + new Date(file.lastModified()));
    }
}
