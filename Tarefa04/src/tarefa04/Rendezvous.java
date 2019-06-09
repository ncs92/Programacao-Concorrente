/**
2.  Rendezvous (Encontro)Enviar sinalização para um ponto de encontro entre threads.
Faça um código que uma thread t1 e t2 são inicializadas e t1 espera por t2 e vice-versa.
Exemplo:
    t1:
        trecho1.1
        trecho1.2
    t2:
        trecho2.1
        trecho2.2
    thecho1.1 ocorre antes trecho2.2 e threcho2.1 ocorre antes de trecho1.2.
 */

package tarefa04;

/**
 *
 * @author Elaine
 */
class ThreadRendezvous extends Thread {

    final String name;
    Semaphore semaphore1;
    Semaphore semaphore2;

    ThreadRendezvous (String name, Semaphore semaphore1, Semaphore semaphore2) {
        this.name = name;
        this.semaphore1 = semaphore1;
        this.semaphore2 = semaphore2;
    }

    @Override
    public void run() {
        try {

            while(true) {
                if("1".equals(name)) {
                    patch11();
                    Thread.sleep(2000);
                    patch12();
                    Thread.sleep(2000);
                } else {
                    patch21();
                    Thread.sleep(2000);
                    patch22();
                    Thread.sleep(2000);
                }
            }
        } catch (Exception ex) {
            System.out.println("Err: " + ex);
        }
    }

    private void patch11(){
        semaphore2.P();
        System.out.println("patch 11");
        semaphore2.V();
    }

    private void patch12(){
        semaphore1.P();
        System.out.println("patch 12");
        semaphore1.V();
    }

    private void patch21(){
        semaphore1.P();
        System.out.println("patch 21");
        semaphore1.V();
    }

    private void patch22(){
        semaphore2.P();
        System.out.println("patch 22");
        semaphore2.V();
    }
}

public class Rendezvous {

    public static void main(String[] args) {

        Semaphore semaphore1 = new BinarySemaphore();
        Semaphore semaphore2 = new BinarySemaphore();

        new ThreadRendezvous("1", semaphore1, semaphore2).start();
        new ThreadRendezvous("2", semaphore1, semaphore2).start();
    }
}
