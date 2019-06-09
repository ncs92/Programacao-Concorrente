package tarefa04;

/**
 *
 * @author Elaine
 */

interface Semaphore {

    public void P();    
    public void V();   

}

class BinarySemaphore implements Semaphore {

    private boolean value;

    public BinarySemaphore() {
        this.value = true;
    }


    @Override
    public synchronized void P() {
        while(value == false) {     
            try {
                this.wait();        
            } catch (InterruptedException ex) {
                System.out.println("Err P: " + ex);
            }
        }

        value = false;              
    }

    
    @Override
    public synchronized void V() {
        value = true;       
        this.notifyAll();   
    }
}

class CountingSemaphore implements Semaphore {

    private int value;

    CountingSemaphore(int valor) {
        this.value = valor;
    }

    @Override
    public synchronized void P() {
        try {
            while(value == 0) {    
                this.wait();
            }
        } catch (InterruptedException ex) {
            System.out.println("Err V: " + ex);
        }

        value --;                   
    }

    @Override
    public synchronized void V() {
        value ++;                   
        this.notifyAll();           
    }
}
