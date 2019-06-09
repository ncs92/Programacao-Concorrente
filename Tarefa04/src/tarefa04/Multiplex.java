/**
4. MultiplexGarantir acesso à seção crítica para no máximo N threads.
Faça um código que possibilite que N threads estejam na seção crítica simultaneamente.
 */

package tarefa04;

/**
 *
 * @author Elaine
 */

class CriticalSection extends Thread {

    Semaphore semaphore;

    public CriticalSection(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    @Override
    public void run() {

        try {
            semaphore.P();
            System.out.println("In Critical Section");
            Thread.sleep(1000);
            semaphore.V();
        } catch (Exception ex) {
            System.out.println("Err: " + ex);
        }
    }

}

public class Multiplex {

    public static void main(String[] args) {

        int n = 10;
        Semaphore semaphore = new CountingSemaphore(n);
        new CriticalSection(semaphore).start();
        new CriticalSection(semaphore).start();
        new CriticalSection(semaphore).start();
        new CriticalSection(semaphore).start();
        new CriticalSection(semaphore).start();
        new CriticalSection(semaphore).start();
        new CriticalSection(semaphore).start();
        new CriticalSection(semaphore).start();
        new CriticalSection(semaphore).start();
        new CriticalSection(semaphore).start();
        new CriticalSection(semaphore).start();
        new CriticalSection(semaphore).start();
        new CriticalSection(semaphore).start();
        new CriticalSection(semaphore).start();
        new CriticalSection(semaphore).start();
        new CriticalSection(semaphore).start();
        new CriticalSection(semaphore).start();
        new CriticalSection(semaphore).start();


    }
    
}
