/**
3.  Mutex (Exclusão Mútua)Garantir acesso exclusivo à seção crítica.
Faça um código que possibilite que 2 ou mais threads realizem o incremento de um contador.
Faça a exclusão mútua com semáforo.
 */

package tarefa04;

/**
 *
 * @author Elaine
 */

class ThreadTMutex extends Thread {

    Semaphore semaphore;
    static int counter = 0;

    ThreadTMutex(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            while(true) {

               semaphore.P();
                    System.out.println("Entering in Critial Section");
                        counter ++;            
                    System.out.println("Increment the counter " + Integer.toString(counter));
                    Thread.sleep(2000);
                semaphore.V();

                System.out.println("going out the critical section");
            }
        } catch (Exception ex) {
            System.out.println("Err: " + ex);
        }
    }
}

public class Mutex {

    public static void main(String []args) {

        Semaphore semaphore = new BinarySemaphore();       

        new ThreadTMutex(semaphore).start();
        new ThreadTMutex(semaphore).start();
        new ThreadTMutex(semaphore).start();
        new ThreadTMutex(semaphore).start();
        new ThreadTMutex(semaphore).start();
        new ThreadTMutex(semaphore).start();
        new ThreadTMutex(semaphore).start();
        new ThreadTMutex(semaphore).start();

    }
}
