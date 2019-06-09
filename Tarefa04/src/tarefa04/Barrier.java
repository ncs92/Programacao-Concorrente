package tarefa04;


/**
5. Barreira Após n threads sincronizarem em um ponto em comum, um trecho específico (ponto crítico)
pode ser executado por cada uma delas.Faça um código que possibilite barrar N threads em um ponto 
específico de execução e, após todas alcançarem o ponto, todas devem executar o trecho de código 
após esse ponto.
 */

/**
 *
 * @author Elaine
 */

class ThreadBarrier extends Thread {

    Semaphore semaphoreBinary;
    Semaphore semaphoreZero;
    int n;
    static int qtdSleeping = 0;

    public ThreadBarrier(Semaphore semaphoreBinary, Semaphore semaphoreZero, int n) {
        this.semaphoreBinary = semaphoreBinary;
        this.semaphoreZero = semaphoreZero;
        this.n = n;
    }

    @Override
    public void run() {

        try {

            semaphoreBinary.P();
                qtdSleeping ++;
            semaphoreBinary.V();

            if(qtdSleeping < n-1) {
                semaphoreZero.P();
            } else {
                qtdSleeping --;
                semaphoreZero.V();
            }

            semaphoreZero.V();

        } catch (Exception ex) {
            System.out.println("Err: " + ex);
        }
    }
}

public class Barrier {

    public static void main(String[] args) {

        int n = 5;
        Semaphore semaphoreBinary = new CountingSemaphore(0);
        Semaphore semaphoreZero = new BinarySemaphore();

        new ThreadBarrier(semaphoreZero, semaphoreBinary, n).start();
        new ThreadBarrier(semaphoreZero, semaphoreBinary, n).start();
        new ThreadBarrier(semaphoreZero, semaphoreBinary, n).start();
        new ThreadBarrier(semaphoreZero, semaphoreBinary, n).start();
        new ThreadBarrier(semaphoreZero, semaphoreBinary, n).start();
        new ThreadBarrier(semaphoreZero, semaphoreBinary, n).start();
        new ThreadBarrier(semaphoreZero, semaphoreBinary, n).start();
        new ThreadBarrier(semaphoreZero, semaphoreBinary, n).start();
        new ThreadBarrier(semaphoreZero, semaphoreBinary, n).start();
    }
}
