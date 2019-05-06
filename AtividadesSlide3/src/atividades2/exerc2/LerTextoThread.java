/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atividades2.exerc2;

import atividades2.exerc1.*;
import atividades1.exerc2.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Elaine
 */
public class LerTextoThread extends Thread {
    @Override
    public void run(){
        File f = new File("C:\\Users\\Elaine\\Documents\\GitHub\\ProgramacaoConcorrente\\AtividadesSlide3\\src\\atividades2\\exerc2\\texto.txt");
        try {
            BufferedReader read = new BufferedReader(new FileReader(f));
            String texto;
            while((texto = read.readLine()) != null) {
                System.out.println(texto);
                Thread.sleep(1000);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LerTextoThread.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(LerTextoThread.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(LerTextoThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String args[]) {
        new LerTextoThread().start();
    }
    
}
