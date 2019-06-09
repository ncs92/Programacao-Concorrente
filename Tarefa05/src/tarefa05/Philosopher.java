package Tarefa05;

/**
 *
 * @author Elaine
 */
class Philosopher implements Runnable {

    int id = 0;
    Resource fork = null;
    final int tecnica;


    public Philosopher(int initId, Resource initr, int technique) {
        id = initId;
        fork = initr;
        this.tecnica = technique;
    }
    
    @Override
    public void run() {
        try {
            if(tecnica == 1) {
                technique1();
            } else if(tecnica == 2) {
                technique2();
            } else if(tecnica == 3) {
                technique3();
            }
        } catch (Exception ex) {
            System.out.println("Err run: " + ex);
        }
    }

    private void technique1() {
        while (true) {
            try {
                System.out.println("Phil " + id + " thinking");
                Thread.sleep(3000);
                System.out.println("Phil " + id + " hungry");
                fork.pickup(id);
                System.out.println("Phil " + id + " eating");
                Thread.sleep(4000);
                fork.drop(id);
            } catch (InterruptedException e) {
                return;
            }
        }
    }

    private void technique2() throws InterruptedException {
        while (true) {
            try {
                System.out.println("Phil " + id + " thinking");
                Thread.sleep(3000);
                System.out.println("Phil " + id + " hungry");
                fork.pickup(id);
                System.out.println("Phil " + id + " eating");
                Thread.sleep(4000);
                fork.drop(id);
            } catch (InterruptedException e) {          
                Thread.sleep(1000);
                continue;                               
            }
        }
    }

    private void technique3() throws InterruptedException {
        while (true) {
            try {
                System.out.println("Phil " + id + " thinking");
                Thread.sleep(3000);
                System.out.println("Phil " + id + " hungry");
                fork.pickup(id);
                System.out.println("Phil " + id + " eating");
                Thread.sleep(4000);
                fork.drop(id);
            } catch (InterruptedException e) {          
                Thread.sleep(1000);
                continue;                       
            }
        }
    }
}
