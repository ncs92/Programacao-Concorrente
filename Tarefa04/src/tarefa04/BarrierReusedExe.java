/**
6. Barreira ReusávelThreds em um laço executam uma série de passos e sincronizam em uma
 barreira a cada passo.Faça um código que implemente uma barreira reusável que feche a 
 si própria após todas as threads passarem.
 */

package tarefa04;

import java.util.Random;

/**
 *
 * @author Elaine
 */

class BarrierR {

    int qtdSync;     
    final int qtdTotal;

    public BarrierR(int qtdSync) {
        this.qtdTotal = qtdSync;
        this.qtdSync = qtdSync;
    }

   
    public synchronized void P() {
        try {
            qtdSync --;              

            if(qtdSync == 0) {       
                this.notifyAll();           
            } else {
                while(qtdSync > 0) { 
                    this.wait();            
                }
            }
        } catch (Exception ex) {
            System.out.println("Err: " + ex);
        }
    }
}

class ThreadDaBarreira extends Thread {

    final int timeOfProcess;
    final BarrierR barrier;

    ThreadDaBarreira(int timeOfProcess, BarrierR barrier) {
        this.timeOfProcess = timeOfProcess;
        this.barrier = barrier;
    }

    @Override
    public void run() {
        while(true) {

            try {
                System.out.println("Waiting all");
                barrier.P();
                System.out.println("Exec...");
                Thread.sleep(timeOfProcess*2);
            } catch (Exception ex) {
                System.out.println("Err: " + ex);
            }
        }
    }
}

public class BarrierReusedExe {

    public static void main(String[] args) {

        BarrierR barrier = new BarrierR(4);
        Random generator = new Random();

        new ThreadDaBarreira(1000 + generator.nextInt(1000), barrier).start();
        new ThreadDaBarreira(1000 + generator.nextInt(1000), barrier).start();
        new ThreadDaBarreira(1000 + generator.nextInt(1000), barrier).start();
        new ThreadDaBarreira(1000 + generator.nextInt(1000), barrier).start();
    }
}
