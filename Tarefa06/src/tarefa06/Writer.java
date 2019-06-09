package tarefa06;

/**
 *
 * @author Elaine
 */
class Writer extends Thread {

    ArrayListThreadSafe array;

    Writer(ArrayListThreadSafe array) {
        this.array = array;
    }

    @Override
    public void run() {
        while(true) {
            array.write();
        }
    }
}
