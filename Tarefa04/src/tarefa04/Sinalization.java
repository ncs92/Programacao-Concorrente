/**
 1. Sinalização
 * Enviar sinal para outra thread para indicar que um evento ocorreu.
 Faça um código que uma thread t1 e t2 são inicializadas simultaneamente, 
 mas a t2 pode somente continuar a execução após a sinalização de t1.
 */

package tarefa04;


/**
 *
 * @author Elaine
 */

class ThreadT extends Thread {

    final String name;
    static int timeOfExec = 4000;
    Semaphore semaphore;

    public ThreadT(String name, Semaphore semaphore) {
        this.name = name;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {

            semaphore.P();       
            System.out.println("Thread " + name + " exec");
            Thread.sleep(timeOfExec);
            System.out.println("Thread " + name + " finish exec");
            semaphore.V();       

        } catch (Exception ex) {
            System.out.println("Err: " + ex);
        }
    }
}

public class Sinalization {

    public static void main(String[] args) {
        Semaphore semaphore = new BinarySemaphore();

        new ThreadT("T1", semaphore).start();
        new ThreadT("T2", semaphore).start();
    }
}
